package com.ellection.service.impl;

import com.ellection.configs.CustomAuth;
import com.ellection.configs.MailConfig;
import com.ellection.models.Authority;
import com.ellection.models.CurrentUser;
import com.ellection.models.Position;
import com.ellection.models.User;
import com.ellection.repository.AuthorityRepository;
import com.ellection.repository.PositionRepository;
import com.ellection.repository.UserRepository;
import com.ellection.service.CandidateService;
import com.ellection.service.ImageService;
import com.ellection.service.PositionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

/**
 * Created by faos7 on 31.03.17.
 */

@Service
public class CandidateServiceImpl implements CandidateService{

    private static final Logger LOGGER = LoggerFactory.getLogger(CandidateService.class);


    UserRepository userRepository;
    ImageService imageService;
    PositionRepository positionRepository;
    AuthorityRepository authorityRepository;

    MailConfig ctx = new MailConfig();

    @Autowired
    public CandidateServiceImpl(UserRepository userRepository, ImageService imageService,
                                PositionRepository positionRepository, AuthorityRepository authorityRepository) {
        this.userRepository = userRepository;
        this.imageService = imageService;
        this.positionRepository = positionRepository;
        this.authorityRepository = authorityRepository;
    }

    public User activate(String email, String username, String password, String firstName,
                         String secondName, String thirdName, String activationKey){
        Authority authority = authorityRepository.findOne("ROLE_USER");
        User user = new User(email, username, new BCryptPasswordEncoder().encode(password), firstName,
                secondName, thirdName, activationKey, authority);
        if (user.getActivationKey().equals(activationKey)){
            user.setActivated(true);
            userRepository.save(user);
            return user;
        }
        return null;
    }

    @Override
    public User save(String email, String username, String password, String firstName,
                     String secondName, String thirdName) {
        CustomAuth pass = new CustomAuth();
        String activationKey = pass.generate();
        Authority authority = authorityRepository.findOne("ROLE_USER");
        User user = new User(email, username, new BCryptPasswordEncoder().encode(password), firstName,
                secondName, thirdName, activationKey, authority);
        try {
            JavaMailSender mailSender = ctx.javaMailSender();
            SimpleMailMessage templateMessage = new SimpleMailMessage(ctx.templateMassege());
            templateMessage.setTo(user.getUsername());
            templateMessage.setText("Your activation code is " +activationKey );
            mailSender.send(templateMessage);

        }catch (MailException ex){
            LOGGER.debug("FAILED to send message", ex.getStackTrace());
        }

        return user;
    }

    @Override
    public User setFoto(MultipartFile file, Long id) {
        User user = userRepository.findOne(id);
        String foto = imageService.encodeToString(file);
        if (!foto.equals("nofile")){
            user.setFoto(foto);
        }
        return userRepository.save(user);
    }

    @Override
    public void addCandidateToPosition(String username, String role) {
            User user = userRepository.findOneByUsername(username).get();
            Position position = positionRepository.findOneByName(role).get();
            user.addCandidateToPositionPull(position.addCandidatetoPull(user));
            userRepository.save(user);
            positionRepository.save(position);
    }

    @Override
    public void removeCandidateFromPosition(String username, String role) {
        User user = userRepository.findOneByUsername(username).get();
        Position position = positionRepository.findOneByName(role).get();
        user.removeCandidateFromPositionPull(position.removeCandidateFromPull(user));
        userRepository.save(user);
        positionRepository.save(position);
    }

    @Override
    public void voteFor(CurrentUser currentUser, String username, String name) {
        User user = userRepository.findOneByUsername(username).get();
        Position position = positionRepository.findOneByName(name).get();
        if(!currentUser.getUser().getVotingPull().contains(position)){
            currentUser.getUser().addToVotesSet(position.VoteForCandidate(user));
        }
        userRepository.save(user);
        userRepository.save(currentUser.getUser());
        positionRepository.save(position);
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findOneByUsername(username).get();
    }
}

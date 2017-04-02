package com.ellection.service.impl;

import com.ellection.models.CurrentUser;
import com.ellection.models.Position;
import com.ellection.models.User;
import com.ellection.repository.PositionRepository;
import com.ellection.repository.UserRepository;
import com.ellection.service.CandidateService;
import com.ellection.service.ImageService;
import com.ellection.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;

/**
 * Created by faos7 on 31.03.17.
 */

@Service
public class CandidateServiceImpl implements CandidateService{

    UserRepository userRepository;
    ImageService imageService;
    PositionRepository positionRepository;

    @Autowired
    public CandidateServiceImpl(UserRepository userRepository, ImageService imageService,
                                PositionRepository positionRepository) {
        this.userRepository = userRepository;
        this.imageService = imageService;
        this.positionRepository = positionRepository;
    }

    @Override
    public User save(String firstName, String secondName, String thirdName, String username, String password) {
        User user = new User(firstName,secondName,thirdName, username, password);
        return null;
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

package com.ellection.service;

import com.ellection.models.CurrentUser;
import com.ellection.models.User;
import org.omg.CORBA.Current;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;

/**
 * Created by faos7 on 30.03.17.
 */
public interface CandidateService {
    User save(String email, String username, String password, String firstName,
                     String secondName, String thirdName);
    User activate(String email, String username, String password, String firstName,
                  String secondName, String thirdName, String activationKey);
    User setFoto(MultipartFile file, Long id);
    void addCandidateToPosition(String username, String role);
    void removeCandidateFromPosition(String username, String role);
    void voteFor(CurrentUser currentUser, String username, String name);

    User getUserByUsername(String username);
}

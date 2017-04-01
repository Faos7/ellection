package com.ellection.service;

import com.ellection.models.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;

/**
 * Created by faos7 on 30.03.17.
 */
public interface CandidateService {
    User save(String firstName, String secondName, String thirdName, String username, String password);
    User setFoto(MultipartFile file, Long id);
    void addCandidateToPosition(String username, String role);
    void removeCandidateFromPosition(String username, String role);
}

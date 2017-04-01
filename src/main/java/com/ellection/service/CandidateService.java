package com.ellection.service;

import com.ellection.models.Candidate;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.Multipart;
import java.util.Collection;

/**
 * Created by faos7 on 30.03.17.
 */
public interface CandidateService {
    Collection<Candidate> getAllCandidates();
    Candidate getOneById(Long id);
    Candidate save( MultipartFile file, String firstName, String secondName, String thirdName);

}

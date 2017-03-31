package com.ellection.service;

import com.ellection.models.Candidate;

import java.util.Collection;

/**
 * Created by faos7 on 30.03.17.
 */
public interface CandidateService {
    Collection<Candidate> getAllCandidates();
    Candidate getOneById(Long id);


}

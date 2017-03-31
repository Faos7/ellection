package com.ellection.service;

import com.ellection.models.Candidate;
import com.ellection.models.Position;
import java.util.Collection;

/**
 * Created by faos7 on 30.03.17.
 */
public interface PositionService {
    Position getPosById(Long id);
    Collection<Candidate> getAllCandidatesForPosition();

    Position create(String name, String place);
    Candidate getWinner(String name);
    void setWinner(String name);
}

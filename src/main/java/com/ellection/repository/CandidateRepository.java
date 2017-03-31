package com.ellection.repository;

import com.ellection.models.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

/**
 * Created by faos7 on 30.03.17.
 */

@Transactional
public interface CandidateRepository extends JpaRepository<Candidate, Long> {
}

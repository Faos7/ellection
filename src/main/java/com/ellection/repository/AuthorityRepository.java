package com.ellection.repository;

import com.ellection.models.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by faos7 on 02.04.17.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {
}

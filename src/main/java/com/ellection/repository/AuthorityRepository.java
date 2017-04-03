package com.ellection.repository;

import com.ellection.models.Authority;
import com.ellection.models.Position;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by faos7 on 02.04.17.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {

    Optional<Authority> findOneByName(String name);

}

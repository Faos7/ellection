package com.ellection.repository;

import com.ellection.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

/**
 * Created by faos7 on 30.03.17.
 */

@Transactional
public interface UserRepository extends JpaRepository<User, Long>{
}

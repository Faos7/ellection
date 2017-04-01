package com.ellection.repository;

import com.ellection.models.Position;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * Created by faos7 on 30.03.17.
 */
@Transactional
public interface PositionRepository extends JpaRepository<Position, Long>{
    Optional<Position> findOneByName(String name);
}

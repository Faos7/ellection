package com.ellection.service.impl;

import com.ellection.models.User;
import com.ellection.models.Candidates_Pull;
import com.ellection.models.Position;
import com.ellection.repository.PositionRepository;
import com.ellection.service.PositionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by faos7 on 01.04.17.
 */
@Service
public class PositionServiceImpl implements PositionService {


    private static final Logger LOGGER = LoggerFactory.getLogger(PositionService.class);

    private final PositionRepository positionRepository;

    @Autowired
    public PositionServiceImpl(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    @Override
    public Position getPosById(Long id) {
        return positionRepository.getOne(id);
    }

    @Override
    public Position getPosByName(String name) {
        return positionRepository.findOneByName(name).get();
    }

    @Override
    public Position create(String name) {
        Position position = new Position(name);
        return positionRepository.save(position);
    }

    @Override
    public User getWinner(String name) {
        LOGGER.debug("Calculating winner");
        Position position = positionRepository.findOneByName(name).get();
        Collection<Candidates_Pull> candidatesPull = position.getCandidates_pull();
        Candidates_Pull cp = new Candidates_Pull();
        cp.setVoices(0);
        for (Candidates_Pull pull : candidatesPull){
            if (pull.getVoices() > cp.getVoices()){
                cp = pull;
            }
        }

        return cp.getUser();
    }

    @Override
    public Position remove(String name) {
        Position position = positionRepository.findOneByName(name).get();
        positionRepository.delete(position);
        return position;
    }

    @Override
    public void setWinner(String name) {

    }


}

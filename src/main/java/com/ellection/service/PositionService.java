package com.ellection.service;

import com.ellection.models.User;
import com.ellection.models.Position;

/**
 * Created by faos7 on 30.03.17.
 */
public interface PositionService {
    Position getPosById(Long id);
    Position getPosByName(String name);

    Position create(String name);
    User getWinner(String name);
    void setWinner(String name);
    Position remove(String name);
}

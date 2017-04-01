package com.ellection.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by faos7 on 31.03.17.
 */
@Entity
public class Candidates_Pull implements Serializable{

    @Id
    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "position_id")
    @JsonIgnore
    private Position position;

    @Column
    private int voices;

    public Candidates_Pull() {
    }

    public Candidates_Pull(User user, Position position, int voices) {
        this.user = user;
        this.position = position;
        this.voices = voices;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getVoices() {
        return voices;
    }

    public void setVoices(int voices) {
        this.voices = voices;
    }
}

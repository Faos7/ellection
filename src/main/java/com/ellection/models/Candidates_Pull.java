package com.ellection.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by faos7 on 31.03.17.
 */
@Entity
public class Candidates_Pull implements Serializable{

    @Id
    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

    @Id
    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position position;

    @Column
    private int voices;

    public Candidates_Pull(Candidate candidate, Position position, int voices) {
        this.candidate = candidate;
        this.position = position;
        this.voices = voices;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
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

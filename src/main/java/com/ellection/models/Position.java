package com.ellection.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Created by faos7 on 30.03.17.
 */

@Entity
@Table(name = "position")
public class Position implements Serializable {

    @Id
    @SequenceGenerator(name="pos_sequence",sequenceName="pos_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pos_sequence")
    @Column(name="id", unique=true, nullable=false)
    private Long id;

    @Column
    private String name;

    @Column
    private String place;

    @Column
    private Candidate winner;

    @OneToMany(mappedBy = "position", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Candidates_Pull>  candidates_pull;


    /*@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "candidate_pull", joinColumns = @JoinColumn(name = "pos_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "cand_id", referencedColumnName = "id"))
    private List<Candidate> candidates_pull;*/

    public Position(String name, String place) {
        this.name = name;
        this.place = place;
    }

    public Position(String name, String place, Set<Candidates_Pull> candidates_pull) {
        this.name = name;
        this.place = place;
        this.candidates_pull = candidates_pull;
    }
/*
    public void addCandidateToPull(Candidate candidate){
        candidates_pull.add(candidate);
    }
*/
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Candidate getWinner() {
        return winner;
    }

    public void setWinner(Candidate winner) {
        this.winner = winner;
    }

    public Set<Candidates_Pull> getCandidates_pull() {
        return candidates_pull;
    }

    public void setCandidates_pull(Set<Candidates_Pull> candidates_pull) {
        this.candidates_pull = candidates_pull;
    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", place='" + place + '\'' +
                ", winner=" + winner +
                //", candidates_pull=" + candidates_pull +
                '}';
    }
}

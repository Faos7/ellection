package com.ellection.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by faos7 on 30.03.17.
 */

@Entity
@Table
public class Position implements Serializable {

    @Id
    @SequenceGenerator(name="pos_sequence",sequenceName="pos_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pos_sequence")
    @Column(name="id", unique=true, nullable=false)
    private Long id;

    @Column
    private String name;

    @Column
    private User winner;

    @OneToMany(mappedBy = "position", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Candidates_Pull>  candidates_pull;


    /*@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "candidate_pull", joinColumns = @JoinColumn(name = "pos_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "cand_id", referencedColumnName = "id"))
    private List<User> candidates_pull;*/

    public Position() {
    }

    public Position(String name) {
        this.name = name;
    }

    public Position(String name, Set<Candidates_Pull> candidates_pull) {
        this.name = name;
        this.candidates_pull = candidates_pull;
    }
/*
    public void addCandidateToPull(User candidate){
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

    public User getWinner() {
        return winner;
    }

    public void setWinner(User winner) {
        this.winner = winner;
    }

    public Candidates_Pull addCandidatetoPull(User user){
        Candidates_Pull cp = new Candidates_Pull(user, this, 0);
        candidates_pull.add(cp);
        return cp;
    }

    public Candidates_Pull removeCandidateFromPull(User user){
        for (Candidates_Pull cp : candidates_pull){
            if (cp.getPosition().equals(this) && cp.getUser().equals(user)){
                candidates_pull.remove(cp);
                return cp;
            }
        }
        return null;
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
                ", name='" + name + '\'' +
                ", winner=" + winner +
                //", candidates_pull=" + candidates_pull +
                '}';
    }
}

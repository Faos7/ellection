package com.ellection.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;;

/**
 * Created by faos7 on 30.03.17.
 */
@Entity
@Table(name = "candidate")
public class Candidate implements Serializable{

    @Id
    @SequenceGenerator(name="cand_sequence",sequenceName="cand_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="cand_sequence")
    @Column(name="id", unique=true, nullable=false)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "third_name")
    private String thirdName;

    @Column
    private String foto;

    @Column
    private Long mainVotesNumber;

    @Column
    private Long secVoiceNumber;


    @ManyToMany(mappedBy = "candidates_pull")
    private Set<Position> positionsPull;

    public Candidate(String firstName, String secondName, String thirdName,
                     String foto, Set<Position> positionsPull) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.thirdName = thirdName;
        this.foto = foto;
        this.mainVotesNumber = 0L;
        this.secVoiceNumber = 0L;
        this.positionsPull = positionsPull;
    }

    public void addToPositionPull(Position position){
        positionsPull.add(position);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getThirdName() {
        return thirdName;
    }

    public void setThirdName(String thirdName) {
        this.thirdName = thirdName;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Long getMainVotesNumber() {
        return mainVotesNumber;
    }

    public void setMainVotesNumber(Long mainVotesNumber) {
        this.mainVotesNumber = mainVotesNumber;
    }

    public Long getSecVoiceNumber() {
        return secVoiceNumber;
    }

    public void setSecVoiceNumber(Long secVoiceNumber) {
        this.secVoiceNumber = secVoiceNumber;
    }
    public Set<Position> getPositionsPull() {
        return positionsPull;
    }

    public void setPositionsPull(Set<Position> positionsPull) {
        this.positionsPull = positionsPull;
    }


}

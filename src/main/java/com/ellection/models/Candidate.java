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

    @Lob
    @Column(columnDefinition="bytea")
    private byte[] image;

    @Column
    private Long mainVotesNumber;

    @Column
    private Long secVoiceNumber;

/*
    @ManyToMany(mappedBy = "candidates_pull")
    private Set<Position> positionsPull;
*/

    @OneToMany(mappedBy = "candidate")
    public Set<Candidates_Pull> positionsPull;

    public Candidate(String firstName, String secondName, String thirdName,
                     byte[] image, Set<Candidates_Pull> positionsPull) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.thirdName = thirdName;
        this.image = image;
        this.mainVotesNumber = 0L;
        this.secVoiceNumber = 0L;
        this.positionsPull = positionsPull;
    }
/*
    public void addToPositionPull(Position position){
        positionsPull.add(position);
    }
*/
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
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


    public Set<Candidates_Pull> getPositionsPull() {
        return positionsPull;
    }

    public void setPositionsPull(Set<Candidates_Pull> positionsPull) {
        this.positionsPull = positionsPull;
    }
}

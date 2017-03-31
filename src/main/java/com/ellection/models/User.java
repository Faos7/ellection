package com.ellection.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by faos7 on 30.03.17.
 */
@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @SequenceGenerator(name="pk_sequence",sequenceName="user_id_seq", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator="pk_sequence")
    @Column(name="id", unique=true, nullable=false)
    private Long id;

    @Column
    private Long StudentCardId;

    @Column
    private Boolean votedForDNU;

    @Column
    private Boolean votedForFaculty;

    public User(Long studentCardId) {
        StudentCardId = studentCardId;
        this.votedForDNU = false;
        this.votedForFaculty = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentCardId() {
        return StudentCardId;
    }

    public void setStudentCardId(Long studentCardId) {
        StudentCardId = studentCardId;
    }

    public Boolean getVotedForDNU() {
        return votedForDNU;
    }

    public void setVotedForDNU(Boolean votedForDNU) {
        this.votedForDNU = votedForDNU;
    }

    public Boolean getVotedForFaculty() {
        return votedForFaculty;
    }

    public void setVotedForFaculty(Boolean votedForFaculty) {
        this.votedForFaculty = votedForFaculty;
    }
}

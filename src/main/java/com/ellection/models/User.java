package com.ellection.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by faos7 on 30.03.17.
 */
@Entity
@Table(name = "candidate")
public class User implements Serializable{

    @Id
    @SequenceGenerator(name="cand_sequence",sequenceName="cand_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="cand_sequence")
    @Column(name="id", unique=true, nullable=false)
    private Long id;

    @Email
    @Size(min = 0, max = 50)
    private String email;

    @Column
    private String username;

    @Column
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "third_name")
    private String thirdName;

    @Column
    private String foto;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    public Set<Candidates_Pull> positionsPull;

    @JsonIgnore
    @OneToMany
    public Set<Position> votingPull;

    private boolean activated;

    @Size(min = 0, max = 100)
    @Column(name = "activationkey")
    private String activationKey;

    @Size(min = 0, max = 100)
    @Column(name = "resetpasswordkey")
    private String resetPasswordKey;

    @ManyToMany
    @JoinTable(
            name = "user_authority",
            joinColumns = @JoinColumn(name = "username"),
            inverseJoinColumns = @JoinColumn(name = "authority"))
    private Set<Authority> authorities;

    public User() {
    }

    public User(String firstName, String secondName, String thirdName, String username, String password) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.secondName = secondName;
        this.thirdName = thirdName;
    }
/*
    public void addToPositionPull(Position position){
        positionsPull.add(position);
    }
*/

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public String getActivationKey() {
        return activationKey;
    }

    public void setActivationKey(String activationKey) {
        this.activationKey = activationKey;
    }

    public String getResetPasswordKey() {
        return resetPasswordKey;
    }

    public void setResetPasswordKey(String resetPasswordKey) {
        this.resetPasswordKey = resetPasswordKey;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

    public Set<Position> getVotingPull() {
        return votingPull;
    }

    public void setVotingPull(Set<Position> votingPull) {
        this.votingPull = votingPull;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void addCandidateToPositionPull(Candidates_Pull cp){
        positionsPull.add(cp);
    }

    public void addToVotesSet(Candidates_Pull candidates_pull){
        votingPull.add(candidates_pull.getPosition());
    }

    public void removeCandidateFromPositionPull(Candidates_Pull cp){
        positionsPull.remove(cp);
    }

    public Set<Candidates_Pull> getPositionsPull() {
        return positionsPull;
    }

    public void setPositionsPull(Set<Candidates_Pull> positionsPull) {
        this.positionsPull = positionsPull;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!username.equals(user.username)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return username.hashCode();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", secondName='" + secondName + '\'' +
                ", thirdName='" + thirdName + '\'' +
                ", foto='" + foto + '\'' +
                ", positionsPull=" + positionsPull +
                ", votingPull=" + votingPull +
                ", activated=" + activated +
                ", activationKey='" + activationKey + '\'' +
                ", resetPasswordKey='" + resetPasswordKey + '\'' +
                ", authorities=" + authorities +
                '}';
    }
}

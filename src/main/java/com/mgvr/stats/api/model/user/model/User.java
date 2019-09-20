package com.mgvr.stats.api.model.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mgvr.stats.api.model.kudo.model.Kudo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue
    private int id;
    private String nickName;
    private String realName;
    @JsonIgnore
    private String email;
    @Transient
    private List<Kudo> kudos;
    private int nroKudos;

    public List<Kudo> getKudos() {
        return kudos;
    }

    public void setKudos(List<Kudo> kudos) {
        this.kudos = kudos;
    }

    public String getNickName() {
        return nickName;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    public String getRealName() {
        return realName;
    }
    public void setRealName(String realName) {
        this.realName = realName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getId() {
        return id;
    }
    public int getNroKudos() {
        return nroKudos;
    }

    public void setNroKudos(int nroKudos) {
        this.nroKudos = nroKudos;
    }
}

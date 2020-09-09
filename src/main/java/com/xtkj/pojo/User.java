package com.xtkj.pojo;

public class User {

    private Integer tbUserid;

    private String tbUsername;

    private Double tbUsermoney;

    public Integer getTbUserid() {
        return tbUserid;
    }

    public void setTbUserid(Integer tbUserid) {
        this.tbUserid = tbUserid;
    }

    public String getTbUsername() {
        return tbUsername;
    }

    public void setTbUsername(String tbUsername) {
        this.tbUsername = tbUsername == null ? null : tbUsername.trim();
    }

    public Double getTbUsermoney() {
        return tbUsermoney;
    }

    public void setTbUsermoney(Double tbUsermoney) {
        this.tbUsermoney = tbUsermoney;
    }
}
package com.leo.redis.domain;

/**
 * Created by Leo on 2020/1/14.
 * Description :
 */
public class Province {

    private int id;
    private String NAME;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    @Override
    public String toString() {
        return "Province{" +
                "id=" + id +
                ", NAME='" + NAME + '\'' +
                '}';
    }
}

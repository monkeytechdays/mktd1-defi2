package com.monkeypatch.mktd.feignvsretrofit.exo2.model;

public class Monkey {

    public enum Gender {MALE, FEMALE}

    private String id;
    private String name;
    private int age;
    private Gender gender;
    private String raceId;


    @Override
    public String toString() {
        return String.format("Monkey{id=%s, name='%s'}", id, name);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getRaceId() {
        return raceId;
    }

    public void setRaceId(String raceId) {
        this.raceId = raceId;
    }
}

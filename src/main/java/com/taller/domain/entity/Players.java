package com.taller.domain.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Players {
    private static final long serialVersionUID = 1L;
    @JsonProperty("dorsal")
    private int dorsal;
    @JsonProperty("name")
    private String name;
    @JsonProperty("nationality")
    private String nationality;
    @JsonProperty("age")
    private int age;
    @JsonProperty("height")
    private int height;
    @JsonProperty("weight")
    private int weight;
    @JsonProperty("position")
    private String position;

    public Players() {
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Players(int dorsal, String name, String nationality, int age, int height, int weight, String position) {
        this.dorsal = dorsal;
        this.name = name;
        this.nationality = nationality;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.position = position;
    }

    @Override
    public String toString() {
        return "\nJugadores: \n Dorsal: " + dorsal + "\n Nombre:" + name + "\n Nacionalidad: " + nationality + "\n Edad: "
                + age
                + "\n Height: " + height + "\n Weight=" + weight + "\n Posicion:" + position;
    }

}

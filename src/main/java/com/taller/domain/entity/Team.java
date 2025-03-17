package com.taller.domain.entity;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Team {

    private static final long serialVersionUID = 1L;
    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("yearfoundation")
    private int yearfoundation;
    @JsonProperty("statistics")
    private List<Estadisticas> statistics;
    @JsonProperty("players")
    private List<Players> players;
    @JsonProperty("coach")
    private String coach;

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Team() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearfoundation() {
        return yearfoundation;
    }

    public void setYearfoundation(int yearfoundation) {
        this.yearfoundation = yearfoundation;
    }

    public List<Estadisticas> getStatistics() {
        return statistics;
    }

    public void setStatistics(List<Estadisticas> statistics) {
        this.statistics = statistics;
    }

    public List<Players> getPlayers() {
        return players;
    }

    public void setPlayers(List<Players> players) {
        this.players = players;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public Team(int id, String name, int yearfoundation, List<Players> players, String coach) {
        this.id = id;
        this.name = name;
        this.yearfoundation = yearfoundation;
        this.players = players;
        this.coach = coach;
    }

}

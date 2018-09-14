package com.github.brscherer.core_engineering.homework_9.models;

import java.util.List;

public class CharacterModel {
    private String name;
    private String gender;
    private List<String> titles;
    private List<String> aliases;
    private List<String> playedBy;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<String> getTitles() {
        return titles;
    }

    public void setTitles(List<String> titles) {
        this.titles = titles;
    }

    public List<String> getAliases() {
        return aliases;
    }

    public void setAliases(List<String> aliases) {
        this.aliases = aliases;
    }

    public List<String> getPlayedBy() {
        return playedBy;
    }

    public void setPlayedBy(List<String> playedBy) {
        this.playedBy = playedBy;
    }
}

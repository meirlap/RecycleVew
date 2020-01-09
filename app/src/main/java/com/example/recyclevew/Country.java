package com.example.recyclevew;

public class Country {
    private String name;
    private  Long population;
    private int FlagResId;
    private  Boolean IsGood;

    public Country() {
    }

    public Country(String name, Long population, int flagResId, Boolean isGood) {
        this.name = name;
        this.population = population;
        FlagResId = flagResId;
        IsGood = isGood;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public int getFlagResId() {
        return FlagResId;
    }

    public void setFlagResId(int flagResId) {
        FlagResId = flagResId;
    }

    public Boolean getGood() {
        return IsGood;
    }

    public void setGood(Boolean good) {
        IsGood = good;
    }
}

package com.driver;

public class Movie {
    // From question  String name, int durationInMinutes,
    // double imdbRating, no-args constructor, all-args constructor and getters-setters

    //Declaring private variable
    private String name;
    private int durationInMinutes;
    private double imdbRating;


    /////making getter and setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public double getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(double imdbRating) {
        this.imdbRating = imdbRating;
    }

    ////Getter setter complete


    ///Making consturctor

    public Movie() {
    }


    public Movie(String name, int durationInMinutes, double imdbRating) {
        this.name = name;
        this.durationInMinutes = durationInMinutes;
        this.imdbRating = imdbRating;
    }

    //Blank constructor


}

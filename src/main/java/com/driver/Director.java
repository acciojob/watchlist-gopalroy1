package com.driver;

public class Director {
    //From question
    //String name, int numberOfMovies, double imdbRating,
    // no-args constructor, all-args constructor and getters-setters

    //Declaring variable for this class
    private String name;
    private int numberOfMovies;
    private double imdbRating;

    ////Making getter and setter for all

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfMovies() {
        return numberOfMovies;
    }

    public void setNumberOfMovies(int numberOfMovies) {
        this.numberOfMovies = numberOfMovies;
    }

    public double getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(double imdbRating) {
        this.imdbRating = imdbRating;
    }
    ///Getter and setter complete

    //making constructor
    public Director(){

    }

    public Director(String name, int numberOfMovies, double imdbRating) {
        this.name = name;
        this.numberOfMovies = numberOfMovies;
        this.imdbRating = imdbRating;
    }
}

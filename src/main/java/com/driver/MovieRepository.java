package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@Repository
public class MovieRepository {

    HashMap<String, Movie> movieMap = new HashMap<>();
    HashMap<String,Director> directorMap = new HashMap<>();
    HashMap<Director,List<Movie>> directorMoviePair = new HashMap<>();
    //Adding movie post function logic
    public String addMovie( Movie movie){
        if(!movieMap.containsKey(movie.getName())) {
            movieMap.put(movie.getName(), movie);
            return "movie added sucessfully";
        }
        else
            return "movie already exists";

    }

    //Adding director post function logic
    public String addDirector(Director director){
        if(!directorMap.containsKey(director.getName())) {
            directorMap.put(director.getName(), director);
            return "Director added sucessfully";
        }
        return "director already present";
    }


    //paring movie and director pair
    public String addMovieDirectorPair( String movie_name,  String director_name){
        /// First check if director and movie exists or not
        Movie movie = new Movie();
        boolean found = false;
        for(String movieName : movieMap.keySet()){
            if(movieName.equals(movie_name)){
                movie= movieMap.get(movieName);
                found = true;
            }
        }
        if(found ==false){
            return "movie does not exists";
        }
        Director director = new Director();
        boolean directorFound= false;
        for (String directorName : directorMap.keySet()){
            if(directorName.equals(director_name)){
                director= directorMap.get(directorName);
                directorFound=true;
            }
        }
        if(directorFound==false){
            return "Director not found";
        }
        //When director is not present then add both director and movie in the map
        if(!directorMoviePair.containsKey(director)){
            List<Movie> movieList = new LinkedList<>();
            movieList.add(movie);
            directorMoviePair.put(director,movieList);
            return "director and movie added sucessfully";
        }
        ///When director is already present in the Director movie pair get director and add movie in the existing list
        directorMoviePair.get(director).add(movie);
        return "movie added sucessfully";

    }

    //getting movie by name
    public Movie getMovieByName(String name){
        if(!movieMap.containsKey(name)){
            return null;
        }
        return movieMap.get(name);
    }

    //Getting director by name
    public Director getDirectorByName( String name) {
        if(!directorMap.containsKey(name)){
            return null;
        }
        return directorMap.get(name);
    }

    //Getting list of movie by director name

    public List getMoviesByDirectorName(String director_name){
        List<Movie> movieList = new LinkedList<>();
        //checking if director exists or not
        Director director = new Director();
        boolean directorFound= false;
        for (String directorName : directorMap.keySet()){
            if(directorName.equals(director_name)){
                director= directorMap.get(directorName);
                directorFound=true;
            }
        }
        if(!directorMoviePair.containsKey(director)){
            return movieList;
        }
        return directorMoviePair.get(director);
    }

    //Getting list of all movies
    public List findAllMovies(){
        List<Movie> movieList = new LinkedList<>();
        for(String name : movieMap.keySet()){
            movieList.add(movieMap.get(name));
        }
        return movieList;
    }

    //Deleting director and it's movies
    public String deleteDirectorByName( String director_name){
        //Remove from hashmap
        //checking if director exists or not
        Director director = new Director();
        boolean directorFound= false;
        for (String directorName : directorMap.keySet()){
            if(directorName.equals(director_name)){
                director= directorMap.get(directorName);
                directorFound=true;
            }
        }
        if(directorFound==false){
            return "Director not found";
        }
        ///Getting list of movie by  particular directyor and deleteing all
        if(directorMoviePair.containsKey(director)){
             List<Movie> movieList = new LinkedList<>();
             movieList=directorMoviePair.get(director);
             for (Movie movie : movieList){
                 String movieName= movie.getName();
                 movieMap.remove(movieName);
             }
            directorMoviePair.remove(director);

        }
        //Deleting director itself also
        directorMap.remove(director.getName());
        return "Director and all it's movies are deleted";

    }

    //Deleting all directors
    public String deleteAllDirectors(){
        for (String directorName : directorMap.keySet()){
            deleteDirectorByName(directorName);
        }
        return "all directors are deleted sucessfully";
    }

}

package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@Repository
public class MovieRepository {
    List<Movie> m = new LinkedList<>();
    List<Director> d = new LinkedList<>();
    HashMap<Movie,Director> mp = new HashMap<>();

    //Adding movie post function logic
    public String addMovie( Movie movie){
        m.add(movie);
        return "success";
//        return movie;
    }

    //Adding director post function logic
    public String addDirector(Director director){
        d.add(director);
        return "success";
    }

    //paring movie and director pair
    public String addMovieDirectorPair( String movie_name,  String director_name){
        Movie add_movie = new Movie();
        Director add_director = new Director();
        for(Movie m1 : m){
            if(m1.getName().equals(movie_name)){
                add_movie = m1;
                break;
            }
        }
        for(Director d1 : d){
            if(d1.getName().equals(director_name)){
                add_director = d1;
                break;
            }
        }
        mp.put(add_movie,add_director);
        return "sucess";
    }

    //getting movie by name
    public Movie getMovieByName(String name){
        Movie add_movie = new Movie();
        for(Movie m1 : m){
            if(m1.getName().equals(name)){
                return m1;
            }
        }
        return add_movie;
    }

    //Getting director by name
    public Director getDirectorByName( String name){

        Director add_director = new Director();
        for(Director d1 : d){
            if(d1.getName().equals(name)){
                add_director = d1;
                break;
            }
        }
        return add_director;
    }

    //Getting list of movie by director name

    public List getMoviesByDirectorName(String name){
        List<Movie> ans = new LinkedList<>();
        for(Movie m2: mp.keySet()){
            Director director_name = mp.get(m2);
            String dir_name = director_name.getName();
            if(dir_name.equals(name)){
                ans.add(m2);
            }
        }
        return ans;
    }

    //Getting list of all movies
    public List findAllMovies(){
        return m;
    }

    //Deleting director and it's movies
    public String deleteDirectorByName( String name){
        //Remove from hashmap
        for(Movie m2 : mp.keySet()){
            Director temp = mp.get(m2);
            if(temp.getName().equals(name)){
                mp.remove(m2);
                m.remove(m2);
            }
        }
        //Remove from director list
        for(Director d2: d){
            if(d2.getName().equals(name)){
                d.remove(d2);
            }
        }

        return "success";
    }

    //Deleting all directors
    public String deleteAllDirectors(){
        for(Movie m2 : mp.keySet()){
            m.remove(m2);
        }
        mp.clear();
        return "success";
    }

}

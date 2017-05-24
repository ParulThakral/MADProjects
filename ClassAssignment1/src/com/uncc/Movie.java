package com.uncc;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 * Created by parulthakral on 5/23/17.
 */
public class Movie implements Comparable<Movie>{

    public String name;
    public int year;
    public int total_in_year;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getTotal_in_year() {
        return total_in_year;
    }

    public void setTotal_in_year(int total_in_year) {
        this.total_in_year = total_in_year;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", total_in_year=" + total_in_year +
                '}';
    }


    @Override
    public int compareTo(Movie o) {
        if(o.getTotal_in_year()<this.getTotal_in_year()) {
            return -1;
        } else {
            return 1;
        }


    }



}

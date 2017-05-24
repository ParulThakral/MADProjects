package com.uncc;

import com.sun.org.apache.xalan.internal.xsltc.dom.StepIterator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

/**
 * Created by parulthakral on 5/23/17.
 */
public class InClassOn {

    public static ArrayList<Movie> objMovieList = new ArrayList<>();
    public static HashMap<Character,TreeSet<String>> objHashmap = new HashMap<>();
    public static void main(String[] args) throws Exception {
        readFileAtPath("topMovies.txt");

        Collections.sort(objMovieList);
        for (Movie objMovie:objMovieList
             ) {
            System.out.println(objMovie.toString());
        }

        groupByName(objMovieList);
//        for (Movie objMovie:objMovieList
//             ) {
//
//                Character key = objMovie.getName().charAt(0);
//                if(objHashmap.containsKey(key)){
//                    TreeSet<String> set = objHashmap.get(key);
//                    set.add(objMovie.getName());
//                    objHashmap.put(key, set);
//                } else {
//                    TreeSet<String> set = new TreeSet<>();
//                    set.add(objMovie.getName());
//                    objHashmap.put(key, set);
//                }
//        }
//
//        List<Character> keyList =  new ArrayList(objHashmap.keySet());
//        Collections.sort(keyList);
//
//        for(Character key:keyList) {
//            System.out.print(key +" : ");
//            for(String name:objHashmap.get(key)) {
//                System.out.print(name + " ");
//            }
//            System.out.println("");
//        }



    }
    public static void groupByName(List<Movie> objMovieList){

        HashMap<Character,TreeSet<String>> objHashMap = new HashMap<>();
        for (Movie objMovie:objMovieList
             ) {
            Character key = objMovie.getName().charAt(0);
            if(objHashMap.containsKey(key)){
                TreeSet<String> objTreeSetList = objHashMap.get(key);
                objTreeSetList.add(objMovie.getName());
                objHashMap.put(key,objTreeSetList);
            }
            else {
                TreeSet<String> objTreeSetList = new TreeSet<>();
                objTreeSetList.add(objMovie.getName());
                objHashMap.put(key,objTreeSetList);
            }
        }

        List<Character> objKey = new ArrayList<>(objHashMap.keySet());
        Collections.sort(objKey);

        for (Character k:objKey
             ) {
            System.out.print("For character "+k + " Name of the movie is ");
            System.out.println(objHashMap.get(k));
            System.out.println();
        }

    }

    public static void readFileAtPath(String filename) throws Exception {
        if (filename == null || filename.isEmpty()) {
            System.out.println("Invalid File Path");
            return;
        }
        String filePath = System.getProperty("user.dir") + "/ClassAssignment1/" + filename;
        System.out.println(filePath);
        BufferedReader inputStream = null;
        try {
            try {
                inputStream = new BufferedReader(new FileReader(filePath));
                String lineContent = null;
                while ((lineContent = inputStream.readLine()) != null) {
                    parseMovie(lineContent);
                }
            }
            finally {
                if (inputStream != null)
                    inputStream.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void parseMovie(String lineContent){
        String[] resultingTokens = lineContent.split(",");
        Movie objMovie = new Movie();
        if(resultingTokens.length>=3){
            objMovie.setYear(Integer.parseInt(resultingTokens[0]));
            objMovie.setName(resultingTokens[1]);
            objMovie.setTotal_in_year(Integer.parseInt(resultingTokens[2]));
            objMovieList.add(objMovie);
        }
    }
}

package com.example;

import java.util.ArrayList;
import java.util.Random;

public class Joke {

    ArrayList<String> jokes= new ArrayList();

    public Joke() {

        jokes.add("A computer once beat me at chess, but it was no match for me at kick boxing.");
        jokes.add("A day without sunshine is like, night.");
        jokes.add("What is faster Hot or cold? Hot, because you can catch a cold.");
        jokes.add("When everything’s coming your way, you’re in the wrong lane.");
    }

    public String getJoke(){
        Random a=new Random();
        return jokes.get(a.nextInt(4));
    }
}

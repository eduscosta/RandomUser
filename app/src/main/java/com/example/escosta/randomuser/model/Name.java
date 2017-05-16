package com.example.escosta.randomuser.model;

/**
 * Created by escosta on 16/05/2017.
 */
public class Name {

    public String title;
    public String first;
    public String last;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirst() {

        return first.replaceFirst(first.substring(0,1), first.substring(0,1).toUpperCase());
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        //Inicial M
        return last.replaceFirst(last.substring(0,1), last.substring(0,1).toUpperCase());
    }

    public void setLast(String last) {
        this.last = last;
    }
}

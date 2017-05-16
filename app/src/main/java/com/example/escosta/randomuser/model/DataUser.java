package com.example.escosta.randomuser.model;

import java.util.List;

/**
 * Created by escosta on 16/05/2017.
 */

public class DataUser {
    public List<Result> results = null;
    public Info info;

    public DataUser() {
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults() {
        this.results = results;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }
}
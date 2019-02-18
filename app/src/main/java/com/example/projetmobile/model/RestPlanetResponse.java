package com.example.projetmobile.model;

import java.util.List;

public class RestPlanetResponse {
    private List<Planet> results;
    private String previous;
    private String next;
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) { this.count = count; }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<Planet> getResults() {
        return results;
    }

    public void setResults(List<Planet> results) {
        this.results = results;
    }
}

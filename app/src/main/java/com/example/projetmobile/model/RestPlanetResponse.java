package com.example.projetmobile.model;

import java.util.List;

public class RestPlanetResponse {
    private Integer count;
    private String next;
    private String previous;
    private List<Planet> results;

    public Integer getCount() { return count; }

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

    public void setResults(List<Planet> results) { this.results = results; }
}

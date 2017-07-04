package com.example.user.searchproject.Model;

/**
 * Created by user on 03.07.17.
 */

public class SearchItem {
    private String title;
    private String snippet;

    public SearchItem(String title, String snippet) {
        this.title = title;
        this.snippet = snippet;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSnippet() {
        return snippet;
    }

    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }
}

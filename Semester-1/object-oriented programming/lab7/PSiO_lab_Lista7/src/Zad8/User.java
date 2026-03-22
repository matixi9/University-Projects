package Zad8;

import java.util.ArrayList;

public class User {
    private String name;
    private ArrayList<String> watchedGenres;

    public User(String name) {
        this.name = name;
        this.watchedGenres = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getWatchedGenres() {
        return watchedGenres;
    }

    public void addWatchedGenre(String genre) {
        if (!watchedGenres.contains(genre)) {
            watchedGenres.add(genre);
        }
    }

    @Override
    public String toString() {
        return "name='" + name + "', watchedGenres=" + watchedGenres;
    }
}

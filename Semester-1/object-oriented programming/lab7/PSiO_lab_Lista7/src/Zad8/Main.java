package Zad8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();
        ArrayList<Movie> movies = new ArrayList<>();
        HashMap<String, ArrayList<Movie>> moviesByGenre = new HashMap<>();

        movies.add(new Movie("The Matrix", "Sci-Fi", 8.7));
        movies.add(new Movie("Inception", "Sci-Fi", 8.8));
        movies.add(new Movie("Interstellar", "Sci-Fi", 8.6));
        movies.add(new Movie("Toy Story", "Animation", 8.3));
        movies.add(new Movie("Shrek", "Animation", 7.9));
        movies.add(new Movie("The Godfather", "Crime", 9.2));
        movies.add(new Movie("Pulp Fiction", "Crime", 8.9));
        movies.add(new Movie("Titanic", "Romance", 7.8));

        User user1 = new User("Alice");
        user1.addWatchedGenre("Sci-Fi");
        user1.addWatchedGenre("Animation");

        User user2 = new User("Bob");
        user2.addWatchedGenre("Crime");

        User user3 = new User("Charlie");
        user3.addWatchedGenre("Romance");
        user3.addWatchedGenre("Sci-Fi");

        users.add(user1);
        users.add(user2);
        users.add(user3);

        for (Movie movie : movies) {
            String genre = movie.getGenre();
            if (!moviesByGenre.containsKey(genre)) {
                moviesByGenre.put(genre, new ArrayList<>());
            }
            moviesByGenre.get(genre).add(movie);
        }

        System.out.println("--- Recommendations ---");
        for (User user : users) {
            System.out.println("Recommendations for " + user.getName() + ":");
            ArrayList<String> genres = user.getWatchedGenres();

            for (String genre : genres) {
                if (moviesByGenre.containsKey(genre)) {
                    ArrayList<Movie> recommendations = moviesByGenre.get(genre);
                    for (Movie movie : recommendations) {
                        System.out.println(" - " + movie);
                    }
                }
            }
            System.out.println();
        }

        System.out.println("--- 'To Watch' Queue Simulation ---");
        Queue<Movie> toWatchList = new LinkedList<>();

        System.out.println("User Alice adds movies to her watch list...");
        toWatchList.add(movies.get(0)); // The Matrix
        toWatchList.add(movies.get(3)); // Toy Story
        toWatchList.add(movies.get(5)); // The Godfather

        System.out.println("Current watch list size: " + toWatchList.size());

        while (!toWatchList.isEmpty()) {
            Movie movie = toWatchList.poll();
            System.out.println("Alice is watching: " + movie.getTitle());
        }

        System.out.println("Watch list is now empty.");
    }
}

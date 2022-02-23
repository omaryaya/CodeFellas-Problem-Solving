package HashCode20;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Simulation {
    PriorityQueue<Library> libraries;
    PriorityQueue<Book> books;
    Map<Integer, Book> bookMap;
    Map<Integer, Library> libraryMap;
    int numDays;

    public Simulation(PriorityQueue<Library> libraries, PriorityQueue<Book> books, Map<Integer, Book> bookMap,
            Map<Integer, Library> libraryMap, int numDays) {
        this.libraries = libraries;
        this.books = books;
        this.bookMap = bookMap;
        this.libraryMap = libraryMap;
        this.numDays = numDays;
    }

    public List<Library> solve() {
        int score = 0;
        List<Library> signedUpLibraries = new ArrayList<>();
        Set<Integer> scannedBooks = new HashSet<>();
        for (int i = 0; i < numDays && !libraries.isEmpty();) {
            Library lib = libraries.poll();
            i += lib.signUpTime;
            lib.startedAt = i;
            score += lib.calculateScore(numDays, scannedBooks);
            signedUpLibraries.add(lib);
        }
        System.out.println("Total score: " + score);
        return signedUpLibraries;
    }
}

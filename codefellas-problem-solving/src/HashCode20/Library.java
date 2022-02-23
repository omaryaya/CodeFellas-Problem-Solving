package HashCode20;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class Library {
    public int id;
    public PriorityQueue<Book> books;
    public int signUpTime;
    public int numBooksPerDay;
    public int score;
    public int startedAt;
    public List<Book> booksFromLibrary;

    public Library(int id, PriorityQueue<Book> books, int signUpTime, int numBooksPerDay) {
        this.id = id;
        this.books = books;
        this.signUpTime = signUpTime;
        this.numBooksPerDay = numBooksPerDay;
        this.score = computeScore();
    }

    // 10 9 8 7 6 5 4 3 2 1
    private int computeScore() {
        int score = 0;
        for (Book book : books) {
            score += book.score;
        }
        return score;
    }

    public int calculateScore(int numDays, Set<Integer> scannedBooks) {
        int score = 0;
        int days = 0;
        booksFromLibrary = new ArrayList<>();
        while (days < numDays) {
            days++;
            for (int i = 0; i < numBooksPerDay; i++) {
                if (books.isEmpty()) {
                    break;
                }
                if (scannedBooks.contains(books.peek().id)) {
                    books.poll();
                    continue;
                }
                Book book = books.poll();
                scannedBooks.add(book.id);
                booksFromLibrary.add(book);
                score += book.score;
            }
        }
        return score;

    }
}

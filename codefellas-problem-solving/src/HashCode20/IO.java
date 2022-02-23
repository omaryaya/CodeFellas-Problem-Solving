package HashCode20;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Collectors;

public class IO {

    public static Simulation readFile(String path) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream(new File(path)));

        int numBooks, numLibraries, numDays;
        numBooks = scanner.nextInt();
        numLibraries = scanner.nextInt();
        numDays = scanner.nextInt();

        PriorityQueue<Book> books = new PriorityQueue<>((b1, b2) -> b2.score - b1.score);
        Map<Integer, Book> bookMap = new HashMap<>();

        PriorityQueue<Library> libraries = new PriorityQueue<>((l1, l2) -> l2.score - l1.score);
        Map<Integer, Library> libraryMap = new HashMap<>();

        for (int i = 0; i < numBooks; i++) {
            int id = i;
            int score = scanner.nextInt();
            Book book = new Book(id, score);
            books.add(book);
            bookMap.put(id, book);
        }

        for (int i = 0; i < numLibraries; i++) {
            int id = i;
            int totalNumberOfBooks = scanner.nextInt();
            int signUpTime = scanner.nextInt();
            int numBooksPerDay = scanner.nextInt();
            PriorityQueue<Book> booksInLibrary = new PriorityQueue<>((b1, b2) -> b2.score - b1.score);
            for (int j = 0; j < totalNumberOfBooks; j++) {
                int bookId = scanner.nextInt();
                booksInLibrary.add(bookMap.get(bookId));
            }
            Library library = new Library(id, booksInLibrary, signUpTime, numBooksPerDay);
            libraries.add(library);
            libraryMap.put(id, library);
        }

        return new Simulation(libraries, books, bookMap, libraryMap, numDays);

    }

    public static void writeFile(String path, List<Library> libraries) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(new File(path));
        writer.println(libraries.size());
        for (Library library : libraries) {
            writer.println(library.id + " " + library.booksFromLibrary.size());
            List<String> bookIds = library.booksFromLibrary
                    .stream()
                    .map(book -> book.id + "")
                    .collect(Collectors.toList());

            writer.println(String.join(" ", bookIds));
        }
        writer.close();
    }

}

package HashCode22;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

public class PracticeProblem {

    Set<String> ingredientsSet = new HashSet<>();
    Set<String> chosenIngredients = new HashSet<>();
    Map<String, Integer> ingredientsMap = new HashMap<>();
    List<Client> clients;
    PriorityQueue<String> mostPopularIngredients;
    PriorityQueue<String> leastPopularIngredients;

    class Client {
        List<String> likes;
        List<String> dislikes;

        public Client(List<String> likes, List<String> dislikes) {
            this.likes = likes;
            this.dislikes = dislikes;
        }
    }

    // readFile("/input_data/a_an_example.in.txt");
    private void readFile(String path) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream(new File(path)));

        int numClients = scanner.nextInt();
        clients = new ArrayList<>(numClients);
        for (int i = 0; i < numClients; i++) {
            int numLikes = scanner.nextInt();
            List<String> likes = readStringList(scanner, numLikes, true);
            int numDislikes = scanner.nextInt();
            List<String> dislikes = readStringList(scanner, numDislikes, false);
            clients.add(new Client(likes, dislikes));
        }
        updateIngredientPopularity();
    }

    private List<String> readStringList(Scanner scanner, int num, boolean liked) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            String ingredient = scanner.next();
            ingredientsSet.add(ingredient);
            list.add(ingredient);
            int score = ingredientsMap.getOrDefault(ingredient, 0);
            if (liked) {
                score += 1;
            } else {
                score -= 1;
            }
            ingredientsMap.put(ingredient, score);
        }
        return list;
    }

    private long getScore(Set<String> chosenIngredients) {
        return clients.stream().filter(
                client -> chosenIngredients.containsAll(client.likes)
                        && Collections.disjoint(client.dislikes, chosenIngredients))
                .count();
    }

    private void updateIngredientPopularity() {

        Iterator<Entry<String, Integer>> it = ingredientsMap.entrySet().iterator();
        mostPopularIngredients = new PriorityQueue<>((a, b) -> ingredientsMap.get(b) - ingredientsMap.get(a));
        leastPopularIngredients = new PriorityQueue<>((a, b) -> ingredientsMap.get(a) - ingredientsMap.get(b));
        while (it.hasNext()) {
            Entry<String, Integer> entry = it.next();
            mostPopularIngredients.offer(entry.getKey());
            leastPopularIngredients.offer(entry.getKey());
        }

        // mostPopularIngredients = new PriorityQueue<>(ingredientsMap.size(),
        // (a, b) -> ingredientsMap.get(b) - ingredientsMap.get(a));

        // leastPopularIngredients = new PriorityQueue<>(ingredientsMap.size(),
        // (a, b) -> ingredientsMap.get(a) - ingredientsMap.get(b));

    }

    private void generateOutputFile(String path) throws FileNotFoundException {
        File file = new File(path);
        PrintWriter printWriter = new PrintWriter(file);
        printWriter.print(chosenIngredients.size() + " ");
        printWriter.print(String.join(" ", chosenIngredients));
        printWriter.close();
    }

    private int chooseIngredients() {
        chosenIngredients = new HashSet<>();

        Double addFactor = 0.8;
        int amountToAdd = (int) (ingredientsMap.size() * addFactor);
        while (chosenIngredients.size() < amountToAdd && !mostPopularIngredients.isEmpty()) {
            String ingredient = mostPopularIngredients.poll();
            chosenIngredients.add(ingredient);
        }
        Double removeFactor = 0.3;
        int amountRemoved = (int) (amountToAdd * removeFactor);
        for (int k = 0; k < amountRemoved && !chosenIngredients.isEmpty()
                && !leastPopularIngredients.isEmpty(); k++) {
            chosenIngredients.remove(leastPopularIngredients.poll());
        }

        int score = (int) getScore(chosenIngredients);
        System.out.println("Score: " + score + "\tAddFactor = [" + addFactor + "] removeFactor = ["
                + removeFactor + "]");
        return score;
    }

    private int solve(String input, String output) {
        try {
            readFile(input);
            int score = chooseIngredients();
            generateOutputFile(output);
            return score;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void main(String[] args) {

        int totalScore = 0;
        PracticeProblem problem = new PracticeProblem();
        totalScore += problem.solve("src/HashCode22/input_data/a_an_example.in.txt", "a.out.txt");

        problem = new PracticeProblem();
        totalScore += problem.solve("src/HashCode22/input_data/b_basic.in.txt", "b.out.txt");

        problem = new PracticeProblem();
        totalScore += problem.solve("src/HashCode22/input_data/c_coarse.in.txt", "c.out.txt");

        problem = new PracticeProblem();
        totalScore += problem.solve("src/HashCode22/input_data/d_difficult.in.txt", "d.out.txt");

        problem = new PracticeProblem();
        totalScore += problem.solve("src/HashCode22/input_data/e_elaborate.in.txt", "e.out.txt");

        System.out.println("Total score: " + totalScore);

    }

}

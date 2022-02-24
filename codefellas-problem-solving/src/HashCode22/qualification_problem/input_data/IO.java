package HashCode22.qualification_problem.input_data;

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

        return new Simulation();

    }

    public static void writeFile(String path) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(new File(path));
        writer.close();
    }

}

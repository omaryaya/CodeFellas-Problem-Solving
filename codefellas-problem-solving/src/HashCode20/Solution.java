package HashCode20;

import java.io.FileNotFoundException;
import java.util.List;

import HashCode22.qualification_problem.input_data.IO;

public class Solution {

    public static void main(String[] args) {
        try {
            String[] inputPaths = new String[] {
                    "src/HashCode20/a_example.txt",
                    "src/HashCode20/b_read_on.txt",
                    "src/HashCode20/c_incunabula.txt",
                    "src/HashCode20/d_tough_choices.txt",
                    "src/HashCode20/e_so_many_books.txt",
                    "src/HashCode20/f_libraries_of_the_world.txt" };
            String[] outputPaths = new String[] {
                    "output_a_example.txt",
                    "output_b_read_on.txt",
                    "output_c_incunabula.txt",
                    "output_d_tough_choices.txt",
                    "output_e_so_many_books.txt",
                    "output_f_libraries_of_the_world.txt" };

            for (int i = 0; i < inputPaths.length; i++) {
                Simulation simulation = IO.readFile(inputPaths[i]);
                List<Library> libraries = simulation.solve();
                IO.writeFile(outputPaths[i], libraries);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}

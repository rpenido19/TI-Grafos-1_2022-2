import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Reader {
    private final String FILENAME = "entrada.txt";
    private final String PATH = System.getProperty("user.dir");

    public String getFILENAME() {
        return FILENAME;
    }

    public String getPATH() {
        return PATH;
    }

    public ArrayList<String> readFile() {
        ArrayList<String> data = new ArrayList<String>();
        try {
            File file = new File(getPATH() + "\\" + getFILENAME());
            Scanner input = new Scanner(file);
            while (input.hasNextLine()) {
                data.add(input.nextLine());
            }
            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ocorreu um erro! \"" + getFILENAME() + "\" não encontrado.");
        }
        return data;
    }
}

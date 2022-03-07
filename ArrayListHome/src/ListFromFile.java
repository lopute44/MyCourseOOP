import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ListFromFile {
    public static void main(String[] args) throws IOException {
        String fileName = "input.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            ArrayList<String> list = new ArrayList<>();

            String line;
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }

            System.out.println("Содержимое файла " + fileName + ": " + list);
        } catch (IOException e) {
            System.out.println("Файл не найден!");
        }
    }
}
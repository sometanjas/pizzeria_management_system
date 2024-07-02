package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PostLeitZahlChecker {

    private static List<Integer> berlinPLZ = new ArrayList<>();

    public PostLeitZahlChecker() {
        // PLZ-Daten aus einer Textdatei laden
        loadDataFromFile("berlin_plz.txt");
    }

    private void loadDataFromFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                berlinPLZ.add(Integer.parseInt(line.trim()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean istBerlinPLZ(int plz) {
        return berlinPLZ.contains(plz);
    }

    public boolean testPLZ(String input) {
        try {
            int plz = Integer.parseInt(input);
            return istBerlinPLZ(plz);
        } catch (NumberFormatException e) {
            // Wenn die Eingabe keine gültige ganze Zahl ist
            return false;
        }
    }
}

package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PostLeitZahlChecker {

    private static List<Integer> berlinPLZ = new ArrayList<>();

    static {
        // PLZ-Daten aus einer Textdatei laden
        try (BufferedReader br = new BufferedReader(new FileReader("berlin_plz.txt"))) {
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

    //implement User input-method test plz

}

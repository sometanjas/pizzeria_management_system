package src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PostLeitZahlChecker {

    public static ArrayList<String> berlinPLZ = new ArrayList<>();

    /*
    public PostLeitZahlChecker() {
        // PLZ-Daten aus einer Textdatei laden
        loadDataFromFile("berlin_plz.txt");
    }
*/
    /*
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
    */

//    public static ArrayList<String> xxx() throws IOException {
//        Scanner s = new Scanner(new File("berlin_plz.txt"));
//        //ArrayList<String> list = new ArrayList<>();
//        while (s.hasNext()){
//            berlinPLZ.add(s.next());
//        }
//        s.close();
//        return berlinPLZ;
//    }
//
//    public static boolean istBerlinPLZ(String input) throws IOException {
//            try{ PostLeitZahlChecker.xxx();}
//            catch(IOException e) {
//            e.printStackTrace();
//        }
//        return berlinPLZ.contains(input);
//    }
//
//    public boolean testPLZ(String input) throws IOException{
//        try {
//            //int plz = Integer.parseInt(input);
//            //return istBerlinPLZ(plz);
//            return istBerlinPLZ(input);
//        } catch (NumberFormatException e) {
//            // Wenn die Eingabe keine gültige ganze Zahl ist
//            return false;
//        }
//    }

    public static boolean istBerlin(String input) throws IOException {
        Scanner s = new Scanner(new File("berlin_plz.txt"));
        while (s.hasNext()){
            berlinPLZ.add(s.next());
        }
        s.close();
        for (String element : berlinPLZ){
            if (element.contains(input)){
                return true;
            }
        }
        return false;
    }


}

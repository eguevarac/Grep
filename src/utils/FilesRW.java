package utils;

import data_classes.FoundLine;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class FilesRW {


    public static void findTxtInFile(String fileURL, String txtToFind, ArrayList<FoundLine> foundLines) {
        String line;
        int numLine = 1;

        try (BufferedReader br = new BufferedReader(new FileReader(fileURL))) {

            while ((line = br.readLine()) != null) {
                if(line.contains(txtToFind)){

                    foundLines.add(new FoundLine(fileURL, numLine, line));
                }
                numLine++;
            }

        } catch (FileNotFoundException e) {

            System.out.println("NO SE HA ENCONTRADO EL FICHERO");

        } catch (IOException e) {

            System.out.println("ERROR DURANTE LA LECTURA DEL FICHERO");

        } catch (ArrayIndexOutOfBoundsException e) {

            System.out.println("INFORMACIÓN MAL GUARDADA EN EL FICHERO");
        }
    }

}

import data_classes.FoundLine;
import threads.DirectoryThread;
import threads.FileThread;
import utils.SpellBook;

import java.io.File;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        String route;
        String txtToFind;
        ArrayList<FoundLine> foundLines = new ArrayList<>();
        DirectoryThread dirThread = null;
        FileThread fileThread = null;

        System.out.println("Introduce la ruta en la que quieres buscar");
        route = SpellBook.readString();

        System.out.println("Ahora introduce el texto que quieres buscar");
        txtToFind = SpellBook.readString();


        File fileOrigin = new File(route);

        if (fileOrigin.isDirectory()) {

            dirThread = new DirectoryThread(route, txtToFind, foundLines);
            dirThread.start();

        } else {

            fileThread = new FileThread(route, txtToFind, foundLines);
            fileThread.start();
            System.out.println("La ruta especificada no corresponde a un directorio válido.");
        }

        if(dirThread != null){
            try {
                dirThread.join();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        if(fileThread != null){
            try {
                fileThread.join();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

        for (FoundLine fl :
                foundLines) {
            System.out.println(fl.toString());
        }

    }
}
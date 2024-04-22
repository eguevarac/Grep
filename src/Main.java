import threads.DirectoryThread;
import utils.SpellBook;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        String route;
        String txtToFind;

        System.out.println("Introduce la ruta en la que quieres buscar");
        route = SpellBook.readString();

        System.out.println("Ahora introduce el texto que quieres buscar");
        txtToFind = SpellBook.readString();


        File fileOrigin = new File(route);

        if (fileOrigin.isDirectory()) {

            DirectoryThread dirThread = new DirectoryThread(route, txtToFind);
            dirThread.start();

        } else {
            System.out.println("La ruta especificada no corresponde a un directorio válido.");
        }

    }
}
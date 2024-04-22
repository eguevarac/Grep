import utils.SpellBook;

public class Main {
    public static void main(String[] args) {
        String route;
        String txtToFind;

        System.out.println("Introduce la ruta en la que quieres buscar");
        route = SpellBook.readString();

        System.out.println("Ahora introduce el texto que quieres buscar");
        txtToFind = SpellBook.readString();


    }
}
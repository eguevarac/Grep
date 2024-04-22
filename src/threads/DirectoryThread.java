package threads;

import java.io.File;

public class DirectoryThread extends Thread{

    String route;
    String txtToFind;

    public DirectoryThread(String route, String txtToFind) {
        this.route = route;
        this.txtToFind = txtToFind;
    }

    @Override
    public void run() {
        super.run();
        System.out.println("Archivos y directorios en " + route + ":");
        File fileOrigin = new File(route);

        File[] files = fileOrigin.listFiles();

        if(files != null){
            for (File file : files) {
                if (file.isFile()) {

                    System.out.println("Archivo: " + file.getName());
                }
                else if (file.isDirectory()) {

                    DirectoryThread dirThread = new DirectoryThread(route+"\\"+file.getName(), txtToFind);
                    System.out.println("Directorio: " + file.getName());
                    dirThread.start();
                }
            }

        }else{
            System.out.println("El directorio está vacío");
        }


    }
}

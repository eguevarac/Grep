package threads;

import data_classes.FoundLine;

import java.io.File;
import java.util.ArrayList;

public class DirectoryThread extends Thread{

    String route;
    String txtToFind;
    ArrayList<FoundLine> foundLines;

    public DirectoryThread(String route, String txtToFind, ArrayList<FoundLine> foundLines) {
        this.route = route;
        this.txtToFind = txtToFind;
        this.foundLines = foundLines;
    }

    @Override
    public void run() {
        super.run();
        File fileOrigin = new File(route);
        ArrayList<Thread> threads = new ArrayList<>();

        File[] files = fileOrigin.listFiles();

        if(files != null){
            for (File file : files) {
                if (file.isFile()) {

                    FileThread fileThread = new FileThread(route+"\\"+file.getName(), txtToFind, foundLines);
                    threads.add(fileThread);
                    fileThread.start();
                }
                else if (file.isDirectory()) {

                    DirectoryThread dirThread = new DirectoryThread(route+"\\"+file.getName(), txtToFind, foundLines);
                    threads.add(dirThread);
                    dirThread.start();
                }
            }

        }

        for (Thread thread :
                threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}

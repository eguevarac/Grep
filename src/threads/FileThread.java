package threads;

import data_classes.FoundLine;
import utils.FilesRW;

import java.util.ArrayList;

public class FileThread extends Thread{

    String route;
    String txtToFind;
    ArrayList<FoundLine> foundLines;

    public FileThread(String route, String txtToFind, ArrayList<FoundLine> foundLines) {
        this.route = route;
        this.txtToFind = txtToFind;
        this.foundLines = foundLines;
    }

    @Override
    public void run() {
        super.run();

        FilesRW.findTxtInFile(route, txtToFind, foundLines);
    }
}

package data_classes;

public class FoundLine {

    private String route;
    private int numLine;
    private String line;

    public FoundLine(String route, int numLine, String line) {
        this.route = route;
        this.numLine = numLine;
        this.line = line;
    }

    @Override
    public String toString() {
        return route + " :: " + numLine + " :: " + line;
    }
}

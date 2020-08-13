import java.util.Collections;

public class LineAndTitle {
    static String UNDERLINE = "_";
    static String LINE = "-";
    static String SLASH = "/";
    static String STAR = "*";
    static String PLUS = "+";
    static String MINUS = "-";
    static String MULTIPLY = "*";
    static String DIVIDE = "/";
    static String NEWLINE = "\n";
    static String BLANK = " ";
    static int DEFAULTTIME = 40;

    public static void printTitle(String titleName) {

        System.out.print(NEWLINE.concat(String.join("", Collections.nCopies(2, SLASH)))
                .concat(String.join("", Collections.nCopies(DEFAULTTIME, LINE))).concat(BLANK).concat(titleName)
                .concat(BLANK).concat(String.join("", Collections.nCopies(DEFAULTTIME, LINE)))
                .concat(String.join("", Collections.nCopies(2, SLASH))).concat(NEWLINE));
    }
}
package everyday1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RemoveString {
    public static void main(String[] args) {
        String msg = "^297402846113046528                       .|\n" +
                "^304633175429226496                       .|\n" +
                "^310387015306854400.310387073200832512    .|\n" +
                "^310387015306854400.310387091341197312    .|\n" +
                "^332103456296951808                       .|\n" +
                "^332164224279277568                       .|\n" +
                "^344887530543558656                       .|";

        Pattern p = Pattern.compile("\\s*|\\t|\\r|\\n");
        Matcher m = p.matcher(msg);
        String s = m.replaceAll("");

    }
}

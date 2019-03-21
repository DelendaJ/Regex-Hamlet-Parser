import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private static String hamletData;


    public HamletParser() {
        this.hamletData = loadFile();
    }

    private String loadFile() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result.toString();
    }

    public static String getHamletData() {
        return hamletData;
    }

    public void changeAndReplace(String originalName, String replacementName) {
        hamletData = getHamletData();
        Pattern p = Pattern.compile("\\b" + originalName);
        Matcher m = p.matcher(hamletData);
        this.hamletData = m.replaceAll(replacementName);

        System.out.println(hamletData);

    }

    public static void main(String[] args) {
        HamletParser parser = new HamletParser();
        parser.changeAndReplace("Hamlet", "Leon");
        parser.changeAndReplace("Horatio", "Tariq");
        parser.changeAndReplace("HORATIO", "TARIQ");
        parser.changeAndReplace("HAMLET", "TARIQ");



    }

}

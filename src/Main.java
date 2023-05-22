import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> ips = new ArrayList();

        try (FileReader fr = new FileReader("regexIp.txt")) {
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                ips.add(line);
                line = reader.readLine();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        for (String ip : ips) {
            System.out.println(ip + " - " + checkIP6(ip));
        }
    }



    public static boolean checkIP6(final String input) {
        return input.matches("^([0-9A-Fa-f]{1,4}(:[0-9A-Fa-f]{1,4}){7})|((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?::(?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$");
    }
}
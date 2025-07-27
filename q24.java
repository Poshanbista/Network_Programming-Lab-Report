import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class q24 {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://example.com");

            URLConnection connection = url.openConnection();
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()))) {

                String line;

                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

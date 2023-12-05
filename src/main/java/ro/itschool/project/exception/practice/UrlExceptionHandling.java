package ro.itschool.project.exception.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class UrlExceptionHandling {

    public static void main(String[] args) {
        try {
            URL url = new URL("https://en.wikipedia.org/wiki/Text_file");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))){
                String line;
                while ((line = reader.readLine()) != null){
                    System.out.println(line);
                }
            }
        } catch (MalformedURLException exception) {
            // could do with SLF4J
            System.out.println("MalformedURLException: " + exception.getMessage());
        } catch (IOException exception) {
            System.out.println("IOException: " + exception.getMessage());
        }
    }
}

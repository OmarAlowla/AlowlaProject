package main;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class CookieUtil {

    public static void addRandomArrayCookie(HttpServletResponse response, String[] randomArray) {
        try {
            String encodedRandomArray = URLEncoder.encode(String.join(",", randomArray), "UTF-8");
            Cookie cookie = new Cookie("randomArray", encodedRandomArray);
            response.addCookie(cookie);
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception according to your requirements
        }
    }

    public static String readFileContent(String filePath) throws IOException {
        return Files.lines(Paths.get(filePath)).collect(Collectors.joining("\n"));
    }
}

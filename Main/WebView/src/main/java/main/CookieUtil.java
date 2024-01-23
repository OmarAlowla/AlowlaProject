package main;


import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class CookieUtil {
    public void newCookie(String[] array, String name,HttpServletResponse response, Resource resource) throws UnsupportedEncodingException {
        jakarta.servlet.http.Cookie cookie;
        try {
            String encodedArray = URLEncoder.encode(
                    String.join(",", array),
                    "UTF-8"
            );
            cookie = new Cookie(name, encodedArray);
            response.addCookie(cookie);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void newCookieAsStr(String array, String name,HttpServletResponse response, Resource resource) throws UnsupportedEncodingException {
        jakarta.servlet.http.Cookie cookie;
        try {
            String encodedArray = URLEncoder.encode(
                    String.join(",", array),
                    "UTF-8"
            );
            cookie = new Cookie(name, encodedArray);
            response.addCookie(cookie);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setLocalStorage(HttpServletResponse response , String key , String value) throws IOException {

        String encodedValue = URLEncoder.encode(value, "UTF-8");
        String script = String.format("localStorage.setItem('%s', '%s');", key, encodedValue);
        response.setContentType("text/javascript");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(script);
    }
    public HttpServletResponse wirteFile(HttpServletResponse response, Resource resource) throws IOException {
        response.getWriter().write(
                Files.lines(Paths.get(resource.getURI())).collect(Collectors.joining("\n"))
        );
        return response;
    }
}

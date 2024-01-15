import java.awt.Desktop;
import java.net.URI;


public class ResultToHtml {
    String url;
    public ResultToHtml(String url) {
        try {
            if (!url.startsWith("http://") && !url.startsWith("https://")) {
                url = "http://" + url;
            }
            Desktop.getDesktop().browse(new URI(url));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

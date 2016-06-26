import org.junit.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author Vulcan Pong [vulcanpong@yeah.net]
 */

public class URLConnectionTest {
    @Test
    public void t() {
        try {
            URL url = new URL("www.baidu.com");
            URLConnection urlConnection = url.openConnection();
            urlConnection.getURL();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

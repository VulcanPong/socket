import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

/**
 * @author Vulcan Pong [vulcanpong@yeah.net]
 */

public class URLTest {
    @Test
    public void InetAddressTest() {
        InetAddress address = null;
        try {
            address = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        byte[] array = address.getAddress();
        System.out.println(address.getHostName());
        for (byte b : array) {
            System.out.println(b >= 0 ? b : b + 256);
        }
        System.out.println(address.getCanonicalHostName());
        System.out.println(address.getHostAddress());
    }

    @Test
    public void urlTest() {
        try {
            URL url = new URL("http://www.baidu.com");
            InputStream inputStream = url.openStream();
            int c;
            while ((c = inputStream.read()) != -1) {
                System.out.print((char)c);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {

        }
    }

    @Test
    public void getTest() {

        try {
            URL url = new URL("https://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=0&rsv_idx=1&tn=baidu&wd=I&rsv_pq=9c13ad0d0005fbfa&rsv_t=799c4SeMOmVHlvGmEgJCsC9IaL%2F2SNHfIMBAmfmaLmkIvMRWF%2BNL6f3AMGM&rqlang=cn&rsv_enter=1&rsv_sug3=1&rsv_sug1=1&rsv_sug7=100&rsv_sug2=0&inputT=588&rsv_sug4=588");
            System.out.println("query:" + url.getQuery());
            System.out.println("ref:" + url.getRef());
            System.out.println("userInfo:" + url.getUserInfo());
            System.out.println("authority:" + url.getAuthority());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

}

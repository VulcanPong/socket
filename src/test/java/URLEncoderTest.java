import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @author Vulcan Pong [vulcanpong@yeah.net]
 */

public class URLEncoderTest {
    @Test
    public void t1() {
        try {
            String encode = URLEncoder.encode("Thi@s*string*has*asterisks", "UTF-8");
            System.out.println(encode);
            String decode = URLDecoder.decode(encode, "UTF-8");
            System.out.println(decode);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void t2() {

    }
}

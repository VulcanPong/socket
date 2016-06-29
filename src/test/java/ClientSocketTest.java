import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @author Vulcan Pong [vulcanpong@yeah.net]
 */

public class ClientSocketTest {
    @Test
    public void clientSocket() {
        try(Socket socket = new Socket("time.nist.gov", 13)) {
            socket.setSoTimeout(15000);
            InputStream reader = socket.getInputStream();
            StringBuilder time = new StringBuilder();
            //InputStreamReader reader = new InputStreamReader(in, "ASCII");
            for(int c = reader.read(); c != -1; c = reader.read()) {
                time.append((char)c);
            }
            System.out.println(time);
        } catch (IOException e) {

        }
    }
}

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class q15  {
    public static void main(String args[]) throws UnsupportedEncodingException {
        String data = "http://www.mysite.com/?video=funny%20cat%20plays%20piano.";
        String result = URLDecoder.decode(data, "UTF-8");
        System.out.println(result);
    }
}
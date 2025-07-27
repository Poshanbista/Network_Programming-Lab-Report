import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URLEncoder;

public class q14 {
 public static void main(String args[]) throws URISyntaxException, UnsupportedEncodingException {
 String data = "Simple text data!@#$";
 String encodeData = URLEncoder.encode(data, "UTF-8");
 System.out.println(encodeData);
 }
 }
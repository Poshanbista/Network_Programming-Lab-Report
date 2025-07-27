import java.net.URL;
import java.net.URLConnection;

public class q20 {
 public static void main(String args[]) throws Exception {
 String resource = "http://spm.com.np/";

 URL url = new URL(resource);

 URLConnection conn = url.openConnection();
 String contentType = conn.getHeaderField("Content-Type");
 String ContentLength = conn.getHeaderField("Content-Length");
 String lastModified = conn.getHeaderField("Last-Modified");

 System.out.println("contentType : " + contentType);
 System.out.println("ContentLength : " +  ContentLength);
 System.out.println("lastModified : " + lastModified);
 }
 }

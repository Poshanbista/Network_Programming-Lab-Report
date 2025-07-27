 import java.net.*;
 
 public class q19  {
 public static void main(String args[]) throws Exception {
 String resource = "http://spm.com.np/";
 

 URL url = new URL(resource);
 
 URLConnection conn = url.openConnection();
 String contentType = conn.getContentType();
 System.out.println("contentType = " + contentType);
 int conLengthInt = conn.getContentLength();
 System.out.println("conLengthInt = " + conLengthInt);

 String contentEncoding = conn.getContentEncoding();
 System.out.println("contentEncoding = " + contentEncoding);
 }
 }

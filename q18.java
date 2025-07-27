import java.net.CookieManager;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.URI;
import java.util.List;

public class q18 {
    public static void main(String[] args) {
        CookieManager cm = new CookieManager();
        CookieStore cs = cm.getCookieStore();
        
        HttpCookie c1 = new HttpCookie("user1", "1");
        HttpCookie c2 = new HttpCookie("user2", "2");
        HttpCookie c3 = new HttpCookie("user3", "3");
        URI uri1 = URI.create("http://spm.com.np");
        URI uri2 = URI.create("http://spm1.com.np");
       
        cs.add(uri1, c1);
        cs.add(uri2, c2);
        cs.add(null, c3);
       
        List cl = cs.getCookies();
        System.out.println("cookies lst store" + cl + "\n");
    
    }
}
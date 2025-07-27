import java.io.IOException;
import java.net.*;
import java.util.*;

public class RememberingProxySelector extends ProxySelector {

    private final ProxySelector defaultSelector;
    private final Map<SocketAddress, Boolean> proxyStatus = new HashMap<>();

    public RememberingProxySelector() {
        this.defaultSelector = ProxySelector.getDefault();
    }

    @Override
    public List<Proxy> select(URI uri) {
        List<Proxy> proxies = defaultSelector.select(uri);
        List<Proxy> filteredProxies = new ArrayList<>();

        for (Proxy proxy : proxies) {
            SocketAddress address = proxy.address();
            if (address == null || proxyStatus.getOrDefault(address, true)) {
                filteredProxies.add(proxy);
            } else {
                System.out.println("Skipping known bad proxy: " + address);
            }
        }

        filteredProxies.add(Proxy.NO_PROXY); // fallback
        return filteredProxies;
    }

    @Override
    public void connectFailed(URI uri, SocketAddress sa, IOException ioe) {
        System.out.println("Marking proxy as failed: " + sa);
        proxyStatus.put(sa, false);
        defaultSelector.connectFailed(uri, sa, ioe);
    }

    public static void main(String[] args) throws Exception {
        ProxySelector.setDefault(new RememberingProxySelector());

        URL url = new URL("http://example.com");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setConnectTimeout(3000);
        connection.setReadTimeout(3000);

        try {
            System.out.println("Response Code: " + connection.getResponseCode());
        } catch (IOException e) {
            System.out.println("Connection failed: " + e.getMessage());
        } finally {
            connection.disconnect();
        }
    }
}

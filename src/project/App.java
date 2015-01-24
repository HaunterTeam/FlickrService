package project;

import java.io.IOException;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;

import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class App
{

    public static void main(String[] args) throws Exception, IllegalArgumentException, IOException, URISyntaxException
    {
        String protocol = Settings.BASE_PROTOCOL;
        String port = System.getenv("PORT");
        if (port == null || port.isEmpty()) {
            port = Settings.BASE_PORT;
        }
        String hostname = InetAddress.getLocalHost().getHostAddress();
        String path = Settings.BASE_PATH;
        if (hostname.equals(Settings.BASE_URL))
        {
            hostname = "localhost";
        }

        URI baseUrl = new URI(protocol + hostname + port + path);
        System.err.println(baseUrl);
        System.out.println("Starting Flickr standalone HTTP server..");
        JdkHttpServerFactory.createHttpServer(baseUrl, createApp());
        System.out.println("server starts on " + baseUrl + "\n [kill the process to exit]");
    }
    public static ResourceConfig createApp() {
        return new MyApplicationConfig();
    }
}

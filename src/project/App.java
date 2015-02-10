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
        String port = Settings.BASE_PORT;
        String hostname = Settings.BASE_URL;
        String path = Settings.BASE_PATH;
        
        URI baseUrl = new URI(protocol + hostname + ":" + port + path);
        System.out.println("Starting Flickr standalone HTTP server..");
        JdkHttpServerFactory.createHttpServer(baseUrl, createApp());
        System.out.println("server starts on " + baseUrl + "\n [kill the process to exit]");
    }
    public static ResourceConfig createApp() {
        return new MyApplicationConfig();
    }
}

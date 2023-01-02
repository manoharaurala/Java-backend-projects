import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class SampleHttpServer {
    public static void main(String[] args) {
        try {
            HttpServer httpServer = HttpServer.create(new InetSocketAddress("localhost",9089),0);
            httpServer.createContext("/ruby",new HelloHandler());
            httpServer.createContext("/annaya",new MyHttpHandler());
            httpServer.setExecutor(Executors.newFixedThreadPool(10));
            httpServer.start();
            System.out.println("Server started on port 9089");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

}

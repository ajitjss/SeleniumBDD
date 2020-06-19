package APITest;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class JSONParseHttpClient {

    public static void main(String[] args) throws IOException {
        URL url = new URL("https://thoughtcoders.com/");
        HttpURLConnection conn =(HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        int responseCode = conn.getResponseCode();
        System.out.println("responseCode: "+responseCode);
        System.out.println("response time: "+conn.getReadTimeout());
        System.out.println(conn.getContent());
        Scanner sc = new Scanner(url.openStream());
        String inline=null;
        while(sc.hasNext()){
            inline += sc.next();
        }
        System.out.println(inline);

        sc.close();
    }


}

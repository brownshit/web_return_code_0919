import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class main {
    public static void main(String[] args) {

        String Address;
        URL url;
        BufferedReader br = null;
        HttpURLConnection conn;
        String protocol = "GET";

        Address = "https://api.ip.pe.kr/";

        try {
            url = new URL(Address);
            conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod(protocol);
            br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"MS949"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }

        String line = null;
        while(true){
            try {
                if (!((line = br.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println(line);
            System.out.println(line.getClass().getName());
        }
    }
}

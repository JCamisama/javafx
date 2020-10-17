package ehu.isad;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


public class LiburuKudeatzailea {
    private static String url_lehenengo_zatia   = "https://openlibrary.org/api/books?bibkeys=ISBN:";
    private static String url_bigarren_zatia    = "&jscmd=details&format=json";


    public static LiburuDetaileak bilatuLiburuaIsbnrekin(String pIsbn){

        LiburuDetaileak detaileak = new LiburuDetaileak();
        String inputLine = "";
        String urlOsoa = "";
        String liburukoInfo = "";
        URL openLib;

        try{
            //URL-tik Json formatuko testua lortuko da orain
            urlOsoa = url_lehenengo_zatia + pIsbn + url_bigarren_zatia;
            openLib = new URL(urlOsoa);
            URLConnection yc = openLib.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    yc.getInputStream()) );
            inputLine = in.readLine();

            //Liburuaren informazio osoa ez dugula behar, detaileak bakarrik hartuko dira
            String[] zatiak = inputLine.split("ISBN:"+pIsbn+"\":");
            liburukoInfo = zatiak[1].substring(0, zatiak[1].length()-1);

            Gson gson = new Gson();
            Liburua liburu = gson.fromJson(liburukoInfo, Liburua.class);

            //detaileak = gson.fromJson(liburu.getDetails(), LiburuDetaileak.class);
            detaileak = liburu.getDetails();
            in.close();
        }
        catch (MalformedURLException e){
            e.printStackTrace();
        }
        catch (IOException e){

            e.printStackTrace();
        }

        return detaileak;
    }
}

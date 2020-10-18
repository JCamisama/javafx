package ehu.isad;

public class Liburua {

    //Atributuak
    String info_url;
    String bib_key;
    String preview_url;
    String thumbnail_url;
    LiburuDetaileak details;
    String preview;

    //Gainontzeko metodoak
    public LiburuDetaileak getDetails(){
         return this.details;
    }

    public String getIrudiarenUrl(){
        return this.thumbnail_url;
    }

     @Override
     public String toString() {
         return "Liburua{" +
                 "info_url='" + info_url + '\'' +
                 ", bib_key='" + bib_key + '\'' +
                 ", preview_url='" + preview_url + '\'' +
                 ", thumbnail_url='" + thumbnail_url + '\'' +
                 ", details=" + details +
                 ", preview='" + preview + '\'' +
                 '}';
     }


}

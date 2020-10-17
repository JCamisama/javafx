package ehu.isad;

public class Liburua {

    //Atributuak
    String info_url;
    String bib_key;
    String preview_url;
    String thumbnail_url;
    LiburuDetaileak details;
    //String details;
    String preview;


     //Eraikitzailea
     //public Liburua(){}

     //Gainontzeko metodoak
    public LiburuDetaileak getDetails(){
         return details;
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

package ehu.isad;

public class LiburuDetaileak {
    //atributuak
    private String[]    publishers;
    /*private String      key;
    private String      source_records;
    private String      created;*/
    private String      title;
    private Integer         number_of_pages;
    /*private String      covers;
    private String      local_id;
    private String      isbn_13;
    private String      isbn_10;
    private String      latest_revision;
    private String      last_modified;
    private String[]    authors;
    private String      publish_date;
    private String[]    works;
    private String      type;
    private String      revision;*/

    //Eraikitzailea
    public LiburuDetaileak(){}

    //Gainontzeko metodoak




    public String getIzena(){
        return this.title;
    }

    public int getOrriKop(){
        return this.number_of_pages;
    }

    public String[] getArgitaletxeak(){
        return this.publishers;
    }




}

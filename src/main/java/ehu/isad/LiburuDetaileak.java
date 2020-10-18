package ehu.isad;

import javafx.scene.image.Image;

public class LiburuDetaileak {

    //Atributuak
    private String[]    publishers;
    private String      title;
    private Integer     number_of_pages;
    private Image       irudia;



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


    public Image getIrudia(){
        if(this.irudia == null){
            System.out.println("Liburu honek ez dauka irudirik esleituta, null bueltatuko da...");
        }
        return this.irudia;
    }

    public void setIrudia(Image pIrudia){
        this.irudia = pIrudia;
    }
}

package sample.things;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import javafx.event.Event;

import java.io.*;

public  class Thing implements Serializable{

    private String type;



    @JacksonXmlProperty(isAttribute=true)
    public String getType() {
        return type;
    }

    @JacksonXmlProperty(isAttribute=true)
    public void setType(String type) {
        this.type = type;
    }

    public Thing(String type) {
        this.type = type;
    }

    public Thing(){
    }

    public void addToList(){}

    public void editInList(Event event){}
}


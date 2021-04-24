package sample.things;


import javafx.event.Event;

import java.io.*;

public  class Thing implements Serializable{
    private String type;

    public String getType() {
        return type;
    }

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


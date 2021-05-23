package sample.things;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Shoes extends Thing {
    private int size;

    @JacksonXmlProperty(isAttribute=true)
    public int getSize() {
        return size;
    }
    @JacksonXmlProperty(isAttribute=true)
    public void setSize(int size) {
        this.size = size;
    }


    public Shoes(){}
    public Shoes(int size, String type) {
        super(type);
        this.size = size;
    }

}

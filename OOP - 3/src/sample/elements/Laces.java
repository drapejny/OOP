package sample.elements;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.io.Serializable;

public class Laces implements Serializable {
    private int length;
    @JacksonXmlProperty(isAttribute=true)
    public int getLength() {
        return length;
    }
    @JacksonXmlProperty(isAttribute=true)
    public void setLength(int length) {
        this.length = length;
    }

    public Laces(int length) {
        this.length = length;
    }

    public Laces(){}
}

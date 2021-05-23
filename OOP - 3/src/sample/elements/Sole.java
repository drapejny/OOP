package sample.elements;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.io.Serializable;

public class Sole implements Serializable {
    private String material;
    @JacksonXmlProperty(isAttribute=true)
    public String getMaterial() {
        return material;
    }
    @JacksonXmlProperty(isAttribute=true)
    public void setMaterial(String material) {
        this.material = material;
    }

    public Sole(String material) {
        this.material = material;
    }

    public Sole(){}
}

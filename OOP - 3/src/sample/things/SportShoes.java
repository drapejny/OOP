package sample.things;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class SportShoes extends Shoes {
    private String model;

    @JacksonXmlProperty(isAttribute=true)
    public String getModel() {
        return model;
    }

    @JacksonXmlProperty(isAttribute=true)
    public void setModel(String model) {
        this.model = model;
    }

    public SportShoes( ) {}

    public SportShoes(int size,  String model,String type) {
        super(size, type);
        this.model = model;
    }
}

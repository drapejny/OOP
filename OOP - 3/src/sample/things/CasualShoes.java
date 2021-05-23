package sample.things;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class CasualShoes extends Shoes {
    private String model;

    @JacksonXmlProperty(isAttribute=true)
    public String getModel() {
        return model;
    }
    @JacksonXmlProperty(isAttribute=true)
    public void setModel(String model) {
        this.model = model;
    }

    public CasualShoes() {
    }

    public CasualShoes(int size, String model, String type) {
        super(size, type);
        this.model = model;
    }
}

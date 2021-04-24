package sample.elements;

import java.io.Serializable;

public class Sole implements Serializable {
    private String material;

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Sole(String material) {
        this.material = material;
    }

    public Sole(){}
}

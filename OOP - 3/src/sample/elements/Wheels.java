package sample.elements;

import java.io.Serializable;

public class Wheels implements Serializable {
    private String material;

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Wheels(String material) {
        this.material = material;
    }

    public Wheels(){}
}

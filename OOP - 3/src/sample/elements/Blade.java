package sample.elements;

import java.io.Serializable;

public class Blade implements Serializable {
    private String material;

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Blade(String material) {
        this.material = material;
    }
    public Blade(){}
}

package sample.elements;

import java.io.Serializable;

public class Body implements Serializable {
    private String material;

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Body(String material) {
        this.material = material;
    }

    public Body(){}
}

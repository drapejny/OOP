package sample.elements;

import java.io.Serializable;

public class Laces implements Serializable {
    private int length;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Laces(int length) {
        this.length = length;
    }

    public Laces(){}
}

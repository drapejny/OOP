package sample.things;

public class Shoes extends Thing {
    private int size;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }


    public Shoes(){}
    public Shoes(int size, String type) {
        super(type);
        this.size = size;
    }

}

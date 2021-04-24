package sample.things;

public class SportShoes extends Shoes {
    private String model;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public SportShoes( ) {}

    public SportShoes(int size,  String model,String type) {
        super(size, type);
        this.model = model;
    }
}

package sample.things;

public class CasualShoes extends Shoes {
    private String model;

    public String getModel() {
        return model;
    }

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

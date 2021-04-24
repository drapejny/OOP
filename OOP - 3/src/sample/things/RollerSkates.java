package sample.things;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import sample.Main;
import sample.controllers.IceSkatesController;
import sample.controllers.RollerSkatesController;
import sample.elements.Body;
import sample.elements.Wheels;

import java.io.IOException;

public class RollerSkates extends SportShoes {
    private Body body;
    private Wheels wheels;

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public Wheels getWheels() {
        return wheels;
    }

    public void setWheels(Wheels wheels) {
        this.wheels = wheels;
    }

    public RollerSkates(){}
    public RollerSkates(int size,  String model,String type, Body body, Wheels wheels) {
        super(size, model, type);
        this.body = body;
        this.wheels = wheels;
    }

    @Override
    public void addToList() {
        FXMLLoader loader = new FXMLLoader();
        Parent root = null;
        try {
            root = loader.load(getClass().getResource("/sample/forms/RollerSkatesWindow.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Main.stage.setScene(new Scene(root));
    }

    @Override
    public void editInList(Event event) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/forms/RollerSkatesWindow.fxml"));
        Parent parent = null;
        try {
            parent = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(parent);
        Main.stage.setScene(scene);
        RollerSkatesController controller = loader.getController();
        controller.setParametrs(this);

    }
    @Override
    public String toString() {
        return this.getModel() + " (RollerSkates)";
    }
}

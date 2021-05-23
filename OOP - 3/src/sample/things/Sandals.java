package sample.things;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import sample.Main;
import sample.controllers.SandalsController;
import sample.elements.Body;
import sample.elements.Sole;

import java.io.IOException;

public class Sandals extends CasualShoes {
    private Body body;
    private Sole sole;

    @JacksonXmlProperty(isAttribute=true)
    public Body getBody() {
        return body;
    }
    @JacksonXmlProperty(isAttribute=true)
    public void setBody(Body body) {
        this.body = body;
    }
    @JacksonXmlProperty(isAttribute=true)
    public Sole getSole() {
        return sole;
    }
    @JacksonXmlProperty(isAttribute=true)
    public void setSole(Sole sole) {
        this.sole = sole;
    }

    public Sandals(){}

    public Sandals(int size, String model, String type, Body body, Sole sole) {
        super(size, model, type);
        this.body = body;
        this.sole = sole;
    }

    @Override
    public void addToList() {
        FXMLLoader loader = new FXMLLoader();
        Parent root = null;
        try {
            root = loader.load(getClass().getResource("/sample/forms/SandalsWindow.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Main.stage.setScene(new Scene(root));
    }

    @Override
    public void editInList(Event event) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/forms/SandalsWindow.fxml"));
        Parent parent = null;
        try {
            parent = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(parent);
        Main.stage.setScene(scene);
        SandalsController controller = loader.getController();
        controller.setParametrs(this);

    }
    @Override
    public String toString() {
        return this.getModel() + " (Sandals)";
    }
}

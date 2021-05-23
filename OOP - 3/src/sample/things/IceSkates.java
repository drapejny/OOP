package sample.things;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import sample.Main;
import sample.controllers.IceSkatesController;
import sample.controllers.SneakersController;
import sample.elements.Blade;
import sample.elements.Body;
import sample.elements.Laces;

import java.io.IOException;

public class IceSkates extends SportShoes {
    private Body body;
    private Laces laces;
    private Blade blade;

    @JacksonXmlProperty(isAttribute=true)
    public Body getBody() {
        return body;
    }
    @JacksonXmlProperty(isAttribute=true)
    public void setBody(Body body) {
        this.body = body;
    }
    @JacksonXmlProperty(isAttribute=true)
    public Laces getLaces() {
        return laces;
    }
    @JacksonXmlProperty(isAttribute=true)
    public void setLaces(Laces laces) {
        this.laces = laces;
    }
    @JacksonXmlProperty(isAttribute=true)
    public Blade getBlade() {
        return blade;
    }
    @JacksonXmlProperty(isAttribute=true)
    public void setBlade(Blade blade) {
        this.blade = blade;
    }

    public IceSkates(){}
    public IceSkates(int size, String model, String type, Blade blade, Laces laces, Body body) {
        super(size, model, type);
        this.blade = blade;
        this.laces = laces;
        this.body = body;
    }


    @Override
    public void addToList() {
        FXMLLoader loader = new FXMLLoader();
        Parent root = null;
        try {
            root = loader.load(getClass().getResource("/sample/forms/IceSkatesWindow.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Main.stage.setScene(new Scene(root));
    }

    @Override
    public void editInList(Event event) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/forms/IceSkatesWindow.fxml"));
        Parent parent = null;
        try {
            parent = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(parent);
        Main.stage.setScene(scene);
        IceSkatesController controller = loader.getController();
        controller.setParametrs(this);

    }
    @Override
    public String toString() {
        return this.getModel() + " (IceSkates)";
    }
}

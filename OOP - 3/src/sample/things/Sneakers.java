package sample.things;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Main;
import sample.controllers.SneakersController;
import sample.elements.Body;
import sample.elements.Laces;
import sample.elements.Sole;

import java.io.IOException;

public class Sneakers extends SportShoes {
    private Sole sole;
    private Laces laces;
    private Body body;

    @JacksonXmlProperty(isAttribute=true)
    public Sole getSole() {
        return sole;
    }
    @JacksonXmlProperty(isAttribute=true)
    public void setSole(Sole sole) {
        this.sole = sole;
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
    public Body getBody() {
        return body;
    }
    @JacksonXmlProperty(isAttribute=true)
    public void setBody(Body body) {
        this.body = body;
    }

    public Sneakers() {
    }

    public Sneakers(int size, String model, String type, Sole sole, Laces laces, Body body) {
        super(size, model, type);
        this.sole = sole;
        this.laces = laces;
        this.body = body;
    }

    @Override
    public void addToList() {
        FXMLLoader loader = new FXMLLoader();
        Parent root = null;
        try {
            root = loader.load(getClass().getResource("/sample/forms/SneakersWindow.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Main.stage.setScene(new Scene(root));
    }

    @Override
    public void editInList(Event event) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/forms/SneakersWindow.fxml"));
        Parent parent = null;
        try {
            parent = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(parent);
        Main.stage.setScene(scene);
//        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        window.setScene(scene);
//        window.show();
        SneakersController controller = loader.getController();
        controller.setParametrs(this);

    }

    @Override
    public String toString() {
        return this.getModel() + " (Sneakers)";
    }
}

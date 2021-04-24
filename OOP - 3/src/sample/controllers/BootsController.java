package sample.controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import sample.Main;
import sample.elements.Body;
import sample.elements.Laces;
import sample.elements.Sole;
import sample.things.Boots;
import sample.things.Sneakers;
import sample.things.Thing;

public class BootsController {

    @FXML
    private RadioButton menBtn;

    @FXML
    private RadioButton womenBtn;

    @FXML
    private Slider sizeSlider;

    @FXML
    private TextField modelTextField;

    @FXML
    private Text sizeText;

    @FXML
    private Text soleText;

    @FXML
    private Text bodyText;

    @FXML
    private Button okBtn;

    @FXML
    private TextField soleTextField;

    @FXML
    private TextField bodyTextField;
    ToggleGroup typeGroup = new ToggleGroup();

    Boots editionThing = null;

    public void initialize() {
        menBtn.setToggleGroup(typeGroup);
        womenBtn.setToggleGroup(typeGroup);
        menBtn.setSelected(true);
        sizeSlider.setValue(42);
        sizeText.setText("Size: 42");

        sizeSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> changed, Number oldValue, Number newValue) {
                sizeText.setText("Size: " + Math.round((Double)newValue));
            }
        });

        okBtn.setOnAction(actionEvent -> {
            String type = "";
            if (menBtn.isSelected())
                type = "Men";
            if (womenBtn.isSelected())
                type = "Women";
            int size = (int) Math.round(sizeSlider.getValue());
            String model = modelTextField.getText().trim();
            String soleMaterial = soleTextField.getText().trim();
            String bodyMaterial = bodyTextField.getText().trim();
            if (model.equals("") || soleMaterial.equals("") || bodyMaterial.equals("")) {
                showAlert();
                return;
            } else {
                if (editionThing == null)
                    Main.things.add(new Boots(size, model, type,  new Body(bodyMaterial), new Sole(soleMaterial)));
                else{
                    editionThing.setSize(size);
                    editionThing.setModel(model);
                    editionThing.setType(type);
                    editionThing.setSole(new Sole(soleMaterial));
                    editionThing.setBody(new Body(bodyMaterial));

                    //Костыль, чтобы обновить таблицу
                    int index = Main.things.indexOf(editionThing);
                    Main.things.remove(index);
                    Main.controller.resetTable();
                    Main.things.add(index,editionThing);
                    Main.controller.resetTable();

                }
                Main.stage.setScene(Main.scene);
            }
        });
    }

    public void setParametrs(Boots boots) {
        editionThing = boots;
        if (boots.getType().equals("Men"))
            menBtn.setSelected(true);
        else womenBtn.setSelected(true);
        sizeSlider.setValue(boots.getSize());
        modelTextField.setText(boots.getModel());
        soleTextField.setText(boots.getSole().getMaterial());
        bodyTextField.setText(boots.getBody().getMaterial());
    }

    public void showAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Ошибка ввода");
        alert.showAndWait();
    }
}
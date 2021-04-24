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
import sample.things.Sneakers;
import sample.things.Thing;

public class SneakersController {
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
    private Text lacesText;

    @FXML
    private Slider lacesSlider;

    @FXML
    private Button okBtn;

    @FXML
    private TextField soleTextField;

    @FXML
    private TextField bodyTextField;

    ToggleGroup typeGroup = new ToggleGroup();

    Sneakers editionThing = null;

    public void initialize() {
        menBtn.setToggleGroup(typeGroup);
        womenBtn.setToggleGroup(typeGroup);
        menBtn.setSelected(true);
        sizeSlider.setValue(42);
        lacesSlider.setValue(35);
        sizeText.setText("Size: 42");
        lacesText.setText("Laces length: 35");

        sizeSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> changed, Number oldValue, Number newValue) {
                sizeText.setText("Size: " + Math.round((Double)newValue));
            }
        });

        lacesSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> changed, Number oldValue, Number newValue) {
                lacesText.setText("Laces length: " + Math.round((Double)newValue));
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
            int lacesLength = (int) Math.round(lacesSlider.getValue());
            if (model.equals("") || soleMaterial.equals("") || bodyMaterial.equals("")) {
                showAlert();
                return;
            } else {
                if (editionThing == null)
                    Main.things.add(new Sneakers(size, model, type, new Sole(soleMaterial), new Laces(lacesLength), new Body(bodyMaterial)));
                else{
                    editionThing.setSize(size);
                    editionThing.setModel(model);
                    editionThing.setType(type);
                    editionThing.setSole(new Sole(soleMaterial));
                    editionThing.setLaces(new Laces(lacesLength));
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

    public void setParametrs(Sneakers sneakers) {
        editionThing = sneakers;
        if (sneakers.getType().equals("Men"))
            menBtn.setSelected(true);
        else womenBtn.setSelected(true);
        sizeSlider.setValue(sneakers.getSize());
        modelTextField.setText(sneakers.getModel());
        soleTextField.setText(sneakers.getSole().getMaterial());
        bodyTextField.setText(sneakers.getBody().getMaterial());
        lacesSlider.setValue(sneakers.getLaces().getLength());
    }

    public void showAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Ошибка ввода");
        alert.showAndWait();
    }
}

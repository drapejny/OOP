package sample.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import sample.Main;
import sample.things.*;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.spi.AbstractResourceBundleProvider;

public class Controller {
    @FXML
    private ListView<Thing> modelsListView;
    @FXML
    private Button addBtn;
    @FXML
    private Button editBtn;
    @FXML
    private Button deleteBtn;
    @FXML
    private ComboBox<String> shoesTypeComboBox;
    @FXML
    private RadioButton txtBtn;
    @FXML
    private RadioButton binBtn;
    @FXML
    private RadioButton xmlBtn;
    @FXML
    private Button saveBtn;
    @FXML
    private Button loadBtn;


    public void initialize() {
        shoesTypeComboBox.getItems().addAll("Sneakers", "Sandals", "Boots", "IceSkates", "RollerSkates");
        modelsListView.setItems(Main.things);

        ToggleGroup methodGroup = new ToggleGroup();

        xmlBtn.setToggleGroup(methodGroup);
        binBtn.setToggleGroup(methodGroup);
        txtBtn.setToggleGroup(methodGroup);

        addBtn.setOnAction(actionEvent -> {
            Thing thing = null;
            if (shoesTypeComboBox.getSelectionModel().getSelectedItem().equals("Sneakers")) {
                thing = new Sneakers();
            }
            if (shoesTypeComboBox.getSelectionModel().getSelectedItem().equals("Sandals")) {
                thing = new Sandals();
            }
            if (shoesTypeComboBox.getSelectionModel().getSelectedItem().equals("Boots")) {
                thing = new Boots();
            }
            if (shoesTypeComboBox.getSelectionModel().getSelectedItem().equals("RollerSkates")) {
                thing = new RollerSkates();
            }
            if (shoesTypeComboBox.getSelectionModel().getSelectedItem().equals("IceSkates")) {
                thing = new IceSkates();
            }
            thing.addToList();
        });

        editBtn.setOnAction(actionEvent -> {
            if (modelsListView.getSelectionModel().getSelectedIndex() >= 0) {
                Main.things.get(modelsListView.getSelectionModel().getSelectedIndex()).editInList(actionEvent);
            }
        });

        deleteBtn.setOnAction(actionEvent -> {
            if (modelsListView.getSelectionModel().getSelectedIndex() >= 0) {
                Main.things.remove(modelsListView.getSelectionModel().getSelectedIndex());
            }
        });

        saveBtn.setOnAction(actionEvent -> {
            if (xmlBtn.isSelected()) {
                try {
                    FileOutputStream fos = new FileOutputStream("objects.xml");
                    XMLEncoder xmlEncoder = new XMLEncoder(fos);
                    for (int i = 0; i < Main.things.size(); i++) {
                        xmlEncoder.writeObject(Main.things.get(i));
                    }
                    xmlEncoder.close();
                    fos.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (binBtn.isSelected()) {
                try {
                    FileOutputStream fos = new FileOutputStream("objects.bin");
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    for (int i = 0; i < Main.things.size(); i++) {
                        oos.writeObject(Main.things.get(i));
                    }
                    fos.close();
                    oos.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (txtBtn.isSelected()) {
                try (FileWriter fw = new FileWriter("objects.txt")) {
                    System.out.println("-------------------------------------------------------------------");
                    fw.write("-------------------------------------------------------------------\n");
                    for (int i = 0; i < Main.things.size(); i++) {
                        Thing thing = Main.things.get(i);
                        System.out.println(thing.getClass());
                        fw.write(thing.getClass() + "\n");
                        Class myClass = thing.getClass();
                        while (myClass != Object.class) {
                            Field[] fields = myClass.getDeclaredFields();
                            for (int j = 0; j < fields.length; j++) {
                                fields[j].setAccessible(true);
                                try {
                                    if (!fields[j].getType().isPrimitive() && !fields[j].getType().equals(String.class)) {
                                        System.out.println("  " + fields[j].getName() + " " + fields[j].getType());
                                        fw.write("  " + fields[j].getName() + " " + fields[j].getType() + "\n");
                                        System.out.println("{");
                                        fw.write("{" + "\n");
                                        Class ob = fields[j].get(thing).getClass();
                                        Field[] obFields = ob.getDeclaredFields();
                                        for (int k = 0; k < obFields.length; k++) {
                                            obFields[k].setAccessible(true);
                                            System.out.println("  " + obFields[k].getName() + " " + obFields[k].getType() + " " + obFields[k].get(fields[j].get(thing)));
                                            fw.write("  " + obFields[k].getName() + " " + obFields[k].getType() + " " + obFields[k].get(fields[j].get(thing)) + "\n");
                                        }
                                        System.out.println("}");
                                        fw.write("}" + "\n");
                                        continue;
                                    }
                                    System.out.println("  " + fields[j].getName() + " " + fields[j].getType() + " " + fields[j].get(thing));
                                    fw.write("  " + fields[j].getName() + " " + fields[j].getType() + " " + fields[j].get(thing) + "\n");
                                } catch (IllegalAccessException e) {
                                    e.printStackTrace();
                                }

                            }
                            myClass = myClass.getSuperclass();
                        }
                        System.out.println("-----------------------------------------------------------------------");
                        fw.write("-------------------------------------------------------------------\n");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        });

        loadBtn.setOnAction(actionEvent -> {
            if (xmlBtn.isSelected()) {
                try {
                    FileInputStream fis = new FileInputStream("objects.xml");
                    XMLDecoder xmlDecoder = new XMLDecoder(fis);
                    try {
                        Main.things.clear();
                        while (true)
                            Main.things.add((Thing) xmlDecoder.readObject());
                    } catch (ArrayIndexOutOfBoundsException e) {

                    }
                    xmlDecoder.close();
                    fis.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (binBtn.isSelected()) {
                try {
                    FileInputStream fis = new FileInputStream("objects.bin");
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    Main.things.clear();
                    try {
                        while (fis.available() > 0) {
                            Main.things.add((Thing) ois.readObject());
                        }
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    ois.close();
                    fis.close();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (txtBtn.isSelected()) {
                Main.things.clear();
                List<String> lines;
                try {
                    lines = Files.readAllLines(Paths.get("objects.txt"));
                    for (int i = 0; i < lines.size() - 1; i++) {
                        System.out.println(Arrays.toString(lines.get(i).trim().split("\\s+")));
                        String str = lines.get(i);
                        if (str.charAt(0) == '-') {
                            Object thing;
                            Class<?> myClass;
                            i++;
                            System.out.println(Arrays.toString(lines.get(i).trim().split("\\s+")));
                            str = lines.get(i);
                            String[] line = str.trim().split("\\s+");
                            myClass = Class.forName(line[1]);
                            thing = myClass.newInstance();
                            i++;
                            System.out.println(Arrays.toString(lines.get(i).trim().split("\\s+")));
                            str = lines.get(i);
                            ArrayList<Object> params = new ArrayList<>();
                            while (lines.get(i).charAt(0) != '-') {
                                if (lines.get(i + 1).charAt(0) == '{') {
                                    str = lines.get(i);
                                    line = str.trim().split("\\s+");
                                    Class ob = Class.forName(line[2]);
                                    Object object = ob.newInstance();
                                    Field[] obFields = ob.getDeclaredFields();
                                    i++; //{
                                    System.out.println(Arrays.toString(lines.get(i).trim().split("\\s+")));
                                    i++;
                                    System.out.println(Arrays.toString(lines.get(i).trim().split("\\s+")));
                                    for (int j = 0; j < obFields.length; j++) {
                                        System.out.println("!!!");
                                        obFields[j].setAccessible(true);
                                        str = lines.get(i);
                                        line = str.trim().split("\\s+");
                                        if (line[1].equals("int"))
                                            obFields[j].set(object, Integer.parseInt(line[2]));
                                        else
                                            obFields[j].set(object, line[3]);
                                        i++;
                                        System.out.println(Arrays.toString(lines.get(i).trim().split("\\s+")));
                                    }
                                    params.add(object);
                                } else {
                                    str = lines.get(i);
                                    line = str.trim().split("\\s+");
                                    Object primitiveObject = null;
                                    if (line[1].equals("int")) {
                                        primitiveObject = Integer.parseInt(line[2]);
                                    } else if (line[2].equals("java.lang.String")) {
                                        primitiveObject = line[3];
                                    }
                                    params.add(primitiveObject);
                                }
                                i++;
                                System.out.println(Arrays.toString(lines.get(i).trim().split("\\s+")));
                            }
                            Class<?> superClass = myClass;
                            int counter = 0;
                            while (superClass != Object.class) {
                                Field[] fields = superClass.getDeclaredFields();
                                for (int j = 0; j < fields.length; j++) {
                                    fields[j].setAccessible(true);
                                    fields[j].set(thing, params.get(counter));
                                    counter++;
                                }
                                superClass = superClass.getSuperclass();
                            }
                            Main.things.add((Thing) thing);
                            i--;
                            System.out.println(Arrays.toString(lines.get(i).trim().split("\\s+")));
                        }
                    }
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void resetTable() {
        modelsListView.setItems(Main.things);
    }
}

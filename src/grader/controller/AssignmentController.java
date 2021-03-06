package grader.controller;

import grader.model.items.Assignment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AssignmentController implements Initializable {
    @FXML ComboBox cbCatParent;
    @FXML TextField tfCatName;
    @FXML TextField tfWeight;
    @FXML TextField tfRawScore;
    @FXML DatePicker dpDueDate;
    @FXML CheckBox chbHandin;
    @FXML Label lHandin;
    @FXML TextField tfHandin;
    @FXML Button bAdd;


    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        ObservableList<String> parentOptions =
                FXCollections.observableArrayList(
                        "CPE 309",
                        "Tests",
                        "Projects",
                        "Quizzes",
                        "Midterms"
                );
        cbCatParent.setValue(parentOptions.get(0));
        cbCatParent.setItems(parentOptions);

    }

    public void onAddButtonPress(ActionEvent actionEvent)
    {
        System.out.println("Name: " + tfCatName.getText());
        System.out.println("Parent: " + cbCatParent.getValue());
        System.out.println("Raw Scores: " + tfRawScore.getText());
        System.out.println("Weight: " + tfWeight.getText());
        System.out.println("Due Date: " + dpDueDate.getValue());
        System.out.println("Handin: " + chbHandin.isSelected() + (chbHandin.isSelected() ? " directory: " + tfHandin.getText() : ""));

        if(cbCatParent.getValue().equals("CPE 309"))
        {
            MainController.course.add(new Assignment());
        }
        else
        {
            MainController.course.categories.get(0).add(new Assignment());
        }

        Stage stage = (Stage) bAdd.getScene().getWindow();
        stage.close();
    }

    public void onHandinChecked(ActionEvent event)
    {
        lHandin.setDisable(!chbHandin.isSelected());
        tfHandin.setDisable(!chbHandin.isSelected());
    }
}

package com.fg.footballgames.Admin.Controllers;
import com.fg.footballgames.AppComponents.ClassToObject;
import com.fg.footballgames.AppComponents.DaoTableManager;
import com.fg.footballgames.AppComponents.TableViewWrapper;
import com.fg.footballgames.DAOs.DaoTableEnum;
import com.fg.footballgames.DAOs.IDaoTableModel;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


public class AdminMainCenterController {

    @FXML
    TextField whereTextField;

    @FXML
    ComboBox tableChoiceComboBox;

    @FXML
    TextField setTextField;

    @FXML
    TextField valuesTextField;

    @FXML
    ComboBox columnChoiceComboBox;

    @FXML
    TableView queryView;

    @FXML
    Button insertButton;

    @FXML
    Button updateButton;

    @FXML
    Button deleteButton;

    @FXML
    AnchorPane insertAnchorPane;

    @FXML
    Label fieldNameLabel;

    @FXML
    TextField insertValueTextField;

    @FXML
    Label currentValuesLabel;

    @FXML
    Button sendValueButton;

    @FXML
    Button dismissQueryButton;

    private ObservableList<IDaoTableModel> modelsList;

    private DaoTableEnum classType;

    private Field[] insertFields;

    private List<String> valuesToInsert;

    @FXML
    private void initialize(){

        valuesToInsert = new ArrayList<>();

        var tablesList = DaoTableEnum.values();

        for(var table : tablesList){
            tableChoiceComboBox.getItems().add(table.toString());
        }

        insertAnchorPane.setVisible(false);
    }

    @FXML
    private void tableChoiceComboAction(ActionEvent event){

        classType = DaoTableEnum.valueOf(tableChoiceComboBox.getValue().toString());

        updateQueryView();
        updateColumnChoiceCombobox();
    }

    @FXML
    private void insertButtonPressed(ActionEvent event){
        insertAnchorPane.setVisible(true);

        insertFields = classType.getClassName().getDeclaredFields();

        currentValuesLabel.setText(insertFields[0].getName() + " = ");
        fieldNameLabel.setText(insertFields[0].getName());
    }

    @FXML
    private void updateButtonPressed(ActionEvent event){

        var ID = getChosenRecordID();
        var dao = ClassToObject.createObject(classType.getClassName(), ID);
        var column = columnChoiceComboBox.getValue().toString();
        var value = valuesTextField.getText();

        var succeeded = DaoTableManager.update(dao, column, value);

        updateQueryView();
        valuesTextField.clear();
    }

    @FXML
    private void deleteButtonPressed(ActionEvent event){

        var ID = getChosenRecordID();

        var dao = ClassToObject.createObject(classType.getClassName(), ID);

        DaoTableManager.delete(dao);

        updateQueryView();
    }

    @FXML
    private void sendButtonPressed(ActionEvent event){

        if(insertFields[insertFields.length - 1].getName().equals(fieldNameLabel.getText())){

            valuesToInsert.add(insertValueTextField.getText());

            var dao = ClassToObject.createObject(classType.getClassName(), valuesToInsert);
            DaoTableManager.insert(dao);

            updateQueryView();

            valuesToInsert.clear();
            insertFields = null;
            insertValueTextField.clear();
            fieldNameLabel.setText("");

            insertAnchorPane.setVisible(false);

            return;
        }

        valuesToInsert.add(insertValueTextField.getText());



        fieldNameLabel.setText(insertFields[valuesToInsert.size()].getName());

        var labelText = currentValuesLabel.getText().toString() + " " + insertValueTextField.getText() + ", " + insertFields[valuesToInsert.size()].getName() + " = ";
        currentValuesLabel.setText(labelText);
        insertValueTextField.clear();
    }

    @FXML
    private void dismissQueryButtonPressed(ActionEvent event){
        valuesToInsert.clear();
        insertFields = null;
        insertValueTextField.clear();
        fieldNameLabel.setText("");

        insertAnchorPane.setVisible(false);
    }

    private void updateQueryView(){

        queryView.getColumns().clear();

        modelsList = DaoTableManager.selectAll(classType.getClassName());

        queryView.setItems(modelsList);
        queryView.getColumns().addAll(TableViewWrapper.tableListToTableColumnsList(classType.getClassName()));

    }

    private String getChosenRecordID(){

        final ObservableList<TablePosition> selectedCells = queryView.getSelectionModel().getSelectedCells();
        var row = selectedCells.get(0).getRow();

        return modelsList.get(row).getID();
    }

    private void updateColumnChoiceCombobox(){
        columnChoiceComboBox.getItems().clear();

        var clazz = classType.getClassName();
        var fields = clazz.getDeclaredFields();

        for(var field : fields){
            columnChoiceComboBox.getItems().add(field.getName());
        }
    }
}


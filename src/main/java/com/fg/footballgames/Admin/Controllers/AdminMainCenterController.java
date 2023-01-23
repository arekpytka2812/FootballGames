package com.fg.footballgames.Admin.Controllers;
import com.fg.footballgames.AppComponents.ClassToObject;
import com.fg.footballgames.AppComponents.DaoTableManager;
import com.fg.footballgames.AppComponents.TableViewWrapper;
import com.fg.footballgames.DAOs.DaoTableEnum;
import com.fg.footballgames.DAOs.IDaoTableModel;
import com.fg.footballgames.DAOs.Tables.Accounts;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

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

    private ObservableList<IDaoTableModel> modelsList;

    private DaoTableEnum classType;

    @FXML
    private void initialize(){

        var tablesList = DaoTableEnum.values();

        for(var table : tablesList){
            tableChoiceComboBox.getItems().add(table.toString());
        }

    }

    @FXML
    private void tableChoiceComboAction(ActionEvent event){

        classType = DaoTableEnum.valueOf(tableChoiceComboBox.getValue().toString());

        updateQueryView();
        updateColumnChoiceCombobox();
    }

    @FXML
    private void insertButtonPressed(ActionEvent event){


        // TODO rozrózniac czy dodawane jest konto uzytkownika czy cokolwiek innego i wywoływac albo inserta albo insertNewAccount

    }

    @FXML
    private void updateButtonPressed(ActionEvent event){

        var ID = getChosenRecordID();
        var dao = ClassToObject.createObject(classType.getClassName(), ID);
        var column = columnChoiceComboBox.getValue().toString();
        var value = valuesTextField.getText();

        var succeeded = DaoTableManager.update(dao, column, value);

        if(!succeeded){
        }

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


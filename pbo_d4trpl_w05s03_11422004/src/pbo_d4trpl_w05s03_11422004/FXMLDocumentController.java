/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package pbo_d4trpl_w05s03_11422004;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;


/**
 *
 * @author benya
 */
public class FXMLDocumentController implements Initializable {
    @FXML
    private TextField txtNim;

    @FXML
    private Button btnOk;

    @FXML
    private RadioButton radKel2;

    @FXML
    private RadioButton radKel1;

    @FXML
    private Button btnEdit;

    @FXML
    private ComboBox<String> cmbFakultas;

    @FXML
    private TextField txtNama;

    @FXML
    private TextField txtTempat;

    @FXML
    private TextField txtTanggal;

    @FXML
    private Button btnCancel;

    @FXML
    private TextField txtHobby;

    @FXML
    private ListView<String> listHoby;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnAdd;

    @FXML
    private ComboBox<String> cmbStudi;

    private ToggleGroup radKelToggleGroup;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cmbFakultas.getItems().addAll("Fakultas Informatika & Teknik Elektro", "Fakultas Vokasi", "Fakultas Bioteknologi", "Fakultas Teknologi Industri");
        cmbFakultas.setValue("Pilih Fakultas");
         
        // Inisialisasi ToggleGroup
        radKelToggleGroup = new ToggleGroup();
        radKel1.setToggleGroup(radKelToggleGroup);
        radKel2.setToggleGroup(radKelToggleGroup);
    }

    @FXML
    void getPilihStudi(ActionEvent event) {
        switch (cmbFakultas.getValue()) {
            case "Fakultas Informatika & Teknik Elektro":
                cmbStudi.getItems().clear();
                cmbStudi.getItems().addAll("S1 Informatika", "S1 Sistem Informasi", "S1 Teknik Elektro");
                break;
            case "Fakultas Vokasi":
                cmbStudi.getItems().clear();
                cmbStudi.getItems().addAll("D4 TRPL", "D3 Teknologi Informasi", "D3 Teknologi Komputer");
                break;
            case "Fakultas Bioteknologi":
                cmbStudi.getItems().clear();
                cmbStudi.getItems().addAll("S1 Teknik Bioproses");
                break;
            case "Fakultas Teknologi Industri":
                cmbStudi.getItems().clear();
                cmbStudi.getItems().addAll("S1 Manajemen Rekayasa", "S1 Metalurgi");
                break;
            default:
                break;
        }
    }

    
    @FXML
    void getKelamin(ActionEvent event){
        if(radKel1.isSelected()){
            radKel1.setSelected(true);
        }else if(radKel2.isSelected()){
            radKel2.setSelected(true);;
        }  
    }
    
    @FXML
    void addHobby(ActionEvent event){
        listHoby.getItems().add(txtHobby.getText());
    }
    
    @FXML
    void removeHobby(ActionEvent event){
        int selectedId = listHoby.getSelectionModel().getSelectedIndex();
        listHoby.getItems().remove(selectedId);
    }
    
    @FXML
    void editHobby(ActionEvent event){
        int selectedId = listHoby.getSelectionModel().getSelectedIndex();
        listHoby.getItems().set(selectedId, txtHobby.getText());
        listHoby.refresh();
        txtHobby.getText();
    }
    
    @FXML
    void submit(ActionEvent event){
        txtNama.setText(" ");
        txtNim.setText(" ");
        radKel1.setSelected(false);
        radKel2.setSelected(false);
        txtTempat.setText(" ");
        txtTanggal.setText(" ");
        txtHobby.setText(" ");
        cmbFakultas.setValue("Pilih Fakultas");
//        cmbStudi.setValue("Pilih Studi");
        listHoby.getItems().clear();
    }
    
    @FXML
    void cancel(ActionEvent event){
        Platform.exit();
    } 
}

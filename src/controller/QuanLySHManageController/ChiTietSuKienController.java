/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller.QuanLySHManageController;

import Services.SuKienService;
import controller.StageController;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.SuKien;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class ChiTietSuKienController implements Initializable {

    private StageController sc = new StageController();
    private int id;
    private SuKienService c = new SuKienService();
    @FXML
    private TextField tenSuKien;
    @FXML
    private TextField thoiGian;
    @FXML
    private TextField diaDiem;
    @FXML
    private TextArea noiDung;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setThongTinSuKien(SuKien sk) {
        tenSuKien.setText(sk.getName());
        thoiGian.setText(sk.getTime());
        diaDiem.setText(sk.getPlace());
        noiDung.setText(sk.getContent());

        this.setId(sk.getId());
    }

    @FXML
    public void updateSuKien() throws SQLException, ClassNotFoundException {
        int res = c.updateSuKien(this.getId(), tenSuKien.getText(), diaDiem.getText(), thoiGian.getText(), noiDung.getText());
        if (res == 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("");
            alert.setHeaderText("Đã xảy ra lỗi, vui lòng kiểm tra lại!");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("");
            alert.setHeaderText("Thành công");
            alert.showAndWait();
        }
    }

}

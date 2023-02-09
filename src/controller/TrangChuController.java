/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Admin
 */
public class TrangChuController implements Initializable {

    
    private StageController sc = new StageController();
    @FXML
    private Button hokhau_btn;
    @FXML
    private Button nhankhau_btn;
    @FXML
    private Pane nhankhau_pane;
    @FXML
    private Pane quanlysh_pane;
    @FXML
    private Pane quanlydiem_pane;
    @FXML
    private Pane hokhau_pane;
    @FXML
    private Pane thongke_pane;
    @FXML
    private TextField toTruong;
    @FXML
    private TextField nhanKhau;
    @FXML
    private TextField hoKhau;
    @FXML
    private TextField tamTru;
    @FXML
    private TextField tamVang;

    @FXML
    private void switchToHoKhauScene(ActionEvent e) throws IOException {
        sc.switchToHoKhauScene(e);
    }

    @FXML
    private void switchToNhanKhauScene(ActionEvent e) throws IOException {
        sc.switchToNhanKhauScene(e);
    }

    @FXML
    private void switchToTrangChuScene(ActionEvent e) throws IOException {
        sc.switchToTrangChuScene(e);
    }

    @FXML
    void switchToThongKeScene(ActionEvent e) throws IOException {
        sc.switchToThongKeScene(e);
    }

    @FXML
    void switchToQLSinhHoatScene(ActionEvent e) throws IOException {
        sc.switchToQLSinhHoatScene(e);
    }

    @FXML
    void switchToTinhDiemScene(ActionEvent e) throws IOException {
        sc.switchToTinhDiemScene(e);
    }

    @FXML
    public void handleLogout(ActionEvent e) throws IOException {
        sc.handleLogout(e);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        phan_quyen();

        toTruong.setDisable(true);
        tamTru.setDisable(true);
        tamVang.setDisable(true);
        nhanKhau.setDisable(true);
        hoKhau.setDisable(true);

    }

    public void phan_quyen() {
        if (LoginController.user.getRole().equals("to_truong")) {
            quanlysh_pane.setVisible(false);
            quanlysh_pane.setManaged(false);

            quanlydiem_pane.setVisible(false);
            quanlydiem_pane.setManaged(false);
        }
        if (LoginController.user.getRole().equals("can_bo")) {
            hokhau_pane.setVisible(false);
            hokhau_pane.setManaged(false);

            nhankhau_pane.setVisible(false);
            nhankhau_pane.setManaged(false);

            thongke_pane.setVisible(false);
            thongke_pane.setManaged(false);
        }
    }
}

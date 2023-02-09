/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.NhanKhauManageController;

import model.*;
import Services.MysqlConnection;
import controller.LoginController;
import controller.StageController;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class DangKyTamTruController implements Initializable {

    private StageController sc = new StageController();

    private DangKyTamTruController controller;
    private TamTruModel tamTruModel;

    @FXML
    private Pane nhankhau_pane;
    @FXML
    private Pane quanlysh_pane;
    @FXML
    private Pane hokhau_pane;
    @FXML
    private Pane thongke_pane;

    @FXML
    private TextField soCMT_TextField;

    @FXML
    private Pane check_pane;

    @FXML
    private TextField maGiayTamTru_TextField;

    @FXML
    private TextField soDienThoai_TextField;

    @FXML
    private DatePicker tuNgay_DatePicker;

    @FXML
    private DatePicker denNgay_DatePicker;

    @FXML
    private TextArea lyDo_TextArea;

    @FXML
    private Button check_Button;

    @FXML
    private Button dangKyTamTru_Button;

    @FXML
    public void switchToHoKhauScene(ActionEvent e) throws IOException {
        sc.switchToHoKhauScene(e);
    }

    @FXML
    public void switchToNhanKhauScene(ActionEvent e) throws IOException {
        sc.switchToNhanKhauScene(e);
    }

    @FXML
    public void switchToThongKeScene(ActionEvent e) throws IOException {
        sc.switchToThongKeScene(e);
    }

    @FXML
    public void switchToTrangChuScene(ActionEvent e) throws IOException {
        sc.switchToTrangChuScene(e);
    }

    @FXML
    public void switchToQLSinhHoatScene(ActionEvent e) throws IOException {
        sc.switchToQLSinhHoatScene(e);
    }

    @FXML
    public void switchToThemNhanKhauScene(ActionEvent e) throws IOException {
        sc.switchToThemNhanKhauScene(e);
    }

    @FXML
    public void switchToDangKyTamVangScene(ActionEvent e) throws IOException {
        sc.switchToDangKyTamVangScene(e);
    }

    @FXML
    public void switchToDangKyTamTruScene(ActionEvent e) throws IOException {
        sc.switchToDangKyTamTruScene(e);
    }

    @FXML
    public void switchToKhaiTuScene(ActionEvent e) throws IOException {
        sc.switchToKhaiTuScene(e);
    }

    public void phan_quyen() {
        if (LoginController.user.getRole().equals("to_truong")) {
            quanlysh_pane.setVisible(false);
            quanlysh_pane.setManaged(false);
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

    public int checkCMT(String cmt) {
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT * FROM nhan_khau LEFT JOIN chung_minh_thu ON nhan_khau.ID = chung_minh_thu.idNhanKhau WHERE soCMT = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, cmt);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return rs.getInt("ID");
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Thông báo");
            alert.setHeaderText("Có lỗi xảy ra! vui lòng kiểm tra lại.");
            alert.show();
            //JOptionPane.showMessageDialog(null, "Có lỗi xảy ra! vui lòng kiểm tra lại.", "Warning!!", JOptionPane.WARNING_MESSAGE);
        }
        return -1;
    }

    public boolean addNew(TamTruModel tamTruModel) {
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "INSERT INTO tam_tru(idNhanKhau, maGiayTamTru, soDienThoaiNguoiDangKy, tuNgay, denNgay, lyDo)" + " value (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, tamTruModel.getIdNhanKhau());
            preparedStatement.setString(2, tamTruModel.getMaGiayTamTru());
            preparedStatement.setString(3, tamTruModel.getSoDienThoaiNguoiDangKy());
            Date tuNgay = new Date(tamTruModel.getTuNgay().getTime());
            preparedStatement.setDate(4, tuNgay);
            Date denNgay = new Date(tamTruModel.getDenNgay().getTime());
            preparedStatement.setDate(5, denNgay);
            preparedStatement.setString(6, tamTruModel.getLyDo());
            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Thông báo");
            alert.setHeaderText("Có lỗi xảy ra! vui lòng kiểm tra lại.");
            alert.show();
            //JOptionPane.showMessageDialog(null, "Có lỗi xảy ra! vui lòng kiểm tra lại.", "Warning!!", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }

    public boolean checkCMT() {
        if (soCMT_TextField.getText().trim() == "") {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Thông báo");
            alert.setHeaderText("Vui lòng nhập số CMT");
            alert.show();
            return false;
        } else if (soCMT_TextField.getText().trim().length() < 12 || soCMT_TextField.getText().trim().length() > 12) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Thông báo");
            alert.setHeaderText("Vui lòng nhập đúng định dạng CMT");
            alert.show();
            return false;
        } else {
            int res = checkCMT(soCMT_TextField.getText().trim());
            if (res == -1) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Thông báo");
                alert.setHeaderText("Số CMT không tồn tại!");
                alert.show();
                check_pane.setVisible(false);
                return false;
            } else {
                check_pane.setVisible(true);
                return true;
            }
        }
    }

    private boolean checkThongTinTamTru() {
        if (maGiayTamTru_TextField.getText().trim().isEmpty()
                || soDienThoai_TextField.getText().trim().isEmpty()
                || lyDo_TextArea.getText().trim().isEmpty()
                || tuNgay_DatePicker.getValue() == null
                || denNgay_DatePicker.getValue() == null) {
            return false;
        }
        return true;
    }

    @FXML
    public void dangKyTamTru() throws SQLException {
        try {
            if (checkThongTinTamTru()) {
//                Connection connection = MysqlConnection.getMysqlConnection();
//                String query = "INSERT INTO tam_tru(idNhanKhau, maGiayTamTru, soDienThoaiNguoiDangKy, tuNgay, denNgay, lyDo)" + " value (?, ?, ?, ?, ?, ?)";

                //PreparedStatement preparedStatement = connection.prepareStatement(query);
                TamTruModel tamTruModel = new TamTruModel();
                tamTruModel.setMaGiayTamTru(this.maGiayTamTru_TextField.getText().trim());
                //checkCMT(soCMT_TextField.getText().trim())admin   1
                tamTruModel.setID(39);
                tamTruModel.setSoDienThoaiNguoiDangKy(this.soDienThoai_TextField.getText().trim());

                tamTruModel.setTuNgay(java.sql.Date.valueOf(this.tuNgay_DatePicker.getValue()));
                tamTruModel.setDenNgay(java.sql.Date.valueOf(this.denNgay_DatePicker.getValue()));
                tamTruModel.setLyDo(this.lyDo_TextArea.getText().trim());
                boolean res = addNew(new TamTruModel(39,
                        maGiayTamTru_TextField.getText().trim(),
                        soDienThoai_TextField.getText().trim(),
                        java.sql.Date.valueOf(this.tuNgay_DatePicker.getValue()), java.sql.Date.valueOf(this.denNgay_DatePicker.getValue()),
                        lyDo_TextArea.getText().trim()));
                if (res && checkCMT()) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Thông báo");
                    alert.setHeaderText("Thành công!");
                    alert.show();

                    resetInput();

                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Thông báo");
                alert.setHeaderText("Vui lòng nhập đầy đủ thông tin!");
                alert.show();
            }

            //java.sql.Date.valueOf(denNgay_DatePicker.getValue())
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @FXML
    public void handleExit() {
        sc.handleExit();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        phan_quyen();

        check_pane.setVisible(false);
    }

    public void resetInput() {
        soCMT_TextField.setText("");
        maGiayTamTru_TextField.setText("");
        soDienThoai_TextField.setText("");
        tuNgay_DatePicker.setValue(null);
        denNgay_DatePicker.setValue(null);

        check_pane.setVisible(false);
    }

}

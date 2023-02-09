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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
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
public class KhaiTuController implements Initializable {

    private StageController sc = new StageController();

    @FXML
    private Pane nhankhau_pane;
    @FXML
    private Pane quanlysh_pane;
    @FXML
    private Pane hokhau_pane;
    @FXML
    private Pane thongke_pane;

    @FXML
    private TextField soCMTnguoiKhai_TextField;

    @FXML
    private TextField soCMTnguoiChet_TextField;

    @FXML
    private TextField soGiayKhaiTu_TextField;

    @FXML
    private DatePicker ngayKhai_DatePicker;

    @FXML
    private DatePicker ngayChet_DatePicker;

    @FXML
    private TextArea lyDo_TextArea;

    @FXML
    private Button checkNguoiKhai_Button;

    @FXML
    private Button checkNguoiChet_Button;

    @FXML
    private Button xacNhan_Button;
    @FXML
    private Pane check_pane1;
    @FXML
    private Pane check_pane2;

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

   
    public boolean addNew(KhaiTuModel khaiTuModel) {
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            //String query = "INSERT INTO khai_tu(idNhanKhau, , lyDo)" + " value (?, ?, ?, ?, ?, ?)";
            String query = "INSERT INTO khai_tu(ID, soGiayKhaiTu, idNguoiKhai, idNguoiChet, ngayKhai, ngayChet, lyDoChet)" + " value (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, khaiTuModel.getID());
            preparedStatement.setString(2, khaiTuModel.getSoGiayKhaiTu());
            preparedStatement.setInt(3, khaiTuModel.getIdNguoiKhai());
            preparedStatement.setInt(4, khaiTuModel.getIdNguoiChet());
            //preparedStatement.setString(3, String.valueOf(khaiTuModel.getIdNguoiKhai()));
            //preparedStatement.setString(4, String.valueOf(khaiTuModel.getIdNguoiChet()));

            java.sql.Date ngayKhai = new java.sql.Date(khaiTuModel.getNgayKhai().getTime());
            preparedStatement.setDate(5, ngayKhai);
            java.sql.Date ngayChet = new java.sql.Date(khaiTuModel.getNgayChet().getTime());
            preparedStatement.setDate(6, ngayChet);
            preparedStatement.setString(7, khaiTuModel.getLyDoChet());

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

    public boolean checkThongTinKhaiTu() {
        if (soGiayKhaiTu_TextField.getText().trim().isEmpty()
                || soCMTnguoiChet_TextField.getText().trim().isEmpty()
                || lyDo_TextArea.getText().trim().isEmpty()
                || soCMTnguoiKhai_TextField.getText().trim().isEmpty()) {
            return false;
        }
        return true;
    }

    public void checkCMT_khaitu(ActionEvent e) {
        if (soCMTnguoiKhai_TextField.getText().trim() == "" || soCMTnguoiKhai_TextField.getText().trim().length() != 12) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Thông báo");
            alert.setHeaderText("Vui lòng nhập đúng định dạng CMT/CCCD");
            alert.show();
        } else {
            int res;
            res = checkCMT(soCMTnguoiKhai_TextField.getText().trim());
            if (res != -1) {
                check_pane1.setVisible(true);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Thông báo");
                alert.setHeaderText("Số CMT/CCCD không tồn tại");
                alert.show();
            }
        }

    }

    public void checkCMT_nguoichet(ActionEvent e) {
        if (soCMTnguoiChet_TextField.getText().trim() == "" || soCMTnguoiChet_TextField.getText().trim().length() != 12) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Thông báo");
            alert.setHeaderText("Vui lòng nhập đúng định dạng CMT/CCCD");
            alert.show();
        } else {
            int res;
            res = checkCMT(soCMTnguoiChet_TextField.getText().trim());
            if (res != -1) {
                check_pane2.setVisible(true);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Thông báo");
                alert.setHeaderText("Số CMT/CCCD không tồn tại");
                alert.show();
            }
        }
    }

    public void resetInput() {
        soCMTnguoiKhai_TextField.setText("");
        soCMTnguoiChet_TextField.setText("");
        soGiayKhaiTu_TextField.setText("");
        ngayChet_DatePicker.setValue(null);
        ngayKhai_DatePicker.setValue(null);
        lyDo_TextArea.setText("");

        check_pane1.setVisible(false);
        check_pane2.setVisible(false);
    }

    @FXML
    public void xacNhanKhaiTu() throws SQLException {
        try {
            if (checkThongTinKhaiTu()) {
                boolean res = addNew(new KhaiTuModel(this.soGiayKhaiTu_TextField.getText().trim(),
                        checkCMT(this.soCMTnguoiKhai_TextField.getText().trim()), checkCMT(this.soCMTnguoiChet_TextField.getText().trim()),
                        java.sql.Date.valueOf(this.ngayKhai_DatePicker.getValue()), java.sql.Date.valueOf(this.ngayChet_DatePicker.getValue()),
                        this.lyDo_TextArea.getText().trim()));

                if (res) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Thông báo");
                    alert.setHeaderText("Khai tử thành công!");
                    alert.show();
                    resetInput();
                }

            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Thông báo");
                alert.setHeaderText("Vui lòng nhập đầy đủ thông tin!");
                alert.show();
            }
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

        check_pane1.setVisible(false);
        check_pane2.setVisible(false);
    }
}

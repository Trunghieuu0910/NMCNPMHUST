/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.NhanKhauManageController;

import Services.MysqlConnection;
import model.*;
import controller.LoginController;
import controller.StageController;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class DangKyTamVangController implements Initializable {

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
    private TextField soCMT_TextField;

    @FXML
    private TextField maGiayTamVang_TextField;

    @FXML
    private TextField noiTamTru_TextField;

    @FXML
    private DatePicker tuNgay_DatePicker;

    @FXML
    private DatePicker denNgay_DatePicker;

    @FXML
    private TextArea lyDo_TextArea;

    @FXML
    private Button check_Button;

    @FXML
    private Button dangKyTamVang_Button;

    @FXML
    private Pane checkPane;

    private DangKyTamVangController controller = null;

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

    @FXML
    public boolean checkCMT() {
        if (soCMT_TextField.getText().trim() == "" || soCMT_TextField.getText().trim().length() < 12 || soCMT_TextField.getText().trim().length() > 12) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Thông báo");
            alert.setHeaderText("Vui lòng nhập đúng định dạng CMT/CCCD");
            alert.show();
            return false;
        } else {
            int res;
            res = checkCMT(soCMT_TextField.getText().trim());
            if (res != -1) {
                checkPane.setVisible(true);
                return true;
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Thông báo");
                alert.setHeaderText("Số CMT/CCCD không tồn tại");
                alert.show();
                return false;
            }
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
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra! vui lòng kiểm tra lại.", "Warning!!", JOptionPane.WARNING_MESSAGE);
        }
        return -1;
    }

    public boolean addNew(TamVangModel tamVangModel) {
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "INSERT INTO tam_vang(idNhanKhau, maGiayTamVang, noiTamTru, tuNgay, denNgay, lyDo)" + " value (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            System.out.println(tamVangModel.getIdNhanKhau());
            preparedStatement.setInt(1, tamVangModel.getIdNhanKhau());
            System.out.println(tamVangModel.getMaGiayTamVang());

            preparedStatement.setString(2, tamVangModel.getMaGiayTamVang());
            preparedStatement.setString(3, tamVangModel.getNoiTamTru());
            java.sql.Date tuNgay = new java.sql.Date(tamVangModel.getTuNgay().getTime());
            preparedStatement.setDate(4, tuNgay);
            java.sql.Date denNgay = new java.sql.Date(tamVangModel.getDenNgay().getTime());
            preparedStatement.setDate(5, denNgay);
            preparedStatement.setString(6, tamVangModel.getLyDo());

            System.out.println(query);

            preparedStatement.execute();

            connection.close();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra! vui lòng kiểm tra lại.", "Warning!!", JOptionPane.WARNING_MESSAGE);
            return false;
        }

    }

    public boolean checkThongTinTamVang() {
        if (maGiayTamVang_TextField.getText().trim().isEmpty()
                || noiTamTru_TextField.getText().trim().isEmpty()
                || lyDo_TextArea.getText().trim().isEmpty()
                || soCMT_TextField.getText().trim().isEmpty()) {
            return false;
        }
        return true;
    }

    @FXML
    public void dangKyTamVang() throws SQLException {
        try {
            if (checkThongTinTamVang()) {
                TamVangModel tamVangModel = new TamVangModel();
                tamVangModel.setMaGiayTamVang(this.maGiayTamVang_TextField.getText().trim());
                //checkCMT(soCMT_TextField.getText().trim())admin   1
                tamVangModel.setID(39);
                tamVangModel.setNoiTamTru(this.noiTamTru_TextField.getText().trim());
                tamVangModel.setTuNgay(java.sql.Date.valueOf(this.tuNgay_DatePicker.getValue()));
                tamVangModel.setDenNgay(java.sql.Date.valueOf(this.denNgay_DatePicker.getValue()));
                tamVangModel.setLyDo(this.lyDo_TextArea.getText().trim());

                //java.sql.Date.valueOf(denNgay_DatePicker.getValue())
                boolean res = addNew(new TamVangModel(39, maGiayTamVang_TextField.getText().trim(), noiTamTru_TextField.getText().trim(), java.sql.Date.valueOf(this.tuNgay_DatePicker.getValue()), java.sql.Date.valueOf(this.denNgay_DatePicker.getValue()), lyDo_TextArea.getText().trim()));
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

        checkPane.setVisible(false);
    }

    public void resetInput() {
        soCMT_TextField.setText("");
        maGiayTamVang_TextField.setText("");
        noiTamTru_TextField.setText("");
        tuNgay_DatePicker.setValue(null);
        denNgay_DatePicker.setValue(null);
        lyDo_TextArea.setText("");
    }

}

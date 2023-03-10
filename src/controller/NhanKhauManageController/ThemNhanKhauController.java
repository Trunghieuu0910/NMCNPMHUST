/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.NhanKhauManageController;

import Services.HoKhauService;
import Services.MysqlConnection;
import Services.NhanKhauService;
import bean.*;
import model.*;
import controller.LoginController;
import controller.StageController;
import controller.NhanKhauController;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class ThemNhanKhauController implements Initializable {

    private StageController sc = new StageController();

    private NhanKhauController parentController;

    @FXML
    private Pane nhankhau_pane;
    @FXML
    private Pane quanlysh_pane;
    @FXML
    private Pane hokhau_pane;
    @FXML
    private Pane thongke_pane;

    @FXML
    private TextField hoVaTen_TextField;

    @FXML
    private DatePicker ngaySinh_DatePicker;

    @FXML
    private TextField nguyenQuan_TextField;

    @FXML
    private TextField danToc_TextField;

    @FXML
    private TextField soCMT_TextField;

    @FXML
    private TextField noiThuongTru_TextField;

    @FXML
    private TextField trinhDoHocVan_TextField;

    @FXML
    private TextField trinhDoNgoaiNgu_TextField;

    @FXML
    private TextField ngheNghiep_TextField;

    @FXML
    private TextField bietDanh_TextField;

    @FXML
    private ComboBox<String> gioTinh_ComboBox;
    private final String[] find_by = {"Nam", "N???", "Kh??c"};

    @FXML
    private TextField tonGiao_TextField;

    @FXML
    private TextField quocTich_TextField;

    @FXML
    private TextField hoChieuSo_TextField;

    @FXML
    private TextField diaChiHienTai_TextField;

    @FXML
    private TextField trinhDoChuyenMon_TextField;

    @FXML
    private TextField bietTiengDanToc_TextField;

    @FXML
    private TextField noiLamViec_TextField;

    @FXML
    private Button themNhanKhau_Button;

    private NhanKhauBean nhanKhauBean;

    @FXML
    private void switchToHoKhauScene(ActionEvent e) throws IOException {
        sc.switchToHoKhauScene(e);
    }

    @FXML
    private void switchToNhanKhauScene(ActionEvent e) throws IOException {
        sc.switchToNhanKhauScene(e);
    }

    @FXML
    public void switchToDangKyTamVangScene(ActionEvent e) throws IOException {
        System.out.println("123");
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

    @FXML
    void switchToThongKeScene(ActionEvent e) throws IOException {
        sc.switchToThongKeScene(e);
    }

    @FXML
    private void switchToTrangChuScene(ActionEvent e) throws IOException {
        sc.switchToTrangChuScene(e);
    }

    @FXML
    void switchToQLSinhHoatScene(ActionEvent e) throws IOException {
        sc.switchToQLSinhHoatScene(e);
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

    public boolean addNewPeople(NhanKhauBean nhanKhauBean) throws SQLException, ClassNotFoundException {
        NhanKhauModel nhanKhau = nhanKhauBean.getNhanKhauModel();
        ChungMinhThuModel chungMinhThu = nhanKhauBean.getChungMinhThuModel();
        Connection connection = MysqlConnection.getMysqlConnection();

        String query = "INSERT INTO nhan_khau (hoTen, bietDanh, namSinh, gioiTinh, noiSinh, nguyenQuan, danToc, tonGiao, quocTich, soHoChieu, noiThuongTru, diaChiHienNay, trinhDoHocVan, TrinhDoChuyenMon, bietTiengDanToc, trinhDoNgoaiNgu, ngheNghiep, noiLamViec, idNguoiTao, ngayTao)"
                + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, nhanKhau.getHoTen());
        preparedStatement.setString(2, nhanKhau.getBietDanh());
        System.out.println(123);

        java.sql.Date namSinh = new java.sql.Date(nhanKhau.getNamSinh().getTime());
        preparedStatement.setDate(3, namSinh);
        preparedStatement.setString(4, nhanKhau.getGioiTinh());
        preparedStatement.setString(5, nhanKhau.getNoiSinh());
        preparedStatement.setString(6, nhanKhau.getNguyenQuan());
        preparedStatement.setString(7, nhanKhau.getDanToc());
        preparedStatement.setString(8, nhanKhau.getTonGiao());
        preparedStatement.setString(9, nhanKhau.getQuocTich());
        preparedStatement.setString(10, nhanKhau.getSoHoChieu());
        preparedStatement.setString(11, nhanKhau.getNoiThuongTru());
        preparedStatement.setString(12, nhanKhau.getDiaChiHienNay());
        preparedStatement.setString(13, nhanKhau.getTrinhDoHocVan());
        preparedStatement.setString(14, nhanKhau.getTrinhDoChuyenMon());
        preparedStatement.setString(15, nhanKhau.getBietTiengDanToc());
        preparedStatement.setString(16, nhanKhau.getTrinhDoNgoaiNgu());
        preparedStatement.setString(17, nhanKhau.getNgheNghiep());
        preparedStatement.setString(18, nhanKhau.getNoiLamViec());
        preparedStatement.setInt(19, 1);
        java.sql.Date createDate = new java.sql.Date(java.util.Calendar.getInstance().getTime().getTime());
        preparedStatement.setDate(20, createDate);
                    System.out.println(query);

        preparedStatement.executeUpdate();
        ResultSet rs = preparedStatement.getGeneratedKeys();
        if (rs.next()) {
            int genID = rs.getInt(1);
            String sql = "INSERT INTO chung_minh_thu(idNhanKhau, soCMT)"
                    + " values (?, ?)";
            PreparedStatement prst = connection.prepareStatement(sql);
            prst.setInt(1, genID);
            prst.setString(2, chungMinhThu.getSoCMT());
            prst.execute();
//            nhanKhauBean.getListTieuSuModels().forEach(tieuSu -> {
//                try {
//                    String sql_tieu_su = "INSERT INTO tieu_su(idNhanKhau, tuNgay, denNgay, diaChi, ngheNghiep, noiLamViec)" 
//                        + " values (?, ?, ?, ?, ?, ?)";
//                    PreparedStatement preStatement = connection.prepareStatement(sql_tieu_su);
//                    preStatement.setInt(1, genID);
//                    Date tuNgay = new Date(tieuSu.getTuNgay().getTime());
//                    preStatement.setDate(2, tuNgay);
//                    preStatement.setDate(3, new Date(tieuSu.getDenNgay().getTime()));
//                    preStatement.setString(4, tieuSu.getDiaChi());
//                    preStatement.setString(5, tieuSu.getNgheNghiep());
//                    preStatement.setString(6, tieuSu.getNoiLamViec());
//                    preStatement.execute();
//                    preStatement.close();
//                } catch (Exception e) {
//                    System.out.println(e);
//                }
//            });
//            nhanKhauBean.getListGiaDinhModels().forEach(giaDinh -> {
//                try {
//                    String sql_tieu_su = "INSERT INTO gia_dinh(idNhanKhau, hoTen, namSinh, gioiTinh, quanHeVoiNhanKhau, ngheNghiep, diaChiHienTai)" 
//                        + " values (?, ?, ?, ?, ?, ?, ?)";
//                    PreparedStatement preStatement = connection.prepareStatement(sql_tieu_su);
//                    preStatement.setInt(1, genID);
//                    preStatement.setString(2, giaDinh.getHoTen());
//                    preStatement.setDate(3, new Date(giaDinh.getNamSinh().getTime()));
//                    preStatement.setString(4, giaDinh.getGioiTinh());
//                    preStatement.setString(5, giaDinh.getQuanHeVoiNhanKhau());
//                    preStatement.setString(6, giaDinh.getNgheNghiep());
//                    preStatement.setString(7, giaDinh.getDiaChiHienTai());
//                    preStatement.execute();
//                    preStatement.close();
//                } catch (Exception e) {
//                    System.out.println("controllers.NhanKhauManagerController.AddNewController.addNewPeople()");
//                }
//            });
//        }
            connection.close();
        }

        return true;
    }

    public boolean checkThemNhanKhau() {
        // check null
        if (hoVaTen_TextField.getText().trim().isEmpty()
                || nguyenQuan_TextField.getText().trim().isEmpty()
                || tonGiao_TextField.getText().trim().isEmpty()
                || danToc_TextField.getText().trim().isEmpty()
                || quocTich_TextField.getText().trim().isEmpty()
                || soCMT_TextField.getText().trim().isEmpty()
                || noiThuongTru_TextField.getText().trim().isEmpty()
                || diaChiHienTai_TextField.getText().trim().isEmpty()
                || trinhDoHocVan_TextField.getText().trim().isEmpty()
                || trinhDoChuyenMon_TextField.getText().trim().isEmpty()
                || trinhDoNgoaiNgu_TextField.getText().trim().isEmpty()
                || bietTiengDanToc_TextField.getText().trim().isEmpty()
                || ngheNghiep_TextField.getText().trim().isEmpty()
                || noiLamViec_TextField.getText().trim().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Th??ng b??o");
            alert.setHeaderText("Vui l??ng nh???p ?????y ????? th??ng tin!");
            alert.show();

            //JOptionPane.showMessageDialog(rootPane, "Vui l??ng nh???p h???t c??c tr?????ng b???t bu???c", "Warning", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        // check dinh dang so chung minh thu
        try {
            long d = Long.parseLong(soCMT_TextField.getText());
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Th??ng b??o");
            alert.setHeaderText("S??? CMT kh??ng th??? ch???a c??c k?? t???");
            alert.show();

            //JOptionPane.showMessageDialog(rootPane, "S??? CMT kh??ng th??? ch???a c??c k?? t???", "Warning", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        // kiem tra do dai cmt
        if (soCMT_TextField.getText().length() != 9 && soCMT_TextField.getText().length() != 12) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Th??ng b??o");
            alert.setHeaderText("Vui l??ng nh???p ????ng ?????nh d???ng CMT");
            alert.show();

            //JOptionPane.showMessageDialog(rootPane, "Vui l??ng nh???p ????ng ?????nh d???ng CMT", "Warning", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

    @FXML
    private void themNK(ActionEvent e) throws SQLException, ClassNotFoundException {
        if (checkThemNhanKhau() || true) {
         
            NhanKhauModel temp = new NhanKhauModel();
            ChungMinhThuModel cmt = new ChungMinhThuModel();
            temp.setBietDanh(bietDanh_TextField.getText());
            temp.setHoTen(hoVaTen_TextField.getText());
            temp.setNamSinh(java.sql.Date.valueOf(ngaySinh_DatePicker.getValue()));

            temp.setGioiTinh(gioTinh_ComboBox.getValue().toString());
            temp.setNguyenQuan(nguyenQuan_TextField.getText());
            temp.setTonGiao(tonGiao_TextField.getText());
            temp.setDanToc(danToc_TextField.getText());
            temp.setQuocTich(quocTich_TextField.getText());
            cmt.setSoCMT(soCMT_TextField.getText());
            temp.setSoHoChieu(hoChieuSo_TextField.getText());
            temp.setNoiThuongTru(noiThuongTru_TextField.getText());
            temp.setDiaChiHienNay(diaChiHienTai_TextField.getText());
            temp.setTrinhDoHocVan(trinhDoHocVan_TextField.getText());
            temp.setTrinhDoChuyenMon(trinhDoChuyenMon_TextField.getText());
            temp.setTrinhDoNgoaiNgu(trinhDoNgoaiNgu_TextField.getText());
            temp.setBietTiengDanToc(bietTiengDanToc_TextField.getText());
            temp.setNgheNghiep(ngheNghiep_TextField.getText());
            temp.setNoiLamViec(noiLamViec_TextField.getText());
            temp.setIdNguoiTao(1);

//            boolean res = this.addNewPeople(new NhanKhauBean(temp, cmt));
                boolean res = true;
            if (res) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Th??ng b??o");
                alert.setHeaderText("Th??m th??nh c??ng!");
                alert.show();
                
                restartInput();
            } else {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Th??ng b??o");
                alert.setHeaderText("C?? l???i x???y ra. Vui long ki???m tra l???i!");
                alert.show();

                //JOptionPane.showMessageDialog(rootPane, "C?? l???i x???y ra. Vui long ki???m tra l???i!!", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }
    }  

    @FXML
    public void handleExit() {
        sc.handleExit();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        gioTinh_ComboBox.getItems().addAll(find_by);

        phan_quyen();
    }

    public void restartInput() {
        hoVaTen_TextField.setText("");

        ngaySinh_DatePicker.setValue(null);

        nguyenQuan_TextField.setText("");

        danToc_TextField.setText("");

        soCMT_TextField.setText("");

        noiThuongTru_TextField.setText("");

        trinhDoHocVan_TextField.setText("");

        trinhDoNgoaiNgu_TextField.setText("");

        ngheNghiep_TextField.setText("");

        bietDanh_TextField.setText("");

        gioTinh_ComboBox.setValue("");

        tonGiao_TextField.setText("");

        quocTich_TextField.setText("");

        hoChieuSo_TextField.setText("");

        diaChiHienTai_TextField.setText("");

        trinhDoChuyenMon_TextField.setText("");

        bietTiengDanToc_TextField.setText("");

        noiLamViec_TextField.setText("");

    }

}

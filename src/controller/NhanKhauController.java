/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import model.NhanKhau;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Services.*;
import static Services.MysqlConnection.getMysqlConnection;
import bean.*;
import java.sql.PreparedStatement;
import java.util.Date;
import java.util.EventObject;
import model.*;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javax.swing.Action;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class NhanKhauController implements Initializable {
    private StageController sc = new StageController();
    private NhanKhauService nhanKhauService;
    private List<NhanKhauBean> listNhanKhauBeans;

    @FXML
    private Pane nhankhau_pane;
    @FXML
    private Pane quanlysh_pane;
    @FXML
    private Pane hokhau_pane;
    @FXML
    private Pane thongke_pane;

    @FXML
    private TableView<NhanKhauBean> nhanKhau_table;

    @FXML
    private TableColumn<NhanKhauBean, String> hoVaTenColumn;

    @FXML
    private TableColumn<NhanKhauBean, String> ngaySinhColumn;

    @FXML
    private TableColumn<NhanKhauBean, String> nguyenQuanColumn;

    @FXML
    private TableColumn<NhanKhauBean, String> diaChiHienTaiColumn;

    @FXML
    private TableColumn<NhanKhauBean, String> danTocColumn;

    @FXML
    private TableColumn<NhanKhauBean, String> ngheNghiepColumn;

    @FXML
    private TableColumn<NhanKhauBean, Integer> soCMTColumn;

    private ObservableList<NhanKhauBean> nhanKhauList;

    @FXML
    private TextField timKiem_TextFiel;

    @FXML
    private Button tim_Button;

    @FXML
    private ComboBox<String> choice_box;
    //private final String[] find_by = {"Tìm theo tên", "Tìm theo CCCD"};
    private final String[] find_by = {"Tìm theo tên", "Tìm theo ID"};

    @FXML
    private void switchToThemNhanKhauScene(ActionEvent e) throws IOException {
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

    @FXML
    public void switchToChiTietNhanKhauScene(ActionEvent e) throws IOException {
        sc.switchToChiTietNhanKhauScene(e);
    }

    @FXML
    public void switchToHoKhauScene(ActionEvent e) throws IOException {
        sc.switchToHoKhauScene(e);
    }

    @FXML
    public void switchToNhanKhauScene(ActionEvent e) throws IOException {
        sc.switchToNhanKhauScene(e);

    }

    @FXML
    public void switchToTrangChuScene(ActionEvent e) throws IOException {
        sc.switchToTrangChuScene(e);
    }

    @FXML
    public void switchToThongKeScene(ActionEvent e) throws IOException {
        sc.switchToThongKeScene(e);
    }

    @FXML
    public void switchToQLSinhHoatScene(ActionEvent e) throws IOException {
        sc.switchToQLSinhHoatScene(e);
    }

    @FXML
    public void handleDelete() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Comfirm?");
        alert.setHeaderText("A  ");
        alert.setContentText("Xóa nhân khẩu này?");

        ButtonType buttonYes = new ButtonType("Yes", ButtonBar.ButtonData.YES);
        ButtonType buttonNo = new ButtonType("No", ButtonBar.ButtonData.NO);
        alert.getButtonTypes().setAll(buttonYes, buttonNo);
        alert.initModality(Modality.NONE);
        alert.showAndWait();
    }

    @FXML
    public void handleExit() {
        sc.handleExit();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {     
        choice_box.getItems().addAll(find_by);

        phan_quyen();

        NhanKhauService nhanKhauService = new NhanKhauService();
        List<NhanKhauBean> list = nhanKhauService.getListNhanKhau();

        nhanKhauList = FXCollections.observableArrayList(list);
        hoVaTenColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<String>(cellData.getValue().getNhanKhauModel().getHoTen()));
        ngaySinhColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<String>(String.valueOf(cellData.getValue().getNhanKhauModel().getNamSinh())));
        nguyenQuanColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<String>(cellData.getValue().getNhanKhauModel().getNguyenQuan()));
        diaChiHienTaiColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<String>(cellData.getValue().getNhanKhauModel().getDiaChiHienNay()));
        danTocColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<String>(cellData.getValue().getNhanKhauModel().getDanToc()));
        ngheNghiepColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<String>(cellData.getValue().getNhanKhauModel().getNgheNghiep()));
        soCMTColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<Integer>(cellData.getValue().getNhanKhauModel().getID()));
    
        nhanKhau_table.setItems(nhanKhauList);

    }

    public TableView<NhanKhauBean> getNhanKhau_table() {
        return nhanKhau_table;
    }

    public void setNhanKhau_table(TableView<NhanKhauBean> nhanKhau_table) {
        this.nhanKhau_table = nhanKhau_table;
    }

    @FXML
    public void search(ActionEvent e) {
        NhanKhauService nhanKhauService = new NhanKhauService();
        String keys = timKiem_TextFiel.getText();
        keys = keys.trim();
        List<NhanKhauBean> list = nhanKhauService.search(keys);
        nhanKhauList = FXCollections.observableList(list);
        if (nhanKhauList.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Thông báo");
            alert.setHeaderText("Thông tin tìm kiếm không chính xác. Vui lòng kiểm tra lại!");
            alert.show();
        } else {

            hoVaTenColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<String>(cellData.getValue().getNhanKhauModel().getHoTen()));
            ngaySinhColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<String>(String.valueOf(cellData.getValue().getNhanKhauModel().getNamSinh())));
            nguyenQuanColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<String>(cellData.getValue().getNhanKhauModel().getNguyenQuan()));
            diaChiHienTaiColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<String>(cellData.getValue().getNhanKhauModel().getDiaChiHienNay()));
            danTocColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<String>(cellData.getValue().getNhanKhauModel().getDanToc()));
            ngheNghiepColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<String>(cellData.getValue().getNhanKhauModel().getNgheNghiep()));
            soCMTColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<Integer>(cellData.getValue().getNhanKhauModel().getID()));

            nhanKhau_table.setItems(nhanKhauList);
        }

    }

//    public void xoaNhanKhau(ActionEvent e) throws SQLException, ClassNotFoundException {
//        Connection connection = MysqlConnection.getMysqlConnection();
//        String query = "DELETE FROM nhan_khau LEFT JOIN chung_minh_thu ON nhan_khau.ID = chung_minh_thu.idNhanKhau WHERE nhan_khau.ID = ?";
//        PreparedStatement preparedStatement = connection.prepareStatement(query);
//        //preparedStatement.setString(1, soCMTColumn.getText());
//        String idString = soCMTColumn.getText();
//        int id;
//        try {
//            id = Integer.parseInt(idString);
//            
//        } catch (NumberFormatException ex) {
//            System.out.println("123456");         
//            return;
//        }
//        preparedStatement.setInt(1, id);
//        preparedStatement.executeUpdate();
//    }

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
}

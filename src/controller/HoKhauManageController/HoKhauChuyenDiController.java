/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.HoKhauManageController;

import Services.HoKhauService;
import bean.HoKhauBean;
import static controller.HoKhauManageController.ChonThanhVienController.map;
import static controller.HoKhauManageController.ChonThanhVienController.thanhVienMoi;
import controller.StageController;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author T14
 */
public class HoKhauChuyenDiController implements Initializable {

    private StageController sc = new StageController();

    @FXML
    private TextField searchText;
    @FXML
    private TextField maHoKhau;
    @FXML
    private TextField tenChuHo;
    @FXML
    private TextField diaChiHienTai;
    @FXML
    private TextField diaChiChuyenDen;
    @FXML
    private TextField lyDo;

    @FXML
    private TableView<HoKhauBean> hokhau_table;
    @FXML
    private TableColumn<HoKhauBean, String> sohokhau;
    @FXML
    private TableColumn<HoKhauBean, String> tenchuho;
    @FXML
    private TableColumn<HoKhauBean, String> diachi;

    private ObservableList<HoKhauBean> hoKhauList;

    @FXML
    private void switchToHoKhauScene(ActionEvent e) throws IOException {
        sc.switchToHoKhauScene(e);
    }

    @FXML
    private void switchToNhanKhauScene(ActionEvent e) throws IOException {
        sc.switchToNhanKhauScene(e);
    }

    @FXML
    public void switchToTachHoKhauScene(ActionEvent e) throws IOException {
        sc.switchToTachHoKhau(e);
    }

    @FXML
    public void switchToChuyenDi(ActionEvent e) throws IOException {
        sc.switchToChuyenDi(e);
    }

    @FXML
    void switchToTrangChuScene(ActionEvent e) throws IOException {
        sc.switchToTrangChuScene(e);
    }

    @FXML
    void switchToThemHoKhauScene(ActionEvent e) throws IOException {
        sc.switchToThemHoKhauScene(e);
    }

    @FXML
    void switchToThongKeScene(ActionEvent e) throws IOException {
        sc.switchToThongKeScene(e);
    }

    @FXML
    void handleExit(ActionEvent e) throws IOException {
        sc.handleExit();
    }

    @FXML
    public void switchToQLSinhHoatScene(ActionEvent e) throws IOException {
        sc.switchToQLSinhHoatScene(e);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        maHoKhau.setEditable(false);
//        maHoKhau.setDisable(false);
        tenChuHo.setEditable(false);
//        tenChuHo.setDisable(false);
        diaChiHienTai.setEditable(false);
//        diaChiHienTai.setDisable(false);
        listHoKhau();
    }

    @FXML
    void txtFieldPress(KeyEvent e) {
        if (e.getCode().equals(KeyCode.BACK_SPACE)) {
            if (searchText.getText().length() <= 1) {
                listHoKhau();
            }
        } else if (e.getCode().equals(KeyCode.ENTER)) {
            search();

        }
    }

    @FXML
    public void searchbutton(ActionEvent e) {
        search();
    }

    @FXML
    public void getDataFromCell(MouseEvent e) {
        int index = hokhau_table.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }

        maHoKhau.setText(sohokhau.getCellData(index).toString());
        tenChuHo.setText(tenchuho.getCellData(index).toString());
        diaChiHienTai.setText(diachi.getCellData(index).toString());
    }

    public void search() {
        HoKhauService hoKhauService = new HoKhauService();
        String keys = searchText.getText();
        keys = keys.trim();
        List<HoKhauBean> list = hoKhauService.search(keys);
        hoKhauList = FXCollections.observableList(list);
        if (hoKhauList.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Thông báo");
            alert.setHeaderText("Thông tin tìm kiếm không chính xác. Vui lòng kiểm tra lại!");
            alert.show();
        } else {
            sohokhau.setCellValueFactory(cellData -> new SimpleObjectProperty<String>(cellData.getValue().getHoKhauModel().getMaHoKhau()));
            tenchuho.setCellValueFactory(cellData -> new SimpleObjectProperty<String>(cellData.getValue().getChuHo().getHoTen()));
            diachi.setCellValueFactory(cellData -> new SimpleObjectProperty<String>(cellData.getValue().getHoKhauModel().getDiaChi()));
            hokhau_table.setItems(hoKhauList);
        }
    }

    public void listHoKhau() {
        HoKhauService hoKhauService = new HoKhauService();
        List<HoKhauBean> list = hoKhauService.getListHoKhau();
        hoKhauList = FXCollections.observableList(list);

        sohokhau.setCellValueFactory(cellData -> new SimpleObjectProperty<String>(cellData.getValue().getHoKhauModel().getMaHoKhau()));
        tenchuho.setCellValueFactory(cellData -> new SimpleObjectProperty<String>(cellData.getValue().getChuHo().getHoTen()));
        diachi.setCellValueFactory(cellData -> new SimpleObjectProperty<String>(cellData.getValue().getHoKhauModel().getDiaChi()));

        hokhau_table.setItems(hoKhauList);
    }

    @FXML
    public void confirm(ActionEvent e) throws IOException {
        if (maHoKhau.getText().isEmpty() || tenChuHo.getText().isEmpty()
                || diaChiHienTai.getText().isEmpty() || diaChiChuyenDen.getText().isEmpty()
                || lyDo.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Thông báo");
            alert.setHeaderText("Vui lòng nhập đầy đủ thông tin!");
            alert.show();
        } else {
            String id = maHoKhau.getText();
            String address = diaChiChuyenDen.getText();
            String reason = lyDo.getText();
            System.out.println(id);
            HoKhauService hoKhauService = new HoKhauService();
            if (hoKhauService.chuyenDi(id, address, reason) == true) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Thông báo");
                alert.setHeaderText("Bạn đã chuyển thành công!");
                alert.setContentText("Nhấn OK để trở về màn hình hộ khẩu");
                alert.showAndWait();
                sc.switchToHoKhauScene(e);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Thông báo");
                alert.setHeaderText("Có lỗi xảy ra, vui lòng kiểm tra lại thông tin!");
                alert.show();
            }
        }
    }

    @FXML
    public void exitButton(ActionEvent e) throws IOException {
        int check = alertcancel();
        if (check == 1) {
            sc.switchToHoKhauScene(e);
        }

    }

    public int alertcancel() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Xác nhận");
        alert.setHeaderText("Cảnh báo");
        alert.setContentText("Bạn có chắc chắn muốn thoát không?");

        ButtonType buttonTypeOne = new ButtonType("OK");
        ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeCancel);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeOne) {
            return 1;
        } else {
            return 0;
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller.HoKhauManageController;

import bean.HoKhauBean;
import bean.MemOfFamily;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.HoKhauModel;
import model.NhanKhauModel;
import model.ThanhVienCuaHoModel;

/**
 * FXML Controller class
 *
 * @author T14
 */
public class ThongTinHoKhauController implements Initializable {

    private static HoKhauBean hoKhauBean;
    @FXML
    private TextField maHoKhau;
    @FXML
    private TextField diaChi;
    @FXML
    private TextField tenChuHo;
    @FXML
    private TextField ngayLap;

    @FXML
    private TableView<MemOfFamily> thanhVienTable;
    @FXML
    private TableColumn<MemOfFamily, String> hoTen;
    @FXML
    private TableColumn<MemOfFamily, String> gioiTinh;
    @FXML
    private TableColumn<MemOfFamily, String> ngaySinh;
    @FXML
    private TableColumn<MemOfFamily, String> quanHeChuHo;

    private ObservableList<MemOfFamily> nhanKhauList;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tenChuHo.setEditable(false);
        ngayLap.setEditable(false);
        diaChi.setEditable(false);
        maHoKhau.setEditable(false);

        setData(hoKhauBean);
    }

    public HoKhauBean getHoKhauBean() {
        return hoKhauBean;
    }

    public void setHoKhauBean(HoKhauBean hoKhauBean) {
        this.hoKhauBean = hoKhauBean;
    }

    public void setData(HoKhauBean hoKhauBean) {
        maHoKhau.setText(hoKhauBean.getHoKhauModel().getMaHoKhau());
        diaChi.setText(hoKhauBean.getHoKhauModel().getDiaChi());
        tenChuHo.setText(hoKhauBean.getChuHo().getHoTen());
        ngayLap.setText(hoKhauBean.getHoKhauModel().getNgayLap().toString());

        List<MemOfFamily> list = new ArrayList();
        List<NhanKhauModel> listNhanKhau = hoKhauBean.getListNhanKhauModels();
        List<ThanhVienCuaHoModel> listThanhVien = hoKhauBean.getListThanhVienCuaHo();

        for (int i = 0; i < listNhanKhau.size(); i++) {
            MemOfFamily a = new MemOfFamily();
            a.getNhanKhau().setNhanKhauModel(listNhanKhau.get(i));
            a.setThanhVienCuaHoModel(listThanhVien.get(i));

            list.add(a);
        }

        // System.out.println(list.size());
        nhanKhauList = FXCollections.observableList(list);
//        System.out.println(nhanKhauList.size());
//        
//        for (MemOfFamily i : nhanKhauList){
//            System.out.println(i.getNhanKhau().getNhanKhauModel().getHoTen());
//            System.out.println(i.getNhanKhau().getNhanKhauModel().getGioiTinh());
//            System.out.println(i.getNhanKhau().getNhanKhauModel().getNamSinh().toString());
//            System.out.println(i.getThanhVienCuaHoModel().getQuanHeVoiChuHo());
//            
//        }

        hoTen.setCellValueFactory(cellData -> new SimpleObjectProperty<String>(cellData.getValue().getNhanKhau().getNhanKhauModel().getHoTen()));
        gioiTinh.setCellValueFactory(cellData -> new SimpleObjectProperty<String>(cellData.getValue().getNhanKhau().getNhanKhauModel().getGioiTinh()));
        ngaySinh.setCellValueFactory(cellData -> new SimpleObjectProperty<String>(cellData.getValue().getNhanKhau().getNhanKhauModel().getNamSinh().toString()));
        quanHeChuHo.setCellValueFactory(cellData -> new SimpleObjectProperty<String>(cellData.getValue().getThanhVienCuaHoModel().getQuanHeVoiChuHo()));
//        
        thanhVienTable.setItems(nhanKhauList);

    }
}

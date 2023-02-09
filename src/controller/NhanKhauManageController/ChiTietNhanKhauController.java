/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller.NhanKhauManageController;

import Services.MysqlConnection;
import Services.NhanKhauService;
import bean.NhanKhauBean;
import controller.HoKhauManageController.*;
import controller.StageController;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class ChiTietNhanKhauController implements Initializable {

    StageController sc = new StageController();
    
    @FXML
    private TextField hoVaTen_TextField;
    
    @FXML
    private TextField ngaySinh_TextField;
    
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
    private  TextField gioTinh_TextField;
    
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
    
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
        @FXML
    public void switchToNhanKhauScene(ActionEvent e) throws IOException {
        sc.switchToNhanKhauScene(e);
    }
    
    @FXML
    public void chiTiet(ActionEvent e) throws SQLException, ClassNotFoundException{
            Connection conn = MysqlConnection.getMysqlConnection();
            PreparedStatement pst = null;
            
            {
        
            String str = "SELECT * FROM nhan_khau";
                 
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(str);
        while (rs.next()) {
            //b = rs.getString(VocabelEnglisch);
            
           // hoVaTen_TextField = rs.getString(ho)
            
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery("SELECT * FROM <table_name>");

            while (rs.next()) {
            String data = rs.getString("<column_name>");
            //textfield.setText(data);
            
            
            //String sql = "SELECT * FROM nhan_khau WHERE = '"++"'";
            //ResultSet resultSet = statement.executeQuery(query);
//            hoVaTen_TextField.setText(setCellValueFactory(cellData -> new SimpleObjectProperty<String>(cellData.getValue().getNhanKhauModel().getHoTen())));
//            hoVaTen_TextField.setCellValueFactory(cellData -> new SimpleObjectProperty<String>(cellData.getValue().getNhanKhauModel().getHoTen()));
//            ngaySinhColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<String>(String.valueOf(cellData.getValue().getNhanKhauModel().getNamSinh())));
//            nguyenQuanColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<String>(cellData.getValue().getNhanKhauModel().getNguyenQuan()));
//            diaChiHienTaiColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<String>(cellData.getValue().getNhanKhauModel().getDiaChiHienNay()));
//            danTocColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<String>(cellData.getValue().getNhanKhauModel().getDanToc()));
//            ngheNghiepColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<String>(cellData.getValue().getNhanKhauModel().getNgheNghiep()));
//            soCMTColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<Integer>(cellData.getValue().getNhanKhauModel().getID()));
//            
//            nhanKhau_table.setItems(nhanKhauList);
        }
        
    }
            }
    }
}
    
    
    
    


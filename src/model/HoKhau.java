/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import controller.LoginController;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.CheckBox;

/**
 *
 * @author Admin
 */
public class HoKhau {
    private int id;
    private String chu_ho;
    private String so_nha;
    private String ap;
    private String phuong;
    private String quan;
    
    private CheckBox check;

    public HoKhau(int id, String chu_ho, String so_nha, String ap, String phuong, String quan, CheckBox check) {
        this.id = id;
        this.chu_ho = chu_ho;
        this.so_nha = so_nha;
        this.ap = ap;
        this.phuong = phuong;
        this.quan = quan;
        this.check = check;
    }

    public HoKhau(int id, String chu_ho, String so_nha, String ap, String phuong, String quan) {
        this.id = id;
        this.chu_ho = chu_ho;
        this.so_nha = so_nha;
        this.ap = ap;
        this.phuong = phuong;
        this.quan = quan;
    }
    
    public HoKhau() {
    }
    public int getId() {
        return id;
    }

    public String getChu_ho() {
        return chu_ho;
    }

    public String getSo_nha() {
        return so_nha;
    }

    public String getAp() {
        return ap;
    }

    public String getPhuong() {
        return phuong;
    }

    public String getQuan() {
        return quan;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setChu_ho(String chu_ho) {
        this.chu_ho = chu_ho;
    }

    public void setSo_nha(String so_nha) {
        this.so_nha = so_nha;
    }

    public void setAp(String ap) {
        this.ap = ap;
    }

    public void setPhuong(String phuong) {
        this.phuong = phuong;
    }

    public void setQuan(String quan) {
        this.quan = quan;
    } 

    public CheckBox getCheck() {
        return check;
    }

    public void setCheck(CheckBox check) {
        this.check = check;
    }
    
    
    
    public ObservableList getIDAndSoHoKhau() {
        String url = "jdbc:mysql://localhost:3306/nmcnpm";
        String user = "root";
        String password = "";
        ObservableList res = FXCollections.observableArrayList();
        String sql = "select * from ho_khau ";
        try ( Connection conn = DriverManager.getConnection(url, user, password)) {
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                res.add(new HoKhau(result.getInt("id"), result.getString("chu_ho"), result.getString("so_nha"), result.getString("ap"), result.getString("phuong"), result.getString("quan"), new CheckBox()));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
}

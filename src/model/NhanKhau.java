/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class NhanKhau {
    private String ho_ten;
    private String ngay_sinh;
    private String nguyen_quan;    
    private String dan_toc;
    private int so_CMT;
    private String noi_Thuong_Tru;
    private String trinh_Do_Hoc_Van;
    private String trinh_Do_Ngoai_Ngu;
    private String nghe_Nghiep;
    private String biet_Danh;
    private String gioi_Tinh;
    private String ton_Giao;
    private String quoc_Tich;
    private String ho_Chieu_So;
    private String dia_Chi_Hien_Tai;
    private String trinh_Do_Chuyen_Mon;
    private String biet_Tieng_Dan_Toc;
    private String noi_Lam_Viec;

    public NhanKhau() {
//        this.ho_ten = ho_ten;
//        this.ngay_sinh = ngay_sinh;
//        this.nguyen_quan = nguyen_quan;
//        this.dan_toc = dan_toc;
//        this.so_CMT = so_CMT;
//        this.noi_Thuong_Tru = noi_Thuong_Tru;
//        this.trinh_Do_Hoc_Van = trinh_Do_Hoc_Van;
//        this.trinh_Do_Ngoai_Ngu = trinh_Do_Ngoai_Ngu;
//        this.nghe_Nghiep = nghe_Nghiep;
//        this.biet_Danh = biet_Danh;
//        this.gioi_Tinh = gioi_Tinh;
//        this.ton_Giao = ton_Giao;
//        this.quoc_Tich = quoc_Tich;
//        this.ho_Chieu_So = ho_Chieu_So;
//        this.dia_Chi_Hien_Tai = dia_Chi_Hien_Tai;
//        this.trinh_Do_Chuyen_Mon = trinh_Do_Chuyen_Mon;
//        this.biet_Tieng_Dan_Toc = biet_Tieng_Dan_Toc;
//        this.noi_Lam_Viec = noi_Lam_Viec;
    }
    
//    public NhanKhau(String ho_ten, String ngay_sinh, String nguyen_quan, String dan_toc, int so_CMT, String nghe_Nghiep, String dia_Chi_Hien_Tai) {
//        this.ho_ten = ho_ten;
//        this.ngay_sinh = ngay_sinh;
//        this.nguyen_quan = nguyen_quan;
//        this.dan_toc = dan_toc;
//        this.so_CMT = so_CMT;
//        this.nghe_Nghiep = nghe_Nghiep;
//        this.dia_Chi_Hien_Tai = dia_Chi_Hien_Tai;
//    }

    
    
    public NhanKhau(String ho_ten, String ngay_sinh, String nguyen_quan, String dan_toc, int so_CMT, String noi_Thuong_Tru, String trinh_Do_Hoc_Van, String trinh_Do_Ngoai_Ngu, String nghe_Nghiep, String biet_Danh, String gioi_Tinh, String ton_Giao, String quoc_Tich, String ho_Chieu_So, String dia_Chi_Hien_Tai, String trinh_Do_Chuyen_Mon, String biet_Tieng_Dan_Toc, String noi_Lam_Viec) {
        this.ho_ten = ho_ten;
        this.ngay_sinh = ngay_sinh;
        this.nguyen_quan = nguyen_quan;
        this.dan_toc = dan_toc;
        this.so_CMT = so_CMT;
        this.noi_Thuong_Tru = noi_Thuong_Tru;
        this.trinh_Do_Hoc_Van = trinh_Do_Hoc_Van;
        this.trinh_Do_Ngoai_Ngu = trinh_Do_Ngoai_Ngu;
        this.nghe_Nghiep = nghe_Nghiep;
        this.biet_Danh = biet_Danh;
        this.gioi_Tinh = gioi_Tinh;
        this.ton_Giao = ton_Giao;
        this.quoc_Tich = quoc_Tich;
        this.ho_Chieu_So = ho_Chieu_So;
        this.dia_Chi_Hien_Tai = dia_Chi_Hien_Tai;
        this.trinh_Do_Chuyen_Mon = trinh_Do_Chuyen_Mon;
        this.biet_Tieng_Dan_Toc = biet_Tieng_Dan_Toc;
        this.noi_Lam_Viec = noi_Lam_Viec;
    }

    public String getHo_ten() {
        return ho_ten;
    }

    public void setHo_ten(String ho_ten) {
        this.ho_ten = ho_ten;
    }

    public String getNgay_sinh() {
        return ngay_sinh;
    }

    public void setNgay_sinh(String ngay_sinh) {
        this.ngay_sinh = ngay_sinh;
    }

    public String getNguyen_quan() {
        return nguyen_quan;
    }

    public void setNguyen_quan(String nguyen_quan) {
        this.nguyen_quan = nguyen_quan;
    }

    public String getDan_toc() {
        return dan_toc;
    }

    public void setDan_toc(String dan_toc) {
        this.dan_toc = dan_toc;
    }

    public int getSo_CMT() {
        return so_CMT;
    }

    public void setSo_CMT(int so_CMT) {
        this.so_CMT = so_CMT;
    }

    public String getNoi_Thuong_Tru() {
        return noi_Thuong_Tru;
    }

    public void setNoi_Thuong_Tru(String noi_Thuong_Tru) {
        this.noi_Thuong_Tru = noi_Thuong_Tru;
    }

    public String getTrinh_Do_Hoc_Van() {
        return trinh_Do_Hoc_Van;
    }

    public void setTrinh_Do_Hoc_Van(String trinh_Do_Hoc_Van) {
        this.trinh_Do_Hoc_Van = trinh_Do_Hoc_Van;
    }

    public String getTrinh_Do_Ngoai_Ngu() {
        return trinh_Do_Ngoai_Ngu;
    }

    public void setTrinh_Do_Ngoai_Ngu(String trinh_Do_Ngoai_Ngu) {
        this.trinh_Do_Ngoai_Ngu = trinh_Do_Ngoai_Ngu;
    }

    public String getNghe_Nghiep() {
        return nghe_Nghiep;
    }

    public void setNghe_Nghiep(String nghe_Nghiep) {
        this.nghe_Nghiep = nghe_Nghiep;
    }

    public String getBiet_Danh() {
        return biet_Danh;
    }

    public void setBiet_Danh(String biet_Danh) {
        this.biet_Danh = biet_Danh;
    }

    public String getGioi_Tinh() {
        return gioi_Tinh;
    }

    public void setGioi_Tinh(String gioi_Tinh) {
        this.gioi_Tinh = gioi_Tinh;
    }

    public String getTon_Giao() {
        return ton_Giao;
    }

    public void setTon_Giao(String ton_Giao) {
        this.ton_Giao = ton_Giao;
    }

    public String getQuoc_Tich() {
        return quoc_Tich;
    }

    public void setQuoc_Tich(String quoc_Tich) {
        this.quoc_Tich = quoc_Tich;
    }

    public String getHo_Chieu_So() {
        return ho_Chieu_So;
    }

    public void setHo_Chieu_So(String ho_Chieu_So) {
        this.ho_Chieu_So = ho_Chieu_So;
    }

    public String getDia_Chi_Hien_Tai() {
        return dia_Chi_Hien_Tai;
    }

    public void setDia_Chi_Hien_Tai(String dia_Chi_Hien_Tai) {
        this.dia_Chi_Hien_Tai = dia_Chi_Hien_Tai;
    }

    public String getTrinh_Do_Chuyen_Mon() {
        return trinh_Do_Chuyen_Mon;
    }

    public void setTrinh_Do_Chuyen_Mon(String trinh_Do_Chuyen_Mon) {
        this.trinh_Do_Chuyen_Mon = trinh_Do_Chuyen_Mon;
    }

    public String getBiet_Tieng_Dan_Toc() {
        return biet_Tieng_Dan_Toc;
    }

    public void setBiet_Tieng_Dan_Toc(String biet_Tieng_Dan_Toc) {
        this.biet_Tieng_Dan_Toc = biet_Tieng_Dan_Toc;
    }

    public String getNoi_Lam_Viec() {
        return noi_Lam_Viec;
    }

    public void setNoi_Lam_Viec(String noi_Lam_Viec) {
        this.noi_Lam_Viec = noi_Lam_Viec;
    }

    public Object getNhanKhauModel() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    

    
    
    
    
    
}

package vn.edu.eaut.lab10.model;

import jakarta.persistence.*;

@Entity
@Table(name = "san_pham")
public class SanPham {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ma_san_pham", nullable = false, unique = true, length = 20)
    private String maSanPham;

    @Column(name = "ten_san_pham", nullable = false, length = 150)
    private String tenSanPham;

    @Column(name = "gia")
    private Double gia;

    @Column(name = "so_luong_ton")
    private Integer soLuongTon;

    public SanPham() {}

    public SanPham(String maSanPham, String tenSanPham, Double gia, Integer soLuongTon) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.gia = gia;
        this.soLuongTon = soLuongTon;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getMaSanPham() { return maSanPham; }
    public void setMaSanPham(String maSanPham) { this.maSanPham = maSanPham; }

    public String getTenSanPham() { return tenSanPham; }
    public void setTenSanPham(String tenSanPham) { this.tenSanPham = tenSanPham; }

    public Double getGia() { return gia; }
    public void setGia(Double gia) { this.gia = gia; }

    public Integer getSoLuongTon() { return soLuongTon; }
    public void setSoLuongTon(Integer soLuongTon) { this.soLuongTon = soLuongTon; }
}
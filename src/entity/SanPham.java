package entity;

public class SanPham {

    private String id;

    private String ten;

    private String ma;

    public SanPham(String id, String ma, String ten) {
        this.id = id;
        this.ten = ten;
        this.ma = ma;
    }

    public SanPham() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

}

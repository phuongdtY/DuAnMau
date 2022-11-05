package entity;

public class DongSP {

    private String id;

    private String ten;

    private String ma;

    public DongSP(String id, String ten, String ma) {
        this.id = id;
        this.ten = ten;
        this.ma = ma;
    }

    public DongSP() {
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

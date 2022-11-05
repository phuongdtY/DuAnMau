package entity;

public class Mau {

    private String id;
    
    private String ten;
    
    private String ma;

    public Mau(String id, String ten, String ma) {
        this.id = id;
        this.ten = ten;
        this.ma = ma;
    }

    public Mau() {
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

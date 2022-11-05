package entity;

public class SanPhamChiTiet {

    private String idSp;

    private String idMauSac;

    private String idDongSP;

    private String idNhaSX;

    private String id;

    private int namBH;

    private int soLuong;

    private float giaNhap;

    private float giaBan;

    private String mota;

    public SanPhamChiTiet(String idSp, String idMauSac, String idDongSP, String idNhaSX, String id, int namBH, int soLuong, float giaNhap, float giaBan, String mota) {
        this.idSp = idSp;
        this.idMauSac = idMauSac;
        this.idDongSP = idDongSP;
        this.idNhaSX = idNhaSX;
        this.id = id;
        this.namBH = namBH;
        this.soLuong = soLuong;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.mota = mota;
    }

    public SanPhamChiTiet() {
    }

    public String getIdSp() {
        return idSp;
    }

    public void setIdSp(String idSp) {
        this.idSp = idSp;
    }

    public String getIdMauSac() {
        return idMauSac;
    }

    public void setIdMauSac(String idMauSac) {
        this.idMauSac = idMauSac;
    }

    public String getIdDongSP() {
        return idDongSP;
    }

    public void setIdDongSP(String idDongSP) {
        this.idDongSP = idDongSP;
    }

    public String getIdNhaSX() {
        return idNhaSX;
    }

    public void setIdNhaSX(String idNhaSX) {
        this.idNhaSX = idNhaSX;
    }

    public int getNamBH() {
        return namBH;
    }

    public void setNamBH(int namBH) {
        this.namBH = namBH;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(float giaNhap) {
        this.giaNhap = giaNhap;
    }

    public float getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(float giaBan) {
        this.giaBan = giaBan;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}

package dao;

import entity.SanPhamChiTiet;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import repository.jdbcUntil;

public class SanPhamChiTietDao extends daoDuAnMau<SanPhamChiTiet, String> {

    String sqlSelectAll = "select * from ChiTietSP";
    String sqlDelete = "delete ChiTietSP where id=?";
    String sqlupdate = "update ChiTietSP set idSP=?, idMauSac=?,idNsx=?,idDongSP=?,namBH=?,mota=?,soluongton=?,gianhap=?,giaBan=? where id=?";
    String sqlInsert = "insert into ChiTietSP (idSp,idNsx,idmauSac,idDongsp,NamBH,mota,soluongton,gianhap,giaban) values(?,?,?,?,?,?,?,?,?) ";
    String sqlSelectID = "select * from ChiTietSP where id=?";

    public SanPhamChiTietDao() {
    }

    @Override
    public void insert(SanPhamChiTiet entity) {
        try {
            jdbcUntil.update(sqlInsert, entity.getIdSp(), entity.getIdNhaSX(), entity.getIdMauSac(), entity.getIdDongSP(), entity.getNamBH(), entity.getMota(), entity.getSoLuong(), entity.getGiaNhap(), entity.getGiaBan());
        } catch (SQLException ex) {
            System.out.println("Loi");
        }
    }

    @Override
    public void update(SanPhamChiTiet entity, String id) {
        try {
            jdbcUntil.update(sqlupdate, entity.getIdSp(), entity.getIdMauSac(),entity.getIdNhaSX(), entity.getIdDongSP(), entity.getNamBH(), entity.getMota(), entity.getSoLuong(), entity.getGiaNhap(), entity.getGiaBan(), id);
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamChiTietDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String id) {
        try {
            jdbcUntil.update(sqlDelete, id);
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamChiTietDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public SanPhamChiTiet selectById(String id) {
        List<SanPhamChiTiet> listById = this.selectBySql(sqlSelectID, id);
        if (listById.isEmpty()) {
            return null;
        }
        return listById.get(0);
    }

    @Override
    protected List<SanPhamChiTiet> selectBySql(String sql, Object... args) {
        List<SanPhamChiTiet> listSanPhamChiTiet = new ArrayList<SanPhamChiTiet>();
        try {
            ResultSet rs = jdbcUntil.query(sql, args);
            while (rs.next()) {
                SanPhamChiTiet chiTiet = new SanPhamChiTiet();

                chiTiet.setId(rs.getString("id"));
                chiTiet.setIdDongSP(rs.getString("idDongSP"));
                chiTiet.setIdMauSac(rs.getString("idMauSac"));
                chiTiet.setIdNhaSX(rs.getString("idNsx"));
                chiTiet.setIdSp(rs.getString("idSP"));
                chiTiet.setSoLuong(rs.getInt("soLuongTon"));
                chiTiet.setNamBH(rs.getInt("NamBH"));
                chiTiet.setMota(rs.getString("mota"));
                chiTiet.setGiaBan(rs.getFloat("giaban"));
                chiTiet.setGiaNhap(rs.getFloat("gianhap"));
                // add vao list
                listSanPhamChiTiet.add(chiTiet);
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamChiTietDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listSanPhamChiTiet;
    }

    @Override
    public List<SanPhamChiTiet> selectAll() {
        return this.selectBySql(sqlSelectAll);
    }

}

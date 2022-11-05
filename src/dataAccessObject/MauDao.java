package dao;

import entity.Mau;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import repository.jdbcUntil;

public class MauDao extends daoDuAnMau<Mau, String> {

    String insert = "insert into MauSac(ma,ten) values (?,?)";

    @Override
    public void insert(Mau entity) {
        try {
            jdbcUntil.update(insert, entity.getMa(), entity.getTen());
        } catch (SQLException ex) {
            Logger.getLogger(MauDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Mau entity, String key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(String key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Mau> selectAll() {
        return this.selectBySql("select * from mauSac");
    }

    @Override
    public Mau selectById(String id) {
        List<Mau> listMau = this.selectBySql("select * from mausac where id=?", id);
        if (listMau.isEmpty()) {
            return null;
        }
        return listMau.get(0);
    }

    @Override
    public List<Mau> selectBySql(String sql, Object... args) {
        List<Mau> listMau = new ArrayList<>();
        try {
            ResultSet rs = jdbcUntil.query(sql, args);
            while (rs.next()) {
                Mau mau = new Mau(rs.getString("id"), rs.getString("ten"), rs.getString("ma"));
                listMau.add(mau);
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(DongSPDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listMau;
    }

}

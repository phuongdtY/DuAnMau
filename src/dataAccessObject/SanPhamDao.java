/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.SanPham;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import repository.jdbcUntil;

/**
 *
 * @author FPTSHOP
 */
public class SanPhamDao extends daoDuAnMau<SanPham, String> {

    String selectById = "select * from sanPham where id = ?";

    public SanPhamDao() {
    }

    @Override
    public void insert(SanPham entity) {
        try {
            jdbcUntil.update("insert into sanpham(ma,ten) values (?,?)", entity.getMa(),entity.getTen());
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(SanPham entity, String key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(String key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<SanPham> selectAll() {
        return this.selectBySql("select * from SanPham");
    }

    @Override
    public SanPham selectById(String id) {
        List<SanPham> listSp = this.selectBySql(selectById, id);
        if (listSp.isEmpty()) {
            return null;
        }
        return listSp.get(0);
    }

    @Override
    public List<SanPham> selectBySql(String sql, Object... args) {
        List<SanPham> listSp = new ArrayList<>();
        try {
            ResultSet rs = jdbcUntil.query(sql, args);
            while (rs.next()) {
                SanPham pham = new SanPham(rs.getString("id"), rs.getString("ma"), rs.getString("ten"));
                listSp.add(pham);
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listSp;
    }

}

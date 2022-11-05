/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.DongSP;
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
public class DongSPDao extends daoDuAnMau<DongSP, String> {

    String insert = "insert into Dongsp(ma,ten) values (?,?)";

    public DongSPDao() {
    }

    @Override
    public void insert(DongSP entity) {
        try {
            jdbcUntil.update(insert, entity.getMa(), entity.getTen());
        } catch (SQLException ex) {
            Logger.getLogger(MauDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(DongSP entity, String key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(String key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<DongSP> selectAll() {
        return this.selectBySql("select * from dongSp");
    }

    @Override
    public DongSP selectById(String id) {
        List<DongSP> listDong = this.selectBySql("select* from MauSac where id=?", id);
        if (listDong.isEmpty()) {
            return null;
        }
        return listDong.get(0);
    }

    @Override
    public List<DongSP> selectBySql(String sql, Object... args) {
        List<DongSP> listDong = new ArrayList<>();
        try {
            ResultSet rs = jdbcUntil.query(sql, args);
            while (rs.next()) {
                DongSP dongSP = new DongSP(rs.getString("id"), rs.getString("ten"), rs.getString("ma"));
                listDong.add(dongSP);
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(DongSPDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listDong;
    }
}

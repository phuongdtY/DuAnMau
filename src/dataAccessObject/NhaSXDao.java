/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.NhaSX;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import repository.jdbcUntil;

/**
 *
 * @author FPTSHOP
 */
public class NhaSXDao extends daoDuAnMau<NhaSX, String> {

    String selectById = "select * from NSX where id = ?";
    String insert = "insert into Nsx(ma,ten) values (?,?)";

    public NhaSXDao() {
    }

    @Override
    public List<NhaSX> selectBySql(String sql, Object... args) {
        List<NhaSX> listNsx = new ArrayList<>();
        try {
            ResultSet rs = jdbcUntil.query(sql, args);
            while (rs.next()) {
                NhaSX nsx = new NhaSX(rs.getString("id"), rs.getString("ten"), rs.getString("ma"));
                listNsx.add(nsx);
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(NhaSXDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listNsx;
    }

    @Override
    public void insert(NhaSX entity) {
        try {
            jdbcUntil.update(insert, entity.getMa(), entity.getTen());
        } catch (SQLException ex) {
            Logger.getLogger(NhaSXDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(NhaSX entity, String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<NhaSX> selectAll() {
        return this.selectBySql("select * from NSx");
    }

    @Override
    public NhaSX selectById(String id) {
        List<NhaSX> listNsx = this.selectBySql(selectById, id);
        if (listNsx.isEmpty()) {
            return null;
        }
        return listNsx.get(0);
    }

}

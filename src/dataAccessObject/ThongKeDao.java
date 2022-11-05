package dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import repository.jdbcUntil;

public class ThongKeDao {

    private List<Object[]> getListOfArray(String sql, String[] cols, Object... args) {
        List<Object[]> list = new ArrayList<>();

        try {
            ResultSet rs = jdbcUntil.query(sql, args);
            while (rs.next()) {
                Object[] temp = new Object[cols.length];
                for (int i = 0; i < cols.length; i++) {
                    temp[i] = rs.getObject(cols[i]);
                }
                list.add(temp);
            }
            rs.getStatement().getConnection().close();

        } catch (SQLException ex) {
            Logger.getLogger(ThongKeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<Object[]> getSanPham() {
        String sql = "{CALL procSanPhamCT}";
        String[] cols = {"Ma", "Ten", "NamBH", "SoLuong", "GiaNhap", "GiaBan", "Mau", "Dong", "NSX", "MoTa"};
        return getListOfArray(sql, cols);
    }

    public List<Object[]> getIdSp(Object...args) {
        String sql="{CALL procTimSP(?,?,?,?,?,?,?,?,?)}";
        String [] cols={"id"};
        return getListOfArray(sql, cols, args);
    }

}

package pioneer.pfix.Dao;

import pioneer.pfix.Entity.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsersDao extends BaseDao{
    public Users selectByUserId(String userid) throws Exception {
        Users users = null;
        Connection conn = getConn();
        String sql = "select * from users where userid=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,userid);
        ResultSet rs = ps.executeQuery();
        if(rs.next())
        {
            String username=rs.getString(3);
            String password=rs.getString(4);
            int type = rs.getInt(5);
            String phone = rs.getString(6);
            String qq = rs.getString(7);
            users  = new Users(userid,username,password,type,phone,qq);
        }
        rs.close();
        ps.close();
        closeConn();
        return users;
    }
}

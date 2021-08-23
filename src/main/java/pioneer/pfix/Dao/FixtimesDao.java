package pioneer.pfix.Dao;

import pioneer.pfix.Entity.Fixtimes;
import pioneer.pfix.Entity.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FixtimesDao extends BaseDao{

    public List GetFixTimes() throws Exception {
        List<Fixtimes> fixtimesList = new ArrayList<>();
        Connection conn = getConn();
        String sql = "select * from fixtimes;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next())
        {
            Fixtimes fixtimes;
            int id = rs.getInt("id");
            String fixtimestring = rs.getString("fixtimestring");
            int schoolid = rs.getInt("schoolid");
            int weekdayid = rs.getInt("weekdayid");
            int positionid = rs.getInt("positionid");
            fixtimes = new Fixtimes(id,schoolid,fixtimestring,weekdayid,positionid);
            fixtimesList.add(fixtimes);
        }
        return fixtimesList;
    }
}

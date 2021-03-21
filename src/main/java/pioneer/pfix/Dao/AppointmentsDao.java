package pioneer.pfix.Dao;

import pioneer.pfix.Entity.Appointments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AppointmentsDao extends BaseDao{
    public void AddAppointment(Appointments appointment) throws Exception
    {
        Connection conn= getConn();
        String sql = "insert into appointments(username,phone,qq,school,fixtime,problemid,description) values(?,?,?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,appointment.getUsername());
        // TODO: 完成插入

        ResultSet rs = ps.executeQuery();
    }
}

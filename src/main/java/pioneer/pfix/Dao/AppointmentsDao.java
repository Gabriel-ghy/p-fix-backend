package pioneer.pfix.Dao;

import pioneer.pfix.Entity.Appointments;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AppointmentsDao extends BaseDao{
    public void MakeAppointment(Appointments appointment) throws Exception
    {
        Connection conn= getConn();
        String sql = "insert into appointments(username,phone,qq,school,fixtime,problemid,description) values(?,?,?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,appointment.getUsername());
        ps.setString(2,appointment.getPhone());
        ps.setString(3,appointment.getQq());
        ps.setInt(4,appointment.getSchool());
        ps.setInt(5,appointment.getFixtimeid());
        ps.setInt(6,appointment.getProblemid());
        ps.setString(7,appointment.getDescription());
        ps.executeUpdate();
        ps.close();
        closeConn();
    }
}

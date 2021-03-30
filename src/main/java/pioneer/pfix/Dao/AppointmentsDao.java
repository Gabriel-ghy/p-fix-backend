package pioneer.pfix.Dao;

import pioneer.pfix.Entity.Appointments;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AppointmentsDao extends BaseDao{
    public void MakeAppointment(Appointments appointment) throws Exception
    {
        Connection conn= getConn();
        String sql = "insert into appointments(`name`,phone,qq,schoolid,fixtimeid,model,problemid,description) values(?,?,?,?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,appointment.getName());
        ps.setString(2,appointment.getPhone());
        ps.setString(3,appointment.getQq());
        ps.setInt(4,appointment.getSchoolid());
        ps.setInt(5,appointment.getFixtimeid());
        ps.setString(6,appointment.getModel());
        ps.setInt(7,appointment.getProblemid());
        ps.setString(8,appointment.getDescription());
        ps.executeUpdate();
        ps.close();
        closeConn();
    }
}

package pioneer.pfix.Dao;

import pioneer.pfix.Entity.Appointments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AppointmentsDao extends BaseDao{
    public void MakeAppointment(Appointments appointment) throws Exception
    {
        Connection conn= getConn();
        String sql = "insert into appointments(`name`,phone,qq,schoolid,fixdate,model,problemid,description) values(?,?,?,?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,appointment.getName());
        ps.setString(2,appointment.getPhone());
        ps.setString(3,appointment.getQq());
        ps.setInt(4,appointment.getSchoolid());
        ps.setString(5,appointment.getFixdate());
        ps.setString(6,appointment.getModel());
        ps.setInt(7,appointment.getProblemid());
        ps.setString(8,appointment.getDescription());
        ps.executeUpdate();
        ps.close();
        closeConn();
    }
    public List<Appointments> GetAllAppointMents() throws Exception
    {
        Connection connection = getConn();
        String sql = "select * from appointments";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        List<Appointments> appointmentsList = new ArrayList<>();
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next())
        {
            int id=rs.getInt(1);
            String name=rs.getString(2);
            String phone=rs.getString(3);
            String qq=rs.getString(4);
            int schoolid=rs.getInt(5);
            String fixdate=rs.getString(6);
            String model=rs.getString(7);
            int problemid=rs.getInt(8);
            String description=rs.getString(9);
            int status=rs.getInt(10);
            String appointmenttime = rs.getString(11);
            Appointments appointments = new Appointments(id,name,phone,qq,schoolid,fixdate,model,problemid,description,status,appointmenttime);
            appointmentsList.add(appointments);
        }
        return appointmentsList;
    }

    public List<Appointments> GetAppointments(String fixdate1, String fixdate2, int status1, int schoolid1) throws Exception
    {
        Connection connection = getConn();
        String sql = "select * from appointments where fixdate>=? and fixdate<=?";
        if(status1 != 3) {
            sql += " and status=?";
        }
        if(schoolid1 != 3)
        {
            sql += " and schoolid=?";
        }
        System.out.println(sql);
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,fixdate1);
        preparedStatement.setString(2,fixdate2);
        if(status1 != 3 && schoolid1 == 3)
            preparedStatement.setInt(3,status1);
        else if(status1 != 3) {
            preparedStatement.setInt(3, status1);
            preparedStatement.setInt(4, schoolid1);
        }
        else if(schoolid1 != 3)
            preparedStatement.setInt(3,schoolid1);

        List<Appointments> appointmentsList = new ArrayList<>();
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next())
        {
            int id=rs.getInt(1);
            String name=rs.getString(2);
            String phone=rs.getString(3);
            String qq=rs.getString(4);
            int schoolid=rs.getInt(5);
            String fixdate=rs.getString(6);
            String model=rs.getString(7);
            int problemid=rs.getInt(8);
            String description=rs.getString(9);
            int status=rs.getInt(10);
            String appointmenttime = rs.getString(11);
            Appointments appointments = new Appointments(id,name,phone,qq,schoolid,fixdate,model,problemid,description,status,appointmenttime);
            appointmentsList.add(appointments);
        }
        rs.close();
        preparedStatement.close();
        closeConn();
        return appointmentsList;
    }

    public void SetAppointmentStatus(int appointmentid, int status) throws Exception
    {
        Connection connection = getConn();
        String sql = "update appointments set status=? where id=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1,status);
        ps.setInt(2,appointmentid);
        ps.executeUpdate();
        ps.close();
        closeConn();
    }
}

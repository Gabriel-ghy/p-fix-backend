package pioneer.pfix.Dao;

import pioneer.pfix.Entity.Notes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NotesDao extends BaseDao{
    public List<Notes> GetNotesByAppId(int appId) throws Exception {
        List<Notes> notesList = new ArrayList<>();
        Connection conn = getConn();
        String sql = "select * from notes where appointmentid=?";  //order by
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1,appId);
        ResultSet rs = ps.executeQuery();
        while (rs.next())
        {
            String fixuserid=rs.getString(3);
            String notetime=rs.getString(4);
            String note = rs.getString(5);
            Notes notes = new Notes(appId,fixuserid,notetime,note);
            notesList.add(notes);
        }
        rs.close();
        ps.close();
        closeConn();
        return notesList;
    }
    public void AddNotes (Notes notes) throws Exception{
        Connection conn = getConn();
        String sql = "insert into notes(appointmentid,fixuserid,note) values(?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1,notes.getAppointmentid());
        ps.setString(2,notes.getFixuserid());
        ps.setString(3,notes.getNote());
        ps.executeUpdate();
        ps.close();
        closeConn();
    }

}

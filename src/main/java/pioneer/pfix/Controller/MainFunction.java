package pioneer.pfix.Controller;

import com.alibaba.fastjson.JSONObject;
import jdk.nashorn.internal.parser.Token;
import org.springframework.web.bind.annotation.*;
import pioneer.pfix.Anotation.UserLoginToken;
import pioneer.pfix.Dao.AppointmentsDao;
import pioneer.pfix.Dao.FixtimesDao;
import pioneer.pfix.Dao.NotesDao;
import pioneer.pfix.Dao.UsersDao;
import pioneer.pfix.Entity.Appointments;

import pioneer.pfix.Entity.Fixtimes;
import pioneer.pfix.Entity.Notes;
import pioneer.pfix.Entity.Users;
import pioneer.pfix.Service.CleanKeyWords;
import pioneer.pfix.Service.TokenService;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("api")
public class MainFunction {
    TokenService tokenService = new TokenService();

    @RequestMapping(value = "/Appointment",method = RequestMethod.POST)
    public boolean MakeAppointment(@RequestBody JSONObject appointment) throws Exception {
        System.out.println(appointment);
        appointment = JSONObject.parseObject(CleanKeyWords.cleanSql(appointment.toString()));
        Appointments appointment2 = JSONObject.toJavaObject(appointment,Appointments.class);
        AppointmentsDao appointmentsDao = new AppointmentsDao();
        appointmentsDao.MakeAppointment(appointment2);
        return true;
    }
    @RequestMapping(value = "/Login")
    public JSONObject Login(@RequestBody JSONObject jsonObject) throws Exception{
        JSONObject jsonObject2 = JSONObject.parseObject(CleanKeyWords.cleanSql(jsonObject.toString()));
        UsersDao usersDao = new UsersDao();
        Users users = usersDao.selectByUserId(jsonObject2.get("userid").toString());
        JSONObject result = new JSONObject();
        if(users!=null)
        {
            if(jsonObject2.get("password").toString().equals(users.getPassword()))
            {
                String token = tokenService.getToken(users);
                System.out.println(token);
                result.put("code",1);
                result.put("token",token);
                result.put("userid",users.getUserid());
                result.put("username",users.getUsername());
            }
            else
            {
                result.put("code",0);
                result.put("msg","wrong info!");
            }
        }
        else
        {
            result.put("code",0);
            result.put("msg","wrong info!");
        }
        return result;
    }

    @RequestMapping("/GetFixTimes")
    public List GetFixTimes() throws Exception {
        FixtimesDao fixtimesDao = new FixtimesDao();
        List<Fixtimes> fixtimesList = fixtimesDao.GetFixTimes();
        return fixtimesList;
    }
    @UserLoginToken
    @RequestMapping("/GetAllAppointMents")
    public List<Appointments> GetAllAppointMents() throws Exception{
        AppointmentsDao appointmentsDao = new AppointmentsDao();
        List<Appointments> appointmentsList = appointmentsDao.GetAllAppointMents();
        return appointmentsList;
    }

    @UserLoginToken
    @RequestMapping("/GetAppointments")
    public List<Appointments> GetAppointMents(@RequestBody JSONObject jsonObject) throws Exception {
        AppointmentsDao appointmentsDao = new AppointmentsDao();
        return appointmentsDao.GetAppointments((String) jsonObject.get("fixdate1"),(String)jsonObject.get("fixdate2"),Integer.parseInt((String)jsonObject.get("status")),Integer.parseInt((String)jsonObject.get("schoolid")));
    }
    @UserLoginToken
    @RequestMapping("/GetNotesByAppId")
    public List<Notes> GetNotesByAppId(int appointmentid) throws Exception
    {
        NotesDao notesDao = new NotesDao();
        return notesDao.GetNotesByAppId(appointmentid);
    }
    @UserLoginToken
    @RequestMapping("/AddNotes")
    public void AddNotes(@RequestBody JSONObject jsonObject) throws Exception
    {
        Notes notes = new Notes((int)jsonObject.get("appointmentid"),(String)jsonObject.get("fixuserid"),(String) jsonObject.get("note"));
        NotesDao notesDao = new NotesDao();
        notesDao.AddNotes(notes);
        AppointmentsDao appointmentsDao = new AppointmentsDao();
        appointmentsDao.SetAppointmentStatus((int)jsonObject.get("appointmentid"),Integer.parseInt((String)jsonObject.get("status")));
    }
}


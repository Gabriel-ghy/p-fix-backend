package pioneer.pfix.Controller;

import com.alibaba.fastjson.JSONObject;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pioneer.pfix.Dao.AppointmentsDao;
import pioneer.pfix.Dao.FixtimesDao;
import pioneer.pfix.Dao.UsersDao;
import pioneer.pfix.Entity.Appointments;

import pioneer.pfix.Entity.Fixtimes;
import pioneer.pfix.Entity.Users;
import pioneer.pfix.Service.CleanKeyWords;

import java.util.List;


@CrossOrigin
@RestController
public class MainFunction {
    @RequestMapping("/api/Test")
    public String Test1()
    {
        return "阿巴阿巴";
    }
    @RequestMapping(value = "/api/Appointment",method = RequestMethod.POST)
    public boolean MakeAppointment(@RequestBody JSONObject appointment) throws Exception {
        System.out.println(appointment);
        appointment = JSONObject.parseObject(CleanKeyWords.cleanSql(appointment.toString()));
        Appointments appointment2 = JSONObject.toJavaObject(appointment,Appointments.class);
        AppointmentsDao appointmentsDao = new AppointmentsDao();
        appointmentsDao.MakeAppointment(appointment2);
        return true;
    }
    @RequestMapping(value = "/api/Login")
    public JSONObject Login(@RequestBody JSONObject jsonObject) throws Exception{
        JSONObject jsonObject2 = JSONObject.parseObject(CleanKeyWords.cleanSql(jsonObject.toString()));
        UsersDao usersDao = new UsersDao();
        Users users = usersDao.selectByUserId(jsonObject2.get("userid").toString());
        JSONObject result = new JSONObject();
        if(users!=null)
        {
            if(jsonObject2.get("password").toString().equals(users.getPassword()))
            {
                result.put("code",1);
                result.put("token","1231231");
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

    @RequestMapping("/api/GetFixTimes")
    public List GetFixTimes() throws Exception {
        FixtimesDao fixtimesDao = new FixtimesDao();
        List<Fixtimes> fixtimesList = fixtimesDao.GetFixTimes();
        return fixtimesList;
    }


}


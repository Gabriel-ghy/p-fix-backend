package pioneer.pfix.Controller;

import org.springframework.web.bind.annotation.*;
import pioneer.pfix.Dao.AppointmentsDao;
import pioneer.pfix.Entity.Appointments;
import pioneer.pfix.Entity.VO.LoginForm;
import pioneer.pfix.Entity.VO.LoginParameter;

@CrossOrigin
@RestController
public class MainFunction {
    @RequestMapping("/api/Test")
    public String Test1()
    {
        return "阿巴阿巴";
    }
    @RequestMapping(value = "/api/Appointment",method = RequestMethod.POST)
    public boolean MakeAppointment(@RequestBody Appointments appointment) throws Exception {
        AppointmentsDao appointmentsDao = new AppointmentsDao();
        appointmentsDao.MakeAppointment(appointment);
        return true;
    }
    @RequestMapping(value = "/api/Login")
    public LoginParameter Login(@RequestBody LoginForm loginForm) throws Exception{
        System.out.println(loginForm.getUsername()+" "+loginForm.getPassword());
        return new LoginParameter(1,"1231231");
    }
}


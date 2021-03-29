package pioneer.pfix.Controller;

import com.alibaba.fastjson.JSONObject;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pioneer.pfix.Dao.AppointmentsDao;
import pioneer.pfix.Entity.Appointments;
import pioneer.pfix.Entity.VO.LoginForm;
import pioneer.pfix.Entity.VO.LoginParameter;
import pioneer.pfix.Service.CleanKeyWords;
import pioneer.pfix.Service.KaptchaConfig;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

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
    public LoginParameter Login(@RequestBody JSONObject jsonObject) throws Exception{
        JSONObject jsonObject2 = JSONObject.parseObject(CleanKeyWords.cleanSql(jsonObject.toString()));
        return new LoginParameter(1,"1231231");
    }


    @Autowired
    DefaultKaptcha defaultKaptcha;
    private final static Logger logger = LoggerFactory.getLogger(MainFunction.class);
    @RequestMapping("/api/CreateImageCode")
    public void createImageCode(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        byte[] captchaChallengeAsJpeg = null;
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        try {
            // 生产验证码字符串并保存到session中
            String createText = defaultKaptcha.createText();
            request.getSession().setAttribute("imageCode", createText);
            // 使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
            BufferedImage challenge = defaultKaptcha.createImage(createText);
            ImageIO.write(challenge, "jpg", jpegOutputStream);
            logger.info("createImageCode:{}",request.getSession().getAttribute("imageCode"));
        } catch (IllegalArgumentException e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        // 定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
        captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        ServletOutputStream responseOutputStream = response.getOutputStream();
        responseOutputStream.write(captchaChallengeAsJpeg);
        responseOutputStream.flush();
        responseOutputStream.close();
    }

    @RequestMapping("/api/CheckImageCode")
    @ResponseBody
    public Object checkImageCode(HttpServletRequest request,HttpServletResponse response, @RequestParam String inputImageCode) {
        Map<String, Object> result = new HashMap<>();
        String imageCode = (String) request.getSession().getAttribute("imageCode");
        //String inputImageCode = request.getParameter("inputImageCode");
        logger.info("imageCode:{},inputImageCode:{}",request.getSession().getAttribute("imageCode"),inputImageCode);
        if (!imageCode.equals(inputImageCode)) {
            result.put("code", "201");
            result.put("msg", "error");
            result.put("result","验证码错误");
        } else {
            result.put("code", "200");
            result.put("msg", "success");
        }
        return result;
    }



}


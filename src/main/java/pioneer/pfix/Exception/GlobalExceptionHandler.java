package pioneer.pfix.Exception;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseBody  //表示返回的对象，Spring会自动把该对象进行json转化，最后写入到Response中。
public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class) //表示让Spring捕获到所有抛出的SignException异常，并交由这个被注解的方法处理。
    @ResponseStatus(HttpStatus.UNAUTHORIZED)  //表示设置状态码。
    JSONObject handleException(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",HttpStatus.UNAUTHORIZED);
        jsonObject.put("msg","登录验证不通过");
        return jsonObject;
    }
}

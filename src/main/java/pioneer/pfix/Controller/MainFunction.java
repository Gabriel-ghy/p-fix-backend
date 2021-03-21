package pioneer.pfix.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class MainFunction {
    @RequestMapping("/Test")
    public String Test1()
    {
        return "阿巴阿巴";
    }
}

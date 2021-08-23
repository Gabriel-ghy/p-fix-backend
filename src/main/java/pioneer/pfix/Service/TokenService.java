package pioneer.pfix.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import pioneer.pfix.Entity.Users;

import java.util.Date;

public class TokenService {
    public String getToken(Users user) {
        String token="";
        Date date = new Date();
        date.setTime(date.getTime()+5*60*1000); //5分钟后过期
//        date.setTime(date.getTime()+5*1000); //5秒后过期
        System.out.println(date.toString());
        token= JWT.create().withAudience(user.getUserid()).withExpiresAt(date)
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }
}

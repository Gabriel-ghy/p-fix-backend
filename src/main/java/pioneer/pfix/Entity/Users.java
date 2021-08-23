package pioneer.pfix.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users
{
    public int id;
    public String userid;
    public String username;
    public String password;
    public int type;
    public String phone;
    public String qq;

    public Users(String userid, String username, String password, int type, String phone, String qq) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.type = type;
        this.phone = phone;
        this.qq = qq;
    }

    public Users(String userid, String password) {
        this.userid = userid;
        this.password = password;
    }
}

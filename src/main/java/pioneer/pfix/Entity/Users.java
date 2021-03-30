package pioneer.pfix.Entity;

public class Users
{
    public int id;
    public String userid;
    public String username;
    public String password;
    public int type;
    public String phone;
    public String qq;

    public Users(int id, String userid, String username, String password, int type, String phone, String qq) {
        this.id = id;
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.type = type;
        this.phone = phone;
        this.qq = qq;
    }

    public Users(String userid, String username, String password, int type, String phone, String qq) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.type = type;
        this.phone = phone;
        this.qq = qq;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}

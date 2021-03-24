package pioneer.pfix.Entity.VO;

public class LoginParameter
{
    public int code;
    public String token;

    public LoginParameter() {
    }

    public LoginParameter(int code, String token) {
        this.code = code;
        this.token = token;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

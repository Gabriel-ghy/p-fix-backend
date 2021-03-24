package pioneer.pfix.Entity;

public class Appointments
{
    public int id;
    public String username;
    public String phone;
    public String qq;
    public int school;
    public int fixtimeid;
    public int problemid;
    public String description;
    public int status;
    public int fixuserid;
    public String fixusernote;

    public Appointments(int id, String username, String phone, String qq, int school, int fixtimeid, int problemid, String description) {
        this.id = id;
        this.username = username;
        this.phone = phone;
        this.qq = qq;
        this.school = school;
        this.fixtimeid = fixtimeid;
        this.problemid = problemid;
        this.description = description;
    }

    public Appointments(String username, String phone, String qq, int school, int fixtimeid, int problemid, String description) {
        this.username = username;
        this.phone = phone;
        this.qq = qq;
        this.school = school;
        this.fixtimeid = fixtimeid;
        this.problemid = problemid;
        this.description = description;
    }

    public int getFixuserid() {
        return fixuserid;
    }

    public void setFixuserid(int fixuserid) {
        this.fixuserid = fixuserid;
    }

    public String getFixusernote() {
        return fixusernote;
    }

    public void setFixusernote(String fixusernote) {
        this.fixusernote = fixusernote;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public int getSchool() {
        return school;
    }

    public void setSchool(int school) {
        this.school = school;
    }

    public int getFixtimeid() {
        return fixtimeid;
    }

    public void setFixtimeid(int fixtimeid) {
        this.fixtimeid = fixtimeid;
    }

    public int getProblemid() {
        return problemid;
    }

    public void setProblemid(int problemid) {
        this.problemid = problemid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

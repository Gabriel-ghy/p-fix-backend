package pioneer.pfix.Entity;

public class Appointments
{
    public int id;
    public String name;
    public String username;
    public String phone;
    public String qq;
    public int schoolid;
    public String fixdate;
    public String model;
    public int problemid;
    public String description;
    public int status;
    public int fixuserid;
    public String fixusernote;
    public String fixtime;

    public Appointments() {
    }

    public Appointments(int id, String name, String phone, String qq, int schoolid, String fixdate, int problemid, String description) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.qq = qq;
        this.schoolid = schoolid;
        this.fixdate = fixdate;
        this.problemid = problemid;
        this.description = description;
    }

    public Appointments(String name, String phone, String qq, int school, String fixdate, String model, int problemid, String description) {
        this.name = name;
        this.phone = phone;
        this.qq = qq;
        this.schoolid = school;
        this.fixdate = fixdate;
        this.model = model;
        this.problemid = problemid;
        this.description = description;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFixtime() {
        return fixtime;
    }

    public void setFixtime(String fixtime) {
        this.fixtime = fixtime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getSchoolid() {
        return schoolid;
    }

    public void setSchoolid(int schoolid) {
        this.schoolid = schoolid;
    }

    public String getFixdate() {
        return fixdate;
    }

    public void setFixdate(String fixdate) {
        this.fixdate = fixdate;
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

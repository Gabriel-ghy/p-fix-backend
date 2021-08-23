package pioneer.pfix.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Appointments
{
    public int id;
    public String name;
    public String phone;
    public String qq;
    public int schoolid;
    public String fixdate;
    public String model;
    public int problemid;
    public String description;
    public int status;
    public String appointmenttime;

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
}

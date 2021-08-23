package pioneer.pfix.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notes {
    int id;
    int appointmentid;
    String fixuserid;
    String notetime;
    String note;

    public Notes(int appointmentid, String fixuserid, String note) {
        this.appointmentid = appointmentid;
        this.fixuserid = fixuserid;
        this.note = note;
    }

    public Notes(int appointmentid, String fixuserid, String notetime, String note) {
        this.appointmentid = appointmentid;
        this.fixuserid = fixuserid;
        this.notetime = notetime;
        this.note = note;
    }
}

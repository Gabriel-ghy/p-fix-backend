package pioneer.pfix.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fixtimes {
    public int id;
    public int schoolid;
    public String fixtimestring;
    public int weekdayid;
    public int positionid;
}

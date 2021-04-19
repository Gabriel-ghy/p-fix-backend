package pioneer.pfix.Entity;

public class Fixtimes {
    public int id;
    public int schoolid;
    public String fixtimestring;
    public int weekdayid;
    public int positionid;

    public Fixtimes(int id, int schoolid, String fixtimestring, int weekdayid, int positionid) {
        this.id = id;
        this.schoolid = schoolid;
        this.fixtimestring = fixtimestring;
        this.weekdayid = weekdayid;
        this.positionid = positionid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSchoolid() {
        return schoolid;
    }

    public void setSchoolid(int schoolid) {
        this.schoolid = schoolid;
    }

    public String getFixtimestring() {
        return fixtimestring;
    }

    public void setFixtimestring(String fixtimestring) {
        this.fixtimestring = fixtimestring;
    }

    public int getWeekdayid() {
        return weekdayid;
    }

    public void setWeekdayid(int weekdayid) {
        this.weekdayid = weekdayid;
    }

    public int getPositionid() {
        return positionid;
    }

    public void setPositionid(int positionid) {
        this.positionid = positionid;
    }
}

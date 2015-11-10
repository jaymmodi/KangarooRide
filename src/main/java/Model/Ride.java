package Model;

import java.util.Date;

/**
 * Created by jmmodi on 11/10/2015.
 */
public class Ride {

    String rideName;
    Date date;

    public String getRideName() {
        return rideName;
    }

    public void setRideName(String rideName) {
        this.rideName = rideName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

package com.ride.Model;

/**
 * Created by jmmodi on 11/10/2015.
 */
public enum Rides {

    JUMPY_JOEY_EASY_RIDE("JUMPY JOEY EASY RIDE"),
    BIG_BOUNDER_DOWN_UNDER_RIDE("BIG BOUNDER DOWN UNDER RIDE"),
    DEADLY_OUTBACK_SPECIAL("DEADLY OUTBACK SPECIAL");

    public String rideName;

    Rides(String s) {
        rideName = s;
    }

    public String getRideName() {
        return rideName;
    }

    public static String[] names() {
        String[] names = new String[Rides.values().length];
        int index = 0;

        for (Rides rides : Rides.values()) {
            names[index++] = rides.getRideName();
        }
        return names;
    }
}

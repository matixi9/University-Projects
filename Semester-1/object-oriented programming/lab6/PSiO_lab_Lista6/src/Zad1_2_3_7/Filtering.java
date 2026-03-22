package Zad1_2_3_7;

import java.util.Arrays;

public class Filtering {

    public static Vehicle[] filterElectric(Vehicle[] vehicles) {
        int count = 0;
        for (Vehicle v : vehicles) {
            if (v instanceof Electric) {
                count++;
            }
        }

        Vehicle[] result = new Vehicle[count];
        int index = 0;
        for (Vehicle v : vehicles) {
            if (v instanceof Electric) {
                result[index] = v;
                index++;
            }
        }
        return result;
    }

    public static Vehicle[] filterByYear(Vehicle[] vehicles, int year) {
        int count = 0;
        for (Vehicle v : vehicles) {
            if (v != null && v.year == year) {
                count++;
            }
        }

        Vehicle[] result = new Vehicle[count];
        int index = 0;
        for (Vehicle v : vehicles) {
            if (v != null && v.year == year) {
                result[index] = v;
                index++;
            }
        }
        return result;
    }
}
package reservations;

import java.util.Random;

public class Reservation implements Reservationy {
    String dow;
    String code;
    Random random = new Random();

    Reservation() {
        this.dow = getDowBooking();
        this.code = getCodeBooking();
    }

    @Override
    public String getDowBooking() {
        String[] dow = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
        return dow[random.nextInt(7)];
    }

    @Override
    public String getCodeBooking() {
        StringBuilder code = new StringBuilder();
        char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        for (int i = 0; i < 8; i++) {
            code.append(chars[random.nextInt(chars.length)]);
        }
        return code.toString();
    }

    @Override
    public String toString() {
        return "Booking# " + code + " for " + dow;
    }
}

package test.Data;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomMonthUtil {public static String getRandomMonth() {
    List<String> months = Arrays.asList(
            "January", "February", "March", "April",
            "May", "June", "July", "August",
            "September", "October", "November", "December");

    return months.get(new Random().nextInt(months.size()));
}
}

package companies.indium;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class CountLogins {
    public static void main(String[] args) {
        List<List<String>> logs = List.of(
                List.of("user1", "09:00:00", "2021-01-01"),
                List.of("user1", "13:00:00", "2021-01-01"),
                List.of("user2", "14:00:00", "2021-01-01"),
                List.of("user1", "20:00:00", "2021-01-01"),
                List.of("user2", "21:00:00", "2021-01-01"),
                List.of("user3", "25:00:00", "2021-01-01"),
                List.of("user4", "22:00:00", "2021-02-29")
        );

        System.out.println(countUserLogins(logs));

//        System.out.println(isValidTime("21:00:00"));
//        System.out.println(isValidTime("25:00:00"));
//        System.out.println(isValidTime("21:40:00"));
//        System.out.println(isValidTime("23:59:60"));


    }

    public static List<List<String>> countUserLogins(List<List<String>> logs) {

        return logs.stream()
                .filter(list -> isValidTime(list.get(1)) && isValidDate(list.get(2), "yyyy-MM-dd"))
                .collect(Collectors.groupingBy(list -> list.get(0).concat(" ").concat(list.get(2)), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .map(mp -> {
                    String[] keyArray = mp.getKey().split(" ");
                    return (List<String>) new ArrayList<>(List.of(keyArray[0], keyArray[1], String.valueOf(mp.getValue())));
                }).collect(Collectors.toList());
    }

    private static boolean isValidDate(String inputDate, String dateFormat) {
        try {
            SimpleDateFormat df = new SimpleDateFormat(dateFormat);
            df.setLenient(false);
            df.parse(inputDate);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }


    private static boolean isValidTime(String time) {
        String[] timeArr = time.split(":");

        int hrs = Integer.parseInt(timeArr[0], 10);
        int min = Integer.parseInt(timeArr[1], 10);
        int sec = Integer.parseInt(timeArr[2], 10);

        return (hrs <= 23 && min <= 59 && sec <= 59);
    }

}

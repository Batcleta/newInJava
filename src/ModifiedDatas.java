import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ModifiedDatas {
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

    public static void main(String[] args) {
        LocalDate increaseDate = LocalDate.parse("16/11/1990", dateFormatter);
        System.out.println(increaseDate);

        increaseDate = increaseDate.plusDays(2);
        System.out.println(increaseDate);

        increaseDate = increaseDate.plusWeeks(2);
        System.out.println(increaseDate);

        increaseDate = increaseDate.plusMonths(2);
        System.out.println(increaseDate);

        boolean isLeapYear = increaseDate.plusYears(2).isLeapYear();
        System.out.println(isLeapYear);


        LocalDate decreaseDate = LocalDate.parse("16/11/1990", dateFormatter);
        System.out.println(decreaseDate);

        decreaseDate = decreaseDate.minusDays(2);
        System.out.println(decreaseDate);

        LocalTime now = LocalTime.parse("05:00", timeFormatter);

        LocalDateTime decreasingDateTime = LocalDateTime.of(decreaseDate, now);

        decreasingDateTime = decreasingDateTime.minusHours(24);
        System.out.println(decreasingDateTime);

        System.out.println(decreaseDate.getD);

    }
}

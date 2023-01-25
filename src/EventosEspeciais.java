import java.time.*;
import java.time.format.DateTimeFormatter;

public class EventosEspeciais {

    public static void main(String[] args) {

    }

    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public static String getDataEventoEspecial() {
        LocalDate date = LocalDate.parse("02/12/1948", dateFormatter);
        System.out.println(date.format(dateFormatter));
        return date.format(dateFormatter);
    }

    public static String getHoraEventoEspecial() {
        LocalTime time = LocalTime.parse("15:20", timeFormatter);
        System.out.println(time.format(timeFormatter));
        return time.format(timeFormatter);
    }

    public static String getDataEHoraEventoEspecial() {
        LocalDateTime dateTime = LocalDateTime.of(LocalDate.parse("16/11/1990", dateFormatter), LocalTime.parse("06:00", timeFormatter));
        System.out.println(dateTime.format(dateTimeFormatter));
        return dateTime.format(dateTimeFormatter);
    }
}
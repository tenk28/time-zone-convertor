import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TimeZoneConversion {
    public static void main(String[] args) {
        // Поточна дата та час у форматі UTC
        LocalDateTime utcDateTime = LocalDateTime.now();
        
        // Часовий пояс UTC
        ZoneId utcZone = ZoneId.of("UTC");
        ZonedDateTime utcZonedDateTime = ZonedDateTime.of(utcDateTime, utcZone);
        
        ZoneId targetZone; // Часовий пояс, до якого потрібно перетворити
        if (args.length == 0) {
            System.out.println("Using default timezone: \"Europe/Kiev\"");
            targetZone = ZoneId.of("Europe/Kiev"); // Наприклад, "Europe/Kiev" - для Києва
        } else {
            targetZone = ZoneId.of(args[0]);
        }
        
        // Перетворення до іншого часового поясу
        ZonedDateTime targetZonedDateTime = utcZonedDateTime.withZoneSameInstant(targetZone);
        
        // Виведення результату
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss Z");
        System.out.println("Сurrent UTC: " + utcZonedDateTime.format(formatter));
        System.out.println("Target Time Zone(" + targetZone.getId() + "): " + targetZonedDateTime.format(formatter));
    }
}

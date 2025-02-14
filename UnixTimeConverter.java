import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class UnixTimeConverter {

    public static String convertUnixTimeTo12hr(long unixTime) {
        // Convert Unix time to milliseconds
        long unixTimeMillis = unixTime * 1000L;

        // Create a Date object from Unix time
        Date date = new Date(unixTimeMillis);

        // Create a SimpleDateFormat object to format the date
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a", Locale.getDefault());

        // Set the time zone to UTC to avoid local time zone conversion
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));

        // Format the date in 12-hour AM/PM format
        return sdf.format(date);
    }

      public static String kelvinToCelsiusString(double kelvin) {
        double celsius = kelvin - 273.15;
        return String.format("%.2f°C", celsius); // Format the temperature with two decimal places and append "°C"
    }

    public static void main(String[] args) {
        long unixTime = 1616648426; // Example Unix time (timestamp in seconds)
        String formattedTime = convertUnixTimeTo12hr(unixTime);
        System.out.println("Unix time: " + unixTime);
        System.out.println("Formatted time (12-hour AM/PM): " + formattedTime);

        double kelvinTemperature = 300; // Example temperature in Kelvin
        String celsiusTemperatureString = kelvinToCelsiusString(kelvinTemperature);
        System.out.println("Temperature in Kelvin: " + kelvinTemperature);
        System.out.println("Temperature in Celsius: " + celsiusTemperatureString);
    }
}

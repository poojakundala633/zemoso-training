package Assignment4;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class KYCForm{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        while(n-- > 0) {
            String[] input = br.readLine().split(" ");
            LocalDate signupDate = LocalDate.parse(input[0], DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            LocalDate currentDate = LocalDate.parse(input[1], DateTimeFormatter.ofPattern("dd-MM-yyyy"));

            LocalDate anniversaryThisYear = signupDate.withYear(currentDate.getYear());

            // If anniversary date is after current date
            if (anniversaryThisYear.isAfter(currentDate)) {
                anniversaryThisYear = anniversaryThisYear.minusYears(1);
            }

            LocalDate rangeStart = anniversaryThisYear.minusDays(30);
            LocalDate rangeEnd = anniversaryThisYear.plusDays(30);

            // If range start is before signup date
            if (rangeStart.isBefore(signupDate)) {
                rangeStart = signupDate;
            }

            // If range end is after current date
            if (rangeEnd.isAfter(currentDate)) {
                rangeEnd = currentDate;
            }

            if (rangeEnd.isBefore(rangeStart)) {
                System.out.println("No range");
            } else {
                System.out.println(rangeStart.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) +
                        " " +
                        rangeEnd.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
            }
        }
    }
}

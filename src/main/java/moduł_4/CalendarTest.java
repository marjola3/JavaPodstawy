package moduł_4;

import java.text.DateFormatSymbols;
import java.util.*;

/**
 * Created by Mariola on 05.04.14.
 */
public class CalendarTest {
    public static void main(String[] args) {
        // Konstrukcja i ustawienie obiektu d oraz jego inicjacja aktualną datą
        GregorianCalendar d = new GregorianCalendar();

        int today = d.get(Calendar.DAY_OF_MONTH);
        int month = d.get(Calendar.MONTH);

        // Ustawienie d na początek miesiąca
        d.set(Calendar.DAY_OF_MONTH, 1);

        int weekday = d.get(Calendar.DAY_OF_WEEK);

        // Pobranie pierwszego dnia tygodnia
        int firstDayOfWeek = d.getFirstDayOfWeek();

        // Określenie odpowiedniego wcięcia pierwszego wiersza
        int indent = 0;
        while (weekday != firstDayOfWeek) {
            indent++;
            d.add(Calendar.DAY_OF_MONTH, -1);
            weekday = d.get(Calendar.DAY_OF_WEEK);
        }

        // Drukowanie nazw dni tygodnia
        String[] weekdayNames = new DateFormatSymbols().getShortWeekdays();
        do {
            System.out.printf("%4s", weekdayNames[weekday]);
            d.add(Calendar.DAY_OF_MONTH, 1);
            weekday = d.get(Calendar.DAY_OF_WEEK);
        } while (weekday != firstDayOfWeek);
        System.out.println();

        for(int i = 1; i <= indent; i++) {
            System.out.print("    ");
        }

        d.set(Calendar.DAY_OF_MONTH, 1);
        do {
            // Drukowanie dnia
            int day = d.get(Calendar.DAY_OF_MONTH);
            System.out.printf("%3d", day);

            // Oznaczenie bieżącego dnia znakiem *
            if (day == today) System.out.print("*");
            else System.out.print(" ");

            // Ustawienie d na kolejny dzień
            d.add(Calendar.DAY_OF_MONTH, 1);
            weekday = d.get(Calendar.DAY_OF_WEEK);

            // Rozpoczęcie nowego wiersza na początku tygodnia
            if (weekday == firstDayOfWeek) System.out.println();
        } while (d.get(Calendar.MONTH) == month);
        // Pętla kończy działanie, jeśli d jest pierwszym dniem następnego miesiąca

        // Wydruk końcowego znaku nowego wiersza w razie potrzeby
        if (weekday != firstDayOfWeek) System.out.println();
    }
}

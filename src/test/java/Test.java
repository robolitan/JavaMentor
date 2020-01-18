import javafx.scene.input.DataFormat;

import java.sql.Date;
import java.text.DateFormat;
import java.time.LocalDate;

public class Test {
    public static void main(String[] args) {
        Date date = Date.valueOf("1999-01-01");
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
        String newview = dateFormat.format(date);
        System.out.println(newview);

        String[] parseDate = newview.split("\\.",3);
        int x = 0;

        System.out.println("01.01.1999 - " + Date.valueOf(LocalDate.of(
                Integer.parseInt(parseDate[2]),
                Integer.parseInt(parseDate[1]),
                Integer.parseInt( parseDate[0]))));
    }
}
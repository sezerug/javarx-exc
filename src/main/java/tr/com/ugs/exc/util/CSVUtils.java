package tr.com.ugs.exc.util;

import com.opencsv.CSVReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;

/**
 * Created by usezer on 27.04.2017.
 */
public final class CSVUtils {

    private CSVUtils() {
    }

    public static CSVReader getReader(String fileName) {
        CSVReader csvReader = null;
        try {
            csvReader = new CSVReader(new InputStreamReader(new FileInputStream(Paths.get("src/main/resources/" + fileName).toFile()), "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return csvReader;
    }

    public static Double parseNotNull(String num) {
        double val;
        try {
            val = Double.parseDouble(num);
        } catch (NumberFormatException e) {
            val = 0.0;
        }
        return val;
    }
}

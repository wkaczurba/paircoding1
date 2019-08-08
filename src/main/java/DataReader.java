import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class DataReader {

    public static List<DataPoint> readPoints() throws FileNotFoundException {
        FileReader fr = new FileReader("points");
        List<DataPoint> list = new ArrayList<DataPoint>();

        Scanner s = new Scanner(fr).useLocale(Locale.US); // https://stackoverflow.com/questions/4713166/decimal-separator-in-numberformat/4713746

        int i = 0;
        while (s.hasNextFloat()) {
            float x = s.nextFloat();
            if (!s.hasNextFloat()) {
                break;
            }
            float y = s.nextFloat();
            DataPoint dp = new DataPoint();
            dp.x = x;
            dp.y = y;
            list.add(dp);
        }
        return list;
    }
}

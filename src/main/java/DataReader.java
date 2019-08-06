import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DataReader {

    public static DataPoint[] readPoints() throws FileNotFoundException {
        FileReader fr = new FileReader("points");
        DataPoint[] retval = new DataPoint[20000];

        Scanner s = new Scanner(fr);
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
            retval[i++] = dp;
        }
        //for ()
        return retval;
    }

//    public static void writePoints() throws IOException {
//        FileWriter fw = new FileWriter("points");
//        for (int i = 0; i < 20000; i++) {
//            DataPoint dp = new DataPoint();
//            dp.x = (float) Math.random()*100 - 50;
//            dp.y = (float) Math.random()*10 - 50;
//            String s = String.format( "%f %f %n", dp.x, dp.y);
//
//            fw.write(s);
//        }
//    }
}

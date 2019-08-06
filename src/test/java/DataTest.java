import com.sun.nio.sctp.IllegalReceiveException;
import org.junit.Test;
import org.omg.DynamicAny.DynAnyPackage.InvalidValue;

import java.io.FileNotFoundException;
import java.io.IOException;

public class DataTest {

    @Test
    public void readerTest() throws IOException, InvalidValue {
        if (DataReader.readPoints().length != 20000) {
            throw new InvalidValue("Expected 20000 points");
        }
    }

    @Test public void fieldTest() throws FileNotFoundException {
        Rectangle rectangle = new Rectangle();

        rectangle.x = -1;
        rectangle.x = -1;
        rectangle.x2 = 1;
        rectangle.y2 = 1;

        int count = 0;
        for (DataPoint point : DataReader.readPoints()) {
            if (Checker.isInsideRectangle(rectangle, point.x, point.y)) {
                count++;
            }
        }

        if (count == 0) {
            throw new IllegalStateException("Expected a non-zero value");
        }
    }

}

import org.junit.Test;
import org.omg.DynamicAny.DynAnyPackage.InvalidValue;

import java.io.FileNotFoundException;
import java.io.IOException;

public class DataTest {

    @Test
    public void readerTest() throws IOException, InvalidValue {
        if (DataReader.readPoints().size() != 19836) {
            throw new InvalidValue("Expected 20000 points");
        }
    }

    @Test public void fieldTest() throws FileNotFoundException {
        Rectangle rectangle = new Rectangle();

        rectangle.x = -20;
        rectangle.y = -46;
        rectangle.x2 = 20;
        rectangle.y2 =-43;

        int count = 0;
        for (DataPoint point : DataReader.readPoints()) {
            if (Checker.isInsideRectangle(rectangle, point.x, point.y)) {
                count++;
            }
        }

        if (count == 2048) {
            throw new IllegalStateException("Expected a non-zero value");
        }
    }

}

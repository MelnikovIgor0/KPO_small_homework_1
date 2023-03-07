import org.example.Matrix;
import org.junit.jupiter.api.Order;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.testng.AssertJUnit.*;

public final class MatrixTester {
    private final Matrix matrix1 = new Matrix(new ArrayList(
            Arrays.asList(
                    new ArrayList<>(Arrays.asList(1, 2)),
                    new ArrayList<>(Arrays.asList(3, 4))
            )
    ));

    private final Matrix matrix2 = new Matrix(new ArrayList(
            Arrays.asList(
                    new ArrayList<>(Arrays.asList(3, -1)),
                    new ArrayList<>(Arrays.asList(0, 2))
            )
    ));

    private final Matrix matrix3 = new Matrix(new ArrayList(
            Arrays.asList(
                    new ArrayList<>(Arrays.asList(3, 3)),
                    new ArrayList<>(Arrays.asList(9, 5))
            )
    ));

    private final Matrix matrix4 = new Matrix(new ArrayList(
            Arrays.asList(
                    new ArrayList<>(Arrays.asList(1, 2, 3)),
                    new ArrayList<>(Arrays.asList(4, 5, 6))
            )
    ));

    private final Matrix matrix5 = new Matrix(new ArrayList(
            Arrays.asList(
                    new ArrayList<>(Arrays.asList(5, -3, 0)),
                    new ArrayList<>(Arrays.asList(7, 1, 4)),
                    new ArrayList<>(Arrays.asList(9, 0, -2))
            )
    ));

    private final Matrix matrix6 = new Matrix(new ArrayList(
            Arrays.asList(
                    new ArrayList<>(Arrays.asList(46, -1, 2)),
                    new ArrayList<>(Arrays.asList(109, -7, 8))
            )
    ));

    @Test
    @Order(1)
    public void testEqualsEqual() {
        assertEquals(matrix1, matrix1);
    }

    @Test
    @Order(2)
    public void testEqualsNotEqualValues() {
        assertTrue(!matrix1.equals(matrix2));
    }

    @Test
    @Order(3)
    public void testEqualsNotEqualShapes() {
        assertTrue(!matrix1.equals(matrix6));
    }

    @Test
    @Order(4)
    public void noMatchingSizesTest() {
        try {
            matrix1.multiply(matrix5);
        } catch (Throwable exception) {
            assertEquals(exception.getClass(), IllegalArgumentException.class);
            assertEquals(exception.getMessage(), "Can not multiply matrices with no matches sizes!");
        }
    }

    @Test
    @Order(5)
    public void simpleTest1() {
        assertEquals(matrix1.multiply(matrix2), matrix3);
    }

    @Test
    @Order(6)
    public void simpleTest2() {
        assertEquals(matrix4.multiply(matrix5), matrix6);
    }

    @Test
    @Order(7)
    public void isMultiplyNotChangingSourceMatrixTest() {
        Matrix previousState = new Matrix(matrix1.getAsList());
        matrix1.equals(matrix2);
        assertEquals(matrix1, previousState);
    }

    @Test
    @Order(8)
    public void toStringTest() {
        assertEquals(matrix1.toString(), "[\n[ 1 2 ]\n[ 3 4 ]\n]");
    }
}
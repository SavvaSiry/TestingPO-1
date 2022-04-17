package part1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TgTest {

    @ParameterizedTest(name = "tan({0})")
    @DisplayName("Check PI dots")
    @ValueSource(doubles = {2 * -Math.PI,-Math.PI, 0, Math.PI, 2 * Math.PI})
    void checkPiDots(double param) {
        assertAll(
                () -> Assertions.assertEquals(Math.tan(param), Function.tan(param), 0.0001)
        );
    }

    @ParameterizedTest(name = "tan({0})")
    @DisplayName("Check NaN")
    @ValueSource(doubles = {-1.5 * Math.PI, -0.5 * Math.PI, 0.5 * Math.PI, 1.5 * Math.PI,})
    void checkPiDotsNan(double param) {
        assertAll(
                () -> Assertions.assertEquals(Double.NaN, Function.tan(param))
        );
    }

    @ParameterizedTest(name = "tan({0}) = {1}")
    @DisplayName("Check between dots (-pi/2; +pi/2)")
    @CsvFileSource(resources = "/table_values.csv", numLinesToSkip = 1, delimiter = ';')
    void checkBetweenDotsMinusPiAndPi(double x, double y) {
        assertAll(
                () -> assertEquals(y, Function.tan(x), 0.01)
        );
    }
}

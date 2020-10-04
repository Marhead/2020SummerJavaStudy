import java.time.Duration;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import testrunner.annotation.Score;

public class PostfixCalcTests {
    @Test
    @Score(1)
    public void testCreation() {
        assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
            ICalc calc = new PostfixCalc();
        });
    }

    @Test
    @Score(1)
    public void testEvaluate() {
        assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
            ICalc calc = new PostfixCalc();
            assertThat(calc.evaluate("5 10 4 * +"), is(45));
            assertThat(calc.evaluate("1 2 -"), is(-1));
            assertThat(calc.evaluate("5"), is(5));
        });
    }

    @Test
    @Score(1)
    public void MyTest() {
        assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
            ICalc calc = new PostfixCalc();
            assertThat(calc.evaluate("30 4 - 5 - 7 -"), is(14));
            assertThat(calc.evaluate("21 15 4 2 - - -"), is(8));
        });
    }

    @Test
    @Score(1)
    public void MyTest2() {
        assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
            ICalc calc = new PostfixCalc();
            assertThat(calc.evaluate("1 2 + 3 * 7 +"), is(16));
        });
    }
}
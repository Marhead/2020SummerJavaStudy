import java.time.Duration;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import testrunner.annotation.Score;

public class CafeTests {
    @Test
    @Score(1)
    public void testCreation() {
        assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
            ICafe cafe = new Cafe();
        });
    }

    @Test
    @Score(1)
    public void testSimple() {
        assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
            ICafe cafe = new Cafe();
            cafe.arrive(1, 0, 1);
            assertThat(cafe.serve(), is(1));
            assertThat(cafe.stat(), is(1));
        });
    }

    @Test
    @Score(1)
    public void testAdvanced() {
        assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
            ICafe cafe = new Cafe();
            cafe.arrive(1, 0, 3);
            cafe.arrive(2, 1, 1);
            cafe.arrive(3, 1, 2);
            // time 2
            assertThat(cafe.serve(), is(2));
            assertThat(cafe.stat(), is(1));

            cafe.arrive(4, 2, 2);
            // time 3
            assertThat(cafe.serve(), is(1));
            assertThat(cafe.stat(), is(4));
            // time 4
            assertThat(cafe.serve(), is(3));
            assertThat(cafe.stat(), is(7));
            // time 5
            assertThat(cafe.serve(), is(4));
            assertThat(cafe.stat(), is(10));
        });
    }
}
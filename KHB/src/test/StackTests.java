import java.time.Duration;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import testrunner.annotation.Score;

public class StackTests {
    @Test
    @Score(1)
    public void testCreation() {
        assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
            IStack<Integer> stack = new Stack<>();
        });
    }

    @Test
    @Score(1)
    public void testPush() {
        assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
            IStack<Integer> stack = new Stack<>();
            for (int i = 0; i < 100; i++) {
                stack.push(i);
            }
            assertThat(stack.size(), is(100));
        });
    }

    @Test
    @Score(1)
    public void testPop() {
        assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
            IStack<Integer> stack = new Stack<>();
            for (int i = 0; i < 100; i++) {
                stack.push(i);
            }
            assertThat(stack.size(), is(100));
            for (int i = 0; i < 100; i++) {
                assertThat(stack.pop(), is(99 - i));
            }
        });
    }

    @Test
    @Score(1)
    public void testTop() {
        assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
            IStack<Integer> stack = new Stack<>();
            assertThat(stack.isEmpty(), is(true));
            stack.push(1);
            assertThat(stack.isEmpty(), is(false));
            stack.pop();
            assertThat(stack.isEmpty(), is(true));
        });
    }

    @Test
    @Score(1)
    public void testException() {
        assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
            IStack<Integer> stack = new Stack<>();
            assertThrows(IllegalStateException.class, () -> stack.pop());
        });
    }
}
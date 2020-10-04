import java.time.Duration;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import testrunner.annotation.Score;

public class LISPTests {
    @Test
    @Score(1)
    public void testCreation() {
        assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
            ILISP lisp = new LISP();
        });
    }

    @Test
    @Score(1)
    public void testCheckBracketBalance() {
        assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
            ILISP lisp = new LISP();
            assertThat(lisp.checkBracketBalance("()"), is(true));
            assertThat(lisp.checkBracketBalance(""), is(true));
            assertThat(lisp.checkBracketBalance("({)}"), is(false));
            assertThat(lisp.checkBracketBalance("("), is(false));
            assertThat(lisp.checkBracketBalance("([])"), is(true));
            assertThat(lisp.checkBracketBalance(")(())([()])"), is(false));
            assertThat(lisp.checkBracketBalance("()(())([()])"), is(true));
            assertThat(lisp.checkBracketBalance("((()(())([()])"), is(false));
            assertThat(lisp.checkBracketBalance("((()(())([()])))"), is(true));
            assertThat(lisp.checkBracketBalance("()(())([()])"), is(true));
        });
    }
}
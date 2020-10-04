import java.time.Duration;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import testrunner.annotation.Score;

import java.util.List;
import java.util.Arrays;

public class TreeTraversalTests {
    @Test
    @Score(1)
    public void testCreation() {
        assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
            ITree tree = new Tree(1);
        });
    }

    @Test
    @Score(1)
    public void testOrder() {
        assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
            ITree<Integer> tree = new Tree<>(3);
            tree.add(2);
            tree.add(4);
            tree.add(3);
            tree.add(7);
            tree.add(10);
            tree.add(15);
            tree.add(13);
            tree.add(5);
            tree.add(1);
            //               2
            //    4          3          7
            //10 15 13    5  1
            List<Integer> preorder = Arrays.asList(2, 4, 10, 15, 13, 3, 5, 1, 7);
            List<Integer> postorder = Arrays.asList(10, 15, 13, 4, 5, 1, 3, 7, 2);
            List<Integer> depthorder = Arrays.asList(2, 4, 3, 7, 10, 15, 13, 5, 1);
            assertThat(tree.preOrder(), is(preorder));
            assertThat(tree.postOrder(), is(postorder));
            assertThat(tree.depthOrder(), is(depthorder));
        });
    }
}

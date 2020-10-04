import java.time.Duration;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import testrunner.annotation.Score;

public class TreeTests {
    @Test
    @Score(1)
    public void testCreation() {
        assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
            ITree<Integer> tree = new Tree(1);
        });
    }

    @Test
    @Score(1)
    public void testException() {
        assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
            ITree<Integer> tree = new Tree<>(1);
            TreeNode<Integer> node = new TreeNode<>(1, 1);
            assertThrows(IllegalStateException.class, () -> tree.root());
            assertThrows(IllegalStateException.class, () -> tree.height());
            assertThrows(IllegalArgumentException.class, () -> tree.detach(node));
        });
    }

    @Test
    @Score(1)
    public void testFunctions() {
        assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
            ITree<Integer> tree = new Tree<>(2);
            assertThat(tree.arity(), is(2));
            assertThat(tree.size(), is(0));
            assertThat(tree.isEmpty(), is(true));
            tree.add(2);
            tree.add(4);
            tree.add(3);
            tree.add(7);
            assertThat(tree.size(), is(4));
            tree.add(10);
            tree.add(15);
            assertThat(tree.size(), is(6));
            assertThat(tree.isEmpty(), is(false));
            TreeNode<Integer> root = tree.root();
            TreeNode<Integer> node = root.getChild(0);
            assertThat(node.getValue(), is(4));
            tree.detach(node);
            node = node.getChild(1);
            assertThat(node.getValue(), is(10));
            assertThrows(IndexOutOfBoundsException.class, () -> root.getChild(1));
            node = root.getChild(0);
            assertThat(node.getValue(), is(3));
            assertThat(tree.height(), is(2));
        });
    }
}
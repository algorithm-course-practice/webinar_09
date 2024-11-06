package org.example.stage1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class TreapTest {

    Treap treap = new Treap();

    @Test
    void checkDirect() {
        List<Integer> expected = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            expected.add(i);
            assertFalse(treap.search(i));
        }
        for (int i = 0; i < 20; i++) {
            treap.add(i);
        }
        for (int i = 0; i < 20; i++) {
            assertTrue(treap.search(i));
        }
        assertEquals(expected, treap.inorder().stream().map(n -> n.split(",")[0].substring(1)).map(Integer::parseInt).collect(Collectors.toList()));
        treap.print();

        Treap.Node[] split = treap.split(5);
        treap.print(split[0]);
        treap.print(split[1]);
        for (int i = 0; i < 20; i++) {
            treap.remove(0);
            assertFalse(treap.search(i));
        }
    }

    @Test
    void check() {
        treap.root = new Treap.Node(42, -8,
                new Treap.Node(
                        91, -7
                        ,
                        new Treap.Node(
                                14, -5,
                                new Treap.Node(52, -3),
                                new Treap.Node(37, -2)
                        ),
                        null),
                new Treap.Node(
                        3, -6,
                        new Treap.Node(10, -4, null, new Treap.Node(13, -1)),
                        new Treap.Node(29, 0)
                )
        );

        treap.add(6, 999);
        treap.print();
        System.out.println(treap.inorder());

        System.out.println("----");
    }

    @Test
    void checkReverse() {
        List<Integer> expected = new ArrayList<>();
        for (int i = 20; i > 0; i--) {
            expected.add(i);
            assertFalse(treap.search(i));
        }
        for (int i = 20; i > 0; i--) {
            treap.add(i);
        }
        for (int i = 20; i > 0; i--) {
            assertTrue(treap.search(i));
        }
        expected.sort(Comparator.naturalOrder());
        assertEquals(expected, treap.inorder().stream().map(n -> n.split(",")[0].substring(1)).map(Integer::parseInt).collect(Collectors.toList()));
        treap.print();
        for (int i = 20; i > 0; i--) {
            treap.remove(i);
            assertFalse(treap.search(i));
        }
    }

}
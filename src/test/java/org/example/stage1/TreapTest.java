package org.example.stage1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class TreapTest {

    Treap<Integer> treap = new Treap<>();

    @Test
    void checkDirect(){
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
        assertEquals(expected, treap.inorder().stream().map(n->n.split(",")[0].substring(1)).map(Integer::parseInt).collect(Collectors.toList()));
        treap.print();
        for (int i = 0; i < 20; i++) {
            treap.remove(i);
            assertFalse(treap.search(i));
        }
    }

    @Test
    void checkReverse(){
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
        assertEquals(expected, treap.inorder().stream().map(n->n.split(",")[0].substring(1)).map(Integer::parseInt).collect(Collectors.toList()));
        treap.print();
        for (int i = 20; i > 0; i--) {
            treap.remove(i);
            assertFalse(treap.search(i));
        }
    }

}
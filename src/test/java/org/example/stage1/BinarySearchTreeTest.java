package org.example.stage1;

import org.junit.jupiter.api.Test;
import tech.vanyo.treePrinter.TreePrinter;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {
    TreePrinter<BinarySearchTree.Node> printer = new TreePrinter<>((n)->String.valueOf(n.getValue()), BinarySearchTree.Node::getLeft, BinarySearchTree.Node::getRight);
    {
        printer.setTspace(1);
        printer.setHspace(1);
        printer.setSquareBranches(true);
    }

    @Test
    void add() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        for (int i = 0; i < 20; i++) {
            bst.add(i);
        }
        printer.printTree(bst.root);


        bst.clear();
        for (int i = 20; i > 0; i--) {
            bst.add(i);
        }
        printer.printTree(bst.root);

    }
}
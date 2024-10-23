package org.example.stage1;

import java.util.Scanner;

public class Demo  {


    public static void main(String[] args) {
        Demo demo = new Demo();
        Treap<Integer> treap = new Treap<>();
        Scanner scanner = new Scanner(System.in);
        String cmd = "";
        while (!"exit".equals(cmd)){
            System.out.print("> ");
            cmd = scanner.nextLine();
            String[] cmds = cmd.split(" ");
            if(cmds.length == 1){
                if(cmds[0].equals("inorder")){
                    System.out.println(treap.inorder());
                }
                if(cmds[0].equals("clear")){
                    treap.root = null;
                }
            }
            if(cmds.length == 2){
                if(cmds[0].equals("+")){
                    treap.add(Integer.valueOf(cmds[1]));
                }
                if(cmds[0].equals("++")){
                    treap.addByMerge(Integer.valueOf(cmds[1]));
                }
                if(cmds[0].equals("-")){
                    treap.remove(Integer.valueOf(cmds[1]));
                }
                if(cmds[0].equals("?")){
                    System.out.println(treap.search(Integer.valueOf(cmds[1])));
                }
                if(cmds[0].equals("inc")){
                    String[] range = cmds[1].split(":");
                    Integer minValues = Integer.valueOf(range[0]);
                    Integer maxValues = Integer.valueOf(range[1]);
                    for (int i = minValues; i < maxValues; i++) {
                        treap.add(i);
                    }
                }
                if(cmds[0].equals("dec")){
                    String[] range = cmds[1].split(":");
                    Integer minValues = Integer.valueOf(range[0]);
                    Integer maxValues = Integer.valueOf(range[1]);
                    for (int i = maxValues; i > minValues; i--) {
                        treap.add(i);
                    }
                }
                if(cmds[0].equals("split")){
                    Treap.Node<Integer>[] split = treap.split(Integer.valueOf(cmds[1]));
                    treap.print(split);
                }
            }
            treap.print();
        }
    }

}

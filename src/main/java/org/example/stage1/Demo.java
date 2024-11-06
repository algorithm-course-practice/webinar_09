package org.example.stage1;

import java.util.Scanner;

public class Demo  {


    public static void main(String[] args) {
        Demo demo = new Demo();
        Treap treap = new Treap();
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
                if(cmds[0].equals("stat")){
                    String[] range = cmds[1].split(":");
                    Integer minValues = Integer.valueOf(range[0]);
                    Integer maxValues = Integer.valueOf(range[1]);
                    System.out.println(treap.getStats(minValues, maxValues));
                }
                if(cmds[0].equals("reverse")){
                    String[] range = cmds[1].split(":");
                    Integer minValues = Integer.valueOf(range[0]);
                    Integer maxValues = Integer.valueOf(range[1]);
                    treap.reverse(minValues, maxValues);
                }
                if(cmds[0].equals("split")){
                    Treap.Node[] split = treap.split(Integer.valueOf(cmds[1]));
                    treap.print(split);
                }
                if(cmds[0].equals("k")){
                    System.out.println(treap.findKth(Integer.valueOf(cmds[1])));
                }
                if(cmds[0].equals("field")){
                    Treap.view = Treap.getFieldView(cmds[1]);
                }
                if(cmds[0].equals("left")){
                    treap.shiftLeft(Integer.valueOf(cmds[1]));
                }
                if(cmds[0].equals("right")){
                    treap.shiftRight(Integer.valueOf(cmds[1]));
                }
            }
            if(cmds.length == 3){
                if(cmds[0].equals("all")){
                    String[] range = cmds[1].split(":");
                    Integer minValues = Integer.valueOf(range[0]);
                    Integer maxValues = Integer.valueOf(range[1]);
                    treap.addToAll(minValues, maxValues, Integer.valueOf(cmds[2]));
                }
                if(cmds[0].equals("add")){

                    Integer pos = Integer.valueOf(cmds[1]);
                    Integer value = Integer.valueOf(cmds[2]);
                    treap.add(pos, value);
                }
            }
            treap.print();
            System.out.println(treap.inorder());
        }
    }

}

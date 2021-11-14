package assignment7.task1;

import java.util.Scanner;

public class Echo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedIntList list = new LinkedIntList();
        System.out.println("Add list content: ");
        while(scanner.hasNextInt()){
            int value = scanner.nextInt();
            list.addLast(value);
            System.out.println("Added value to list");
        };
        System.out.println("Printing content of list: ");
        for(IntNode n = list.get(0); n != null; n = n.getNext()){
            System.out.println(n);
        }
    }
}

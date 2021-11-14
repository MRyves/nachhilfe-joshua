package assignment7.task1;

public class Main {

    public static void main(String[] args) {
        LinkedIntList list = new LinkedIntList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        System.out.println(list);

        list.addFirst(0);

        System.out.println(list);

        System.out.println("Remove last: " + list.removeLast());
        System.out.println(list);

        System.out.println("Remove first: " + list.removeFirst());
        System.out.println(list);

        System.out.println("At index 1: " + list.get(1));

        list.set(1, 99);
        System.out.println("At index 2: " + list.get(1));
    }
}

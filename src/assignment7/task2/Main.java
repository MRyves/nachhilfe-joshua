package assignment7.task2;

public class Main {

    public static void main(String[] args) {
        LinkedPersonList list = new LinkedPersonList();
        list.addLast("Test 1");
        list.addLast("Test 2");
        list.addLast("Test 3");

        System.out.println(list);

        list.addFirst("Test 0");

        System.out.println(list);

        System.out.println("Remove last: " + list.removeLast());
        System.out.println(list);

        System.out.println("Remove first: " + list.removeFirst());
        System.out.println(list);

        System.out.println("At index 1: " + list.get(1));

        list.set(1, "New name");
        System.out.println("At index 2: " + list.get(1));

        System.out.println("Adding some new names...");
        list.addLast("Test 10");
        list.addLast("Test 11");
        list.addLast("Test 12");

        System.out.println(list);

        PersonNode nodeToRemove = list.get(3);
        System.out.println("Removing node: " + nodeToRemove);
        list.removeNode(nodeToRemove);
        System.out.println(list);
    }


}

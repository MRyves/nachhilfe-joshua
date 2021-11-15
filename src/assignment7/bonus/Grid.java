package assignment7.bonus;

public class Grid {
    public static void main(String[] args) {
        // using the example from the assignment to test method:

        Node n00 = new Node();
        Node n01 = new Node();
        Node n02 = new Node();

        Node n10 = new Node();
        Node n11 = new Node();
        Node n12 = new Node();

        n00.setRight(n01);
        n01.setRight(n02);

        n10.setRight(n11);
        n11.setRight(n12);

        n00.setBottom(n10);
        n01.setBottom(n11);
        n02.setBottom(n12);

        adjustGrid(n00, 4, 2);

        if (n01 == n00.getRight() &&
                n10 == n00.getBottom() &&
                n11 == n00.getBottom().getRight() &&
                n00.getBottom().getBottom() != null &&
                n00.getBottom().getBottom().getRight() != null &&
                n00.getBottom().getBottom().getBottom() != null &&
                n00.getBottom().getBottom().getBottom().getRight() != null) {
            System.out.println("Adjust grid worked for rows");
        }

        if (n10 == n00.getBottom() &&
                n11 == n00.getRight().getBottom() &&
                n10.getBottom() != null &&
                n11.getBottom() != null &&
                n10.getBottom().getRight() == n11.getBottom() &&
                n10.getBottom().getBottom() != null &&
                n11.getBottom().getBottom() != null &&
                n10.getBottom().getBottom().getRight() == n11.getBottom().getBottom()) {
            System.out.println("Adjust grid worked for columns");
        }
    }

    public static void adjustGrid(Node origin, int a, int b) {
        Node firstNodeOfRow = origin;
        for (int i = 0; i < a; i++) {
            adjustRow(firstNodeOfRow, b);
            if (firstNodeOfRow.getBottom() == null) {
                firstNodeOfRow.setBottom(new Node());
            }
            firstNodeOfRow = firstNodeOfRow.getBottom();
        }
        // there is probably a more performant way to set "bottom"-edges...
        firstNodeOfRow = origin;
        for (int i = 0; i < a; i++) {
            connectRows(firstNodeOfRow, firstNodeOfRow.getBottom());
            firstNodeOfRow = firstNodeOfRow.getBottom();
        }
    }

    /**
     * Create row of given length by setting the {@code right} property of {@link Node}
     *
     * @param startOfRow First {@link Node} of row
     * @param length     length of the row
     */
    public static void adjustRow(Node startOfRow, int length) {
        Node temp = startOfRow;
        for (int j = 1; j < length; j++) {
            Node right = temp.getRight();
            if (right == null) {
                temp.setRight(new Node());
            }
            temp = temp.getRight();
        }
        temp.setRight(null);
    }

    /**
     * Connect top row with bottom row.
     *
     * @param firstNodeTopRow    starting node of top row.
     * @param firstNodeBottomRow starting node of bottom row.
     */
    public static void connectRows(Node firstNodeTopRow, Node firstNodeBottomRow) {
        Node currentNodeTopRow = firstNodeTopRow;
        Node currentNodeBottomRow = firstNodeBottomRow;
        while (currentNodeTopRow != null && currentNodeBottomRow != null) {
            if (currentNodeTopRow.getBottom() != currentNodeBottomRow) {
                currentNodeTopRow.setBottom(currentNodeBottomRow);
            }
            currentNodeTopRow = currentNodeTopRow.getRight();
            currentNodeBottomRow = currentNodeBottomRow.getRight();
        }
    }
}

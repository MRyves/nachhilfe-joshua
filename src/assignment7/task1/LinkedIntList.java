package assignment7.task1;

public class LinkedIntList {

    private int size = 0;

    private IntNode first = null;
    private IntNode last = null;

    public void addLast(int number) {
        if (this.size == 0) {
            this.first = this.last = new IntNode(number);
        } else {
            IntNode node = new IntNode(number);
            this.last.setNext(node);
            this.last = node;
        }
        this.size += 1;
    }

    public void addFirst(int number){
        IntNode node = new IntNode(number);
        if(this.size == 0){
            this.first = this.last = node;
        } else {
            node.setNext(this.first);
            this.first = node;
        }
        this.size += 1;
    }

    public int removeFirst(){
        if(this.isEmpty()){
            // Errors.error()
            throw new IndexOutOfBoundsException("List is empty");
        }
        IntNode currentFirst = this.first;
        this.first = currentFirst.getNext();
        this.size -= 1;
        return currentFirst.getNumber();
    }

    public int removeLast(){
        if(this.isEmpty()){
            // Errors.error()
            throw new IndexOutOfBoundsException("List is empty");
        }
        IntNode currentLast = this.last;
        this.last = this.get(this.size - 2);
        this.last.setNext(null);
        this.size -= 1;
        return currentLast.getNumber();
    }

    public void clear(){
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public IntNode get(int index) {
        if(index >= this.size){
            // Errors.error()
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        IntNode node = this.first;
        for (int i = 1; i <= index; i++) {
            node = node.getNext();
        }
        return node;
    }

    public void set(int index, int value){
        IntNode node = this.get(index);
        node.setNumber(value);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("List content: [ ");
        IntNode node = this.first;
        while (node != null) {
            sb.append(node.getNumber());
            node = node.getNext();
            if(node != null){
                sb.append(", ");
            } else {
                sb.append(" ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}

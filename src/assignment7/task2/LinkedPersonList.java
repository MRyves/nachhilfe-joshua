package assignment7.task2;

public class LinkedPersonList {

    private int size = 0;

    private PersonNode first = null;
    private PersonNode last = null;

    public void addLast(String name) {
        if (this.size == 0) {
            this.first = this.last = new PersonNode(name);
        } else {
            PersonNode node = new PersonNode(name);
            node.setPrev(this.last);
            this.last.setNext(node);
            this.last = node;
        }
        this.size += 1;
    }

    public void addFirst(String name){
        PersonNode node = new PersonNode(name);
        if(this.size == 0){
            this.first = this.last = node;
        } else {
            node.setNext(this.first);
            this.first.setPrev(node);
            this.first = node;
        }
        this.size += 1;
    }

    public String removeFirst(){
        if(this.isEmpty()){
            // Errors.error()
            throw new IndexOutOfBoundsException("List is empty");
        }
        PersonNode currentFirst = this.first;
        this.first = currentFirst.getNext();
        this.size -= 1;
        return currentFirst.getName();
    }

    public String removeLast(){
        if(this.isEmpty()){
            // Errors.error()
            throw new IndexOutOfBoundsException("List is empty");
        }
        PersonNode currentLast = this.last;
        this.last = currentLast.getPrev();
        this.last.setNext(null);
        this.size -= 1;
        return currentLast.getName();
    }

    public void removeNode(PersonNode node){
        if(node == this.first){
            // special case first node:
            this.removeFirst();
        } else if (node == this.last){
            // special case last node:
            this.removeLast();
        } else {
            // normal scenario:
            PersonNode temp = this.first.getNext();
            while(temp != null){
                if(node == temp){
                    // remove node
                    PersonNode prev = temp.getPrev();
                    PersonNode next = temp.getNext();
                    prev.setNext(next);
                    next.setPrev(prev);
                    this.size -= 1;
                    temp = null;
                } else {
                    temp = temp.getNext();
                }
            }
        }
    }

    public void clear(){
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public PersonNode get(int index) {
        if(index >= this.size){
            // Errors.error()
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        PersonNode node = this.first;
        for (int i = 1; i <= index; i++) {
            node = node.getNext();
        }
        return node;
    }

    public void set(int index, String name){
        PersonNode node = this.get(index);
        node.setName(name);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("List content: [ ");
        PersonNode node = this.first;
        while (node != null) {
            sb.append(node.getName());
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

package assignment7.task2;

public class PersonNode {

    private String name;
    private PersonNode next = null;
    private PersonNode prev = null;


    public PersonNode(String name) {
        this.name = name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public PersonNode getNext(){
        return this.next;
    }

    public void setNext(PersonNode next) {
        this.next = next;
    }

    public PersonNode getPrev() {
        return prev;
    }

    public void setPrev(PersonNode prev) {
        this.prev = prev;
    }

    @Override
    public String toString(){
        return "Person: " + this.name;
    }
}

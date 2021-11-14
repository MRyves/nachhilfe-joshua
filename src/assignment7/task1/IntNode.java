package assignment7.task1;

public class IntNode {

    private int number;
    private IntNode next;


    public IntNode(int number) {
        this.number = number;
    }

    public void setNumber(int number){
        this.number = number;
    }

    public int getNumber(){
        return this.number;
    }

    public IntNode getNext(){
        return this.next;
    }

    public void setNext(IntNode next) {
        this.next = next;
    }

    public String toString(){
        return String.valueOf(this.number);
    }
}

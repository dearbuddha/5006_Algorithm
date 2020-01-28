package homework2;

public class StackUsingLinkedList {
    /**
     * Wenhan Cai
     * CS 5006 homework 2-3
     *
     * Implement a stack using linked list
     *
     * @return a linked list or null
     */
    private class Node{
        int data;
        Node next;
    }

    private Node head;

    public StackUsingLinkedList(){
        head = null;
    }

    public void push(int data){
        Node temp = head;
        head = new Node();
        head.data = data;
        head.next = temp;
    }

    public int pop(){
        if(head == null){
            System.out.println("Stack is already empty.");
        }
        int data = head.data;
        head = head.next;
        return data;
    }

    public static void main(String[] args) {

        StackUsingLinkedList stack = new StackUsingLinkedList();
        for(int i = 0; i <= 10; i++){
            stack.push(i);
        }
        for(int i = 0; i <= 10; i++){
            int data = stack.pop();
            System.out.println(data);
        }

        stack.push(100);
        stack.push(200);
        int data1 = stack.pop();
        int data2 = stack.pop();
        System.out.println(data1);
        System.out.println(data2);
        stack.pop(); //pop an empty list
    }
}

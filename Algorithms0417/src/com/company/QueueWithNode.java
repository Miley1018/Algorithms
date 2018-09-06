package com.company;

/**
 * Created by mileygao on 4/18/17.
 */
public class QueueWithNode<Item> {
    private Node first;
    private Node last;
    private int N;
    private class Node{
        Item item;
        Node next;
    }
    public void push(Item s){
        Node oldlast = last;
        last = new Node();
        last.item = s;
        last.next = null;
        if (first==null){                            //-----------if isEmpty. now right?
            first = last;
        }else{
            oldlast.next = last;
        }
        N++;
    }
    public Item pop(){
        Item item = first.item;
        first = first.next;
        N--;
        if (isEmpty()){                             // -----------不懂。 N不会变负数？
            last = null;
        }
        return item;
    }
    public boolean isEmpty(){
        return N==0;
    }
    public int size(){
        return N;
    }


}

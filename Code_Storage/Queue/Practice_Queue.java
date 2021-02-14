package com.company;
// cited from learning programming academy "https://www.udemy.com/course/data-structures-and-algorithms-deep-dive-using-java/")
import java.util.NoSuchElementException;

public class Practice_Queue {

    private object[] queue; // refer to object.java (cited from learning programming academy "https://www.udemy.com/course/data-structures-and-algorithms-deep-dive-using-java/")
    private int front;
    private int back;

    public Practice_Queue(int num){ // constructed the queue with number of capacity needed
        queue = new object[num];
    }

    public void add(object ob){ // implement add method , this method would touch the front pointer (queue are FIFO)
        if(back == queue.length){ // check whether the queue is full and resize the array
            object[] newarray = new object[2*queue.length]; // resize the array
            System.arraycopy(queue, 0 ,newarray , 0, queue.length); // copy existing item the old array to the new array
            queue = newarray; // change back to new array
        }
        queue[back] = ob; // back points to the new object that are going to be added
        back ++; // increment back to point the next index
    }

    public object remove(){ // queue removes from the front of the queue
        if (this.size() == 0){
            throw new NoSuchElementException(); // if the size of the array is 0, then the queue is empty throw the exception
        }

        object ob = queue[front]; //  copy the item to be removed
        queue[front] = null; // remove the item by setting it to null
        front ++; // front points to the next element in the queue

        if(size() == 0){ // optimize the method by resetting the front and back pointer to zero. if the element removed was the only element in the queue
            front = 0;
            back = 0;
        }
        return ob; // return the item removed
    }

    public object peek(){ // return the value but not changing the queue at all
        if (this.size() == 0){
            throw new NoSuchElementException(); // if the size of the array is 0, then the queue is empty throw the exception
        }
        return queue[front]; // return the value of the front of the queue
    }

    public int size(){
        return back - front;
    }

    public void printQueue(){
        for (int i = front; i<back; i++){
            System.out.println(queue[i]);
        }
    }
}

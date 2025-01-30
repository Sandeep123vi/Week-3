package stackqueuemap;

import java.util.Stack;

public class QueueUsingStack {
   static  Stack<Integer>stack1= new Stack<>();
   static Stack<Integer>stack2= new Stack<>();
    private static int o;

    public void enqueue(int data)
    {
        stack1.push(data);
    }

    public void dequeue()
    {
        while(!stack1.isEmpty())
        {
            int top=stack1.pop();
            stack2.push(top);
        }
        System.out.println(stack2.pop());
    }


    public static void main(String[] args) {
        QueueUsingStack queue=new QueueUsingStack();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.dequeue();
        queue.dequeue();


    }


}

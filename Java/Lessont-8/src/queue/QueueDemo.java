package queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        //them phan tu
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        System.out.println("queue.size() = " + queue.size());

        //xem phan tu
        int peek = queue.peek();
        System.out.println("peek = " + peek);
        System.out.println("queue.size() = " + queue.size());
        //lay phan tu dau queue
        int poll = queue.poll();
        System.out.println("poll = " + poll);
        System.out.println("queue.size() = " + queue.size());
    //lap tung phan tu
        while (!queue.isEmpty()){
            int first = queue.poll();
            System.out.println("first = " + first);
        }
    }
}

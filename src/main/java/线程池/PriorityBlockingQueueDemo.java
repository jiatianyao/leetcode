package 线程池;

import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;

public class PriorityBlockingQueueDemo {

    public static void main(String[] args) throws InterruptedException {
        PriorityBlockingQueue queue = new PriorityBlockingQueue(5,new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                return Integer.parseInt(o2.toString()) - Integer.parseInt(o1.toString());
            }
        });

        queue.add(10);
        queue.add(2);
        queue.add(5);
        while (true){
            System.out.println(queue.take());
        }
    }
}

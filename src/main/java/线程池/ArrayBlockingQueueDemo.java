package 线程池;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ArrayBlockingQueueDemo {

    static ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(3);

    public static void main(String[] args) throws InterruptedException {
        //参数：容量，是否公平队列
//        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<String>(10,true);

        System.out.println(arrayBlockingQueue.size());
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    addQueue();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        arrayBlockingQueue();
    }

    private static void arrayBlockingQueue() throws InterruptedException {

        arrayBlockingQueue.put(1);
        arrayBlockingQueue.put(2);
        arrayBlockingQueue.put(3);
        while (true) {
            TimeUnit.SECONDS.sleep(3);
            System.out.println(arrayBlockingQueue.size() + "-" + arrayBlockingQueue.take());
        }
    }

    private static void addQueue() throws InterruptedException {
        while (true) {
            TimeUnit.SECONDS.sleep(2);
            int i = new Random().nextInt(100);
            System.out.println("i will put"+i);
            arrayBlockingQueue.put(i);
        }
    }
}

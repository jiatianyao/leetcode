package 线程池;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        DelayQueue queue = new DelayQueue();
        long time = System.currentTimeMillis()+10000;
        queue.put(new TestDelayed(1,time + 500));
        queue.put(new TestDelayed(2,time + 300));
        queue.put(new TestDelayed(3,time + 100));
        queue.put(new TestDelayed(4,time + 200));
        queue.put(new TestDelayed(5,time + 400));
        while (true){
            TestDelayed delayed = (TestDelayed)queue.take();
            System.out.println(delayed.orderNumber);
        }
    }
}

class TestDelayed implements Delayed {
    int orderNumber;
    long expire;

    public TestDelayed(int orderNumber, long expire) {
        this.orderNumber = orderNumber;
        this.expire = expire;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return expire-System.currentTimeMillis();
    }

    @Override
    public int compareTo(Delayed o) {
        long t1 = this.getDelay(TimeUnit.MILLISECONDS);
        long t2 = o.getDelay(TimeUnit.MILLISECONDS);
        return Long.compare(t1,t2);
    }
}

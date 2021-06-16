package 线程池;

import java.util.concurrent.*;

public class ThreadPoolExecutorDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //线程池创建方式1
        ExecutorService executorService = Executors.newCachedThreadPool();

        /**
         * 使用固定线程数的线程池，适用于为了满足资源管理的需求，而限制当前线程数的应用场景。或者是适用于负载比较重的服务器。
         * corePoolSize = maximumPoolSize = newFixedThreadPool(num)方法的参数num，实 际只使用了corePool。
         * keepAliveTime的值为0L，表明工作线程如果空闲会被立即终止
         * 使用LinkedBlockingQueue，这是一种基于链表的无界队列，因为队列容量为 Integer.MAX_VALUE。队列中的元素采用FIFO序
         * 使用无界队列，FixedThreadPool在未调用shutdown()或者shutdownNow()方法的情况下，不会调用饱和策略
         * 即不会RejectExecutionHandler.rejectExecution()方法
         */
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(10);

        /**
         *  使用单个线程的线程池，适用于需要保证各个任务顺序执行，而且在任意时刻，不会有多个 活动线程的应用场景
         * corePoolSize = maximumPoolSize = 1
         * keepAliveTime的值为0L
         * 使用LinkedBlockingQueue
         * 使用无界队列，FixedThreadPool在未调用shutdown()或者shutdownNow()方法的情况下，不会调用饱和策略
         * 与FixedThreadPool区别最多只有一个线程活跃，最多只有一个线程执行
         */
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

        /**
         * 根据需要创建新线程的线程池，适用于执行很多短期异步任务的小程序，或者是负载比较轻 的服务器
         * corePoolSize=0, maximumPoolSize = Integer.MAX_VALUE 表明线程池无界，
         * keepAliveTime的值为60s，表明工作线程最多允许空闲60s。超过60s会被终止
         * 使用SynchronousQueue,是一个没有容量的阻塞队列，主线程的每个添加操作必须等待另一个线程移除操作，反之亦然
         * CachedThreadPool在线程池中线程数等于maximumPoolSize时，会调用饱和策略
         */
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();

        /**
         *  使用单个线程的线程池，适用于需要使用单个后台线程执行周期任务，同时需要保证各个任 务执行顺序的应用场景。
         *  corePoolSize = Executors.newScheduledThreadPool(num)中的参数， ScheduledThreadPool的参数大于等于1，
         *  而SingleThreadScheduledExecutor的参数为 1。maximumPoolSize = Integer.MAX_VALUE，实际只使用了corePool。
         *   keepAliveTime的值为0L，表明线程⼀旦空闲就会被终止。
         *   使用DelayQueue，这是⼀个具有优先级的无界队列，内部封装了⼀个PriorityQueue，可 以实现任务的定期执行和延后执行。
         *   使用无界队列，ScheduledThreadPool在未调用shutdown()或者shutdownNow()方法的 情况下，不会调用饱和策略。
         */
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);


        ThreadPoolExecutorDemo threadPoolExecutor = new ThreadPoolExecutorDemo();
//        new ThreadPoolExecutor();
//        new ScheduledExecutorService()

        Future<String> future = executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "result");
        System.out.println(future.get());

        Future<String> task = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "callable result";
            }
        });
        System.out.println(task.get());

    }
}




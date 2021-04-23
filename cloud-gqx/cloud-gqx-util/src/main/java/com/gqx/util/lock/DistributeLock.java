//package com.gqx.util.lock;
//
//
//import org.apache.zookeeper.WatchedEvent;
//import org.apache.zookeeper.Watcher;
//
//import java.util.concurrent.CountDownLatch;
//
//public class DistributeLock implements Watcher {
//
//    private CountDownLatch countDownLatch = new CountDownLatch(1);
//
//    @Override
//    public void process(WatchedEvent watchedEvent) {
//        //监听节点是否被删除
//        // TODO https://blog.csdn.net/u010994966/article/details/93395743
//        // TODO https://blog.csdn.net/qq_43692950/article/details/107444181
//        if (watchedEvent.getType() == Event.EventType.NodeDeleted) {
//            countDownLatch.countDown();
//        }
//    }
//
//
//}

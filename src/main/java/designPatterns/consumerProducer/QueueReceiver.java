package designPatterns.consumerProducer;

import java.util.concurrent.BlockingDeque;

public class QueueReceiver implements Receiver {

    private BlockingDeque<Word> deque;

    public QueueReceiver(BlockingDeque<Word> deque) {
        this.deque = deque;
    }

    @Override
    public Word receiver() {
        try {
            return deque.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }
}

package designPatterns.consumerProducer;

import java.util.concurrent.BlockingDeque;

public class QueueSender implements Sender {

    private BlockingDeque<Word> deque;

    public QueueSender(BlockingDeque<Word> deque) {
        this.deque = deque;
    }

    @Override
    public boolean send(Word word) {
        try {
            deque.put(word);
            return true;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }
}

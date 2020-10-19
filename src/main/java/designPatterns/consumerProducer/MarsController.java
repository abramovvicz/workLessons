package designPatterns.consumerProducer;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MarsController {

    public Receiver receiver;
    public ExecutorService executorService;

    public MarsController(BlockingDeque<Word> words) {
        receiver = new QueueReceiver(words);
        executorService = Executors.newFixedThreadPool(1);
    }

    public void start() {
        executorService.submit(
                () -> {
                    Word w = receiver.receiver();
                    while (w != null) {
                        w = receiver.receiver();
                    }
                }
        );
    }

    public void stop() {
        executorService.shutdown();
    }
}

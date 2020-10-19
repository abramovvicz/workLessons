package designPatterns.consumerProducer;

import javax.management.InvalidAttributeValueException;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.BlockingDeque;

public class EarthController {

    private Parser parser;

    public EarthController(BlockingDeque<Word> words) {
        Sender sender = new QueueSender(words);
        parser = new Parser(sender);
    }

    public boolean processUrl(String url){
        try {
            Downloader downloader = new Downloader(url);
            InputStream inputStream = downloader.getStream();
            return parser.breakDownOnWordAndSend(inputStream);
        } catch (IOException | InvalidAttributeValueException e) {
            e.printStackTrace();
            return false;
        }
    }
}

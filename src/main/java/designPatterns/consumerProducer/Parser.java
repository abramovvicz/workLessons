package designPatterns.consumerProducer;

import javax.management.InvalidAttributeValueException;
import java.io.InputStream;
import java.util.Scanner;

public final class Parser {

    private final Sender sender;

    public Parser(Sender sender) {
        this.sender = sender;
    }

    public boolean breakDownOnWordAndSend(InputStream inputStream) throws InvalidAttributeValueException {
        Scanner scanner = new Scanner(inputStream);
        boolean success = true;
        while (scanner.hasNext()) {
            String s = scanner.next();
            Word w = new Word(s);
            if (!sender.send(w)) {
                success = false;
            }
        }
        scanner.close();
        return success;
    }

}

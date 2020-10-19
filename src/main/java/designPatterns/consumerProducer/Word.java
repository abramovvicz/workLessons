package designPatterns.consumerProducer;

import javax.management.InvalidAttributeValueException;

public class Word {

    private final String value;

    public Word(String value) throws InvalidAttributeValueException {
        if (value.length() > 50) {
            throw new InvalidAttributeValueException();
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

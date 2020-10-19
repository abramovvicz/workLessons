package designPatterns.consumerProducer;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class DelayedQueue implements BlockingDeque<Word> {


    private final long delay;
    private final int maxLength;
    private final BlockingDeque<Word> input;
    private final BlockingDeque<Word> output;
    private ScheduledExecutorService executorService;


    public DelayedQueue(long delay, int maxLength) {
        this.delay = delay;
        this.maxLength = maxLength;
        input = new LinkedBlockingDeque<>();
        output = new LinkedBlockingDeque<>();
        executorService = new ScheduledThreadPoolExecutor(1);
    }

    public void start() {
        executorService.scheduleWithFixedDelay(
                () -> {
                    System.out.println("on start");
                    try {
                        int i = 0;
                        while (input.peek() != null && i < maxLength) {
                            System.out.println("Przekazane słowa " + input.peek().getValue());
                            output.add(input.take());
                            i++;
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }, delay, delay, TimeUnit.MILLISECONDS);
    }

    public void stop() {
        executorService.shutdown();
    }

    @Override
    public void put(Word word) throws InterruptedException {
        input.put(word);
    }

    @Override
    public Word take() throws InterruptedException {
        return output.take();
    }




    /**
     * not used methods
     * @param word
     */

    @Override
    public void addFirst(Word word) {

    }

    @Override
    public void addLast(Word word) {

    }

    @Override
    public boolean offerFirst(Word word) {
        return false;
    }

    @Override
    public boolean offerLast(Word word) {
        return false;
    }

    @Override
    public Word removeFirst() {
        return null;
    }

    @Override
    public Word removeLast() {
        return null;
    }

    @Override
    public Word pollFirst() {
        return null;
    }

    @Override
    public Word pollLast() {
        return null;
    }

    @Override
    public Word getFirst() {
        return null;
    }

    @Override
    public Word getLast() {
        return null;
    }

    @Override
    public Word peekFirst() {
        return null;
    }

    @Override
    public Word peekLast() {
        return null;
    }

    @Override
    public void putFirst(Word word) throws InterruptedException {

    }

    @Override
    public void putLast(Word word) throws InterruptedException {

    }

    @Override
    public boolean offerFirst(Word word, long timeout, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public boolean offerLast(Word word, long timeout, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public Word takeFirst() throws InterruptedException {
        return null;
    }

    @Override
    public Word takeLast() throws InterruptedException {
        return null;
    }

    @Override
    public Word pollFirst(long timeout, TimeUnit unit) throws InterruptedException {
        return null;
    }

    @Override
    public Word pollLast(long timeout, TimeUnit unit) throws InterruptedException {
        return null;
    }

    @Override
    public boolean removeFirstOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean add(Word word) {
        return false;
    }

    @Override
    public boolean offer(Word word) {
        return false;
    }


    @Override
    public boolean offer(Word word, long timeout, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public Word remove() {
        return null;
    }

    @Override
    public Word poll() {
        return null;
    }


    @Override
    public Word poll(long timeout, TimeUnit unit) throws InterruptedException {
        return null;
    }

    @Override
    public int remainingCapacity() {
        return 0;
    }

    @Override
    public Word element() {
        return null;
    }

    @Override
    public Word peek() {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Word> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public int drainTo(Collection<? super Word> c) {
        return 0;
    }

    @Override
    public int drainTo(Collection<? super Word> c, int maxElements) {
        return 0;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Iterator<Word> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public Iterator<Word> descendingIterator() {
        return null;
    }

    @Override
    public void push(Word word) {

    }

    @Override
    public Word pop() {
        return null;
    }
}

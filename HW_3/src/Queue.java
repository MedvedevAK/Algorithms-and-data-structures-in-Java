public interface Queue {

    void insert(int value);

    int remove();

    int getSize();

    boolean isEmpty();

    boolean isFull();
}
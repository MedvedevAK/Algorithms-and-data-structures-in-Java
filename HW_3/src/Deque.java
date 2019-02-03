public interface Deque {

    void insertLeft(int value);
    void insertRight(int value);

    int removeLeft();
    int removeRight();

    int getSize();

    boolean isEmpty();

    boolean isFull();

}
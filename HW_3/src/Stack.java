public interface Stack {
    char pop();

    void push(char value);

    char peek();

    int getSize();

    boolean isEmpty();

    boolean isFull();
}
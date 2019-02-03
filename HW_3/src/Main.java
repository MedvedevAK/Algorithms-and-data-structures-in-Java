public class Main {
    public static final int ARR_SIZE = 10;

    public static void main(String[] args) {

        Queue qu = new Queuel(ARR_SIZE);
        Deque dequ = new Dequel(ARR_SIZE);
        Kcats cr = new Kcats();

        cr.printStackToString(cr.initializeStack());

        initializeQueue(qu);
        initializeDequeue(dequ);

        while (!dequ.isEmpty()) {
        }
    }
    public static void initializeDequeue(Deque deque) {
        for (int i = 0; i < ARR_SIZE/2; i++) {
            deque.insertLeft(i);
            deque.insertRight(i);
        }
    }
    public static void initializeQueue(Queue queue) {
        for (int i = 0; i < ARR_SIZE; i++) {
            queue.insert(i);
        }
    }
}

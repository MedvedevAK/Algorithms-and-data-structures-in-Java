public class Queuel implements Queue {

        public static final int DEFAULT_MARK_BACK = -1;
        public static final int DEFAULT_MARK_FRONT = 0;
        private int[] data;
        private int currentSize;

        private int markFront;
        private int markBack;

        public Queuel(int maxSize) {
            this.currentSize = 0;
            this.markFront = DEFAULT_MARK_FRONT;
            this.markBack = DEFAULT_MARK_BACK;
            this.data = new int[maxSize];

        }
        @Override
        public void insert(int value) {
            if(markFront == data.length-1){
                markBack = DEFAULT_MARK_BACK;
            }
            data[++markBack] = value;
            currentSize++;

        }
        @Override
        public int remove() {
            int removedElement = data[markFront++];
            if(markFront == data.length){
                markFront = DEFAULT_MARK_FRONT;
            }
            currentSize--;
            return  removedElement;
        }
        @Override
        public int getSize() {
            return currentSize;
        }
        @Override
        public boolean isEmpty() {
            return currentSize == 0;
        }
        @Override
        public boolean isFull() {
            return currentSize == data.length;
        }
    }



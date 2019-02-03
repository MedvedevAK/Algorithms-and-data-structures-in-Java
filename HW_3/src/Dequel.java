public class Dequel implements Deque {
        private int[] data;
        private int currentSize;
        private int maxSize;
        private int left;
        private int right;

        public Dequel(int maxSize) {
            this.maxSize = maxSize;
            this.currentSize = 0;
            this.left = 0;
            this.right = maxSize - 1;
            this.data = new int[maxSize];
        }
        @Override
        public void insertLeft(int value) {
            if (left == 0) {
                left = maxSize;
            }
            data[--left] = value;
            currentSize++;
        }
        @Override
        public void insertRight(int value) {
            if (right == maxSize - 1) {
                right = -1;
            }
            data[++right] = value;
            currentSize++;
        }
        @Override
        public int removeLeft() {
            int removedElement = data[left];
            left++;
            if (left == maxSize) {
                left = -1;
            }
            currentSize--;
            return removedElement;
        }
        @Override
        public int removeRight() {
            int removedElement = data[right];
            right--;
            if (right < 0) {
                right = maxSize - 1;
            }
            currentSize--;
            return removedElement;
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


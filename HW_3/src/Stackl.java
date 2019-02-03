public class Stackl implements Stack {

        private char[] data;
        private int currentSize;

        public Stackl(int maxSize) {
            this.currentSize = 0;
            this.data = new char[maxSize];
        }
        @Override
        public char pop() {
            return this.data[--currentSize];

        }
        @Override
        public void push(char value) {
            this.data[currentSize++] = value;

        }
        @Override
        public char peek() {
            return this.data[currentSize - 1];
        }
        @Override
        public int getSize() {
            return currentSize;
        }
        @Override
        public boolean isEmpty() {
            return currentSize != 0;
        }
        @Override
        public boolean isFull() {
            return currentSize >= data.length;
        }
    }


import java.util.Random;

public class Lesson_2 {
    public static void main(String[] args) {
        MyArrayList array = new MyArrayList(100000);
        array.randomFill(-20, 20, true);
        array.selectSort(true);
        array.insertSort(true);
    }
}
class MyArrayList {
    private int[] arr;
    private long startTime;
    public MyArrayList(int length) {
        this.arr = new int[length];
    }

    public void randomFill(final int minValue, final int maxValue, final boolean speedLog) {
        startTime = System.currentTimeMillis();
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(maxValue - minValue + 1) + minValue;
        }
        if (speedLog) {
            speedCounter();
        }
    }

    public void add(final int value) {
        int[] tempArray = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            tempArray[i] = arr[i];
        }
        tempArray[tempArray.length - 1] = value;
        arr = tempArray;
    }

    public void insert(final int index, final int value) {
        if (index > arr.length) {
            throw new IndexOutOfBoundsException();
        }
        int[] tempArray = new int[arr.length + 1];
        for (int i = 0; i < tempArray.length; i++) {
            if (i < index) {
                tempArray[i] = arr[i];
            }
            if (i == index) {
                tempArray[i] = value;
            }
            if (i > index) {
                tempArray[i] = arr[i - 1];
            }
        }
        arr = tempArray;
    }

    public void delete(final int value) {
        int[] tempArray = new int[arr.length - 1];
        boolean foundValue = false;
            for (int i = 0, j = 0; i < arr.length; i++) {
                if (arr[i] == value && !foundValue) {
                    foundValue = true;
                    continue;
                }
                if (arr[i] == value && foundValue) {
                    tempArray[j] = arr[i];
                    j++;
                }
                if (arr[i] != value) {
                    tempArray[j] = arr[i];
                    j++;
                }
            }
        if (foundValue) {
            arr = tempArray;
        }
    }

    public void selectSort(final boolean speedLog) {
        startTime = System.currentTimeMillis();
        int p;
        for (int i = 0; i < arr.length - 1; i++) {
            p = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[p]) {
                    p = j;
                }
            }

        }
        if (speedLog) {
            speedCounter();
        }
    }

    public void insertSort(final boolean speedLog) {
        startTime = System.currentTimeMillis();
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                --j;
            }
            arr[j] = temp;
        }

        if (speedLog) {
            speedCounter();
        }
    }
    public void speedCounter() {
        long time = System.currentTimeMillis() - startTime;
        Throwable t = new Throwable();
        StackTraceElement trace[] = t.getStackTrace();
        String method = trace[1].getMethodName();
        if ("randomFill".equals(method)) System.out.println("Массив " + arr.length + " заполнен случайными числами, время : " + time + " мс");
        if ("selectSort".equals(method)) System.out.println("Массив " + arr.length + " метод выбора, время: " + time + " мс");
        if ("insertSort".equals(method)) System.out.println("Массив " + arr.length + " метод вставки, время: " + time + " мс");
    }
}
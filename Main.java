import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[10000];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }

        for (int i = 0; i < array.length; i++) {
            // System.out.print(array[i] + ", ");
        }

        System.out.println("");
        array = scramble(array);

        for (int i = 0; i < array.length; i++) {
            // System.out.print(array[i] + ", ");
        }

        System.out.println("");
        long startTime = System.currentTimeMillis();
        array = insertionSort(array);
        for (int i = 0; i < array.length; i++) {
            // System.out.print(array[i] + ", ");
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Time took = " + (endTime - startTime));
            array = scramble(array);
        long bubbleStartTime = System.currentTimeMillis();
        array = sort(array);
        long bubbleEndTime = System.currentTimeMillis();
        System.out.println("Time took = " + (bubbleEndTime - bubbleStartTime));
        System.out.println();
        if ((bubbleEndTime - bubbleStartTime) < (endTime - startTime)) {
            System.out.println("Bubble sort is " + ((endTime - startTime) - (bubbleEndTime - bubbleStartTime)) + " milliseconds faster.");
        } else {
            System.out.println("Insertion sort is " + ((bubbleEndTime - bubbleStartTime) - (endTime - startTime)) + " milliseconds faster.");
        }
    }

    public static int[] sort(int[] array) {
        int temp;
        for (int j = 0; j < array.length; j++) {
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
        }
        return array;

    }

    public static int check(int[] array, int start, int end, int number) {
        int l = (end - start) / 2 + start;
        if (end < start) {
            return -1;
        }
        if (array[l] == number) {
            return l;
        } else if (array[l] < number) {
            return check(array, l + 1, end, number);
        } else if (array[l] > number) {
            return check(array, start, l - 1, number);
        }
        return -1;
    }

    public static int[] scramble(int[] array) {
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int currentNumber = random.nextInt(i);
            int lastNumber = array[i];
            array[i] = array[currentNumber];
            array[currentNumber] = lastNumber;
        }
        return array;
    }

    public static int[] insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0 && array[j] < array[j - 1]; j--) {
                int storage = array[j - 1];
                array[j - 1] = array[j];
                array[j] = storage;
            }
        }

        return array;
    }
}

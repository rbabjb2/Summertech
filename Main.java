import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[10];
    
        Random random = new Random();
        for(int i = 0; i < array.length; i++) {
           array[i] = random.nextInt(array.length);
            System.out.print(array[i]);
        }
        System.out.println("");
        sort(array);
    }

    public static void sort(int[] array) {
        int temp;
        for (int j = 0; j < array.length; j++) {
            for (int i = 0; i < array.length - 1; i++) {
                    if(array[i] > array[i + 1]) {
                            temp = array[i];
                            array[i] = array[i+1];
                            array[i + 1] = temp;
                    }
                }
            }
            for (int c = 0; c < array.length; c++) {
                System.out.print(array[c]);
            }
    }

    public static int check(int[] array, int start, int end, int number){
      int  l  =  (end - start) / 2 + start;
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
    }

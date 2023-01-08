import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.List;

public class Dz3 {
/**
 */ 
    public static void main( String[] args )
    {
// 1. Реализовать алгоритм сортировки слиянием.
        int[] list = {1,9,5,8,3,52,13,88};
        int[] result = mergeList(list);
        System.out.println("Исходный массив: " + Arrays.toString(result));
        System.out.println("Отсортированный массив: " +Arrays.toString(result));
    }
    public static int[] mergeList(int[] list) {
        int[] temparray1 = Arrays.copyOf(list, list.length);
        int[] temparray2 = new int[list.length];
        int[] result = mergeSorter(temparray1,temparray2,0,list.length);
        return result;
    }
    public static int[] mergeSorter(int[] array1, int[] array2, int startIndex, int endIndex) {
        if (startIndex >= endIndex - 1){
            return array1;
        }

        int middle = startIndex + (endIndex - startIndex) / 2;
        int[] sorter1 = mergeSorter(array1, array2, startIndex, middle);
        int[] sorter2 = mergeSorter(array1, array2, middle, endIndex);

        int index1 = startIndex;
        int index2 = middle;
        int destIndex = startIndex;
        int[] result = sorter1 == array1 ? array2 : array1;
        while (index1 < middle && index2 < endIndex) {
            result[destIndex++] = sorter1[index1] < sorter2[index2]
                    ? sorter1[index1++] : sorter2[index2++];
        }
        while (index1 < middle) {
            result[destIndex++] = sorter1[index1++];
        }
        while (index2 < endIndex) {
            result[destIndex++] = sorter2[index2++];
        }
        return result;}


        
        // 2. Пусть дан произвольный список целых чисел. Удалить из него чётные числа.
   
        public static void main2( String[] args )
        {
            Random random = new Random();
            List<Integer> list = new ArrayList<Integer>();
            
            for (int i = 0; i < 10; i++){
                int num = random.nextInt(31);
                list.add(num);
            }
            for (Integer l : list) System.out.print(l + " ");

            for (int j = 0; j  < list.size(); j++){
                Integer num = list.get(j);
                if (num % 2 == 0) {
                    list.remove(j);
                    j--;
                }
            }
            System.out.println("\nМассив без четных чисел: ");
            for (Integer k : list) System.out.print(k + " ");
        }

            
        // 3. Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее арифметичское этого списка.   
        public static void main3( String[] args )
        {
            Random random = new Random();
            List<Integer> list = new ArrayList<Integer>();
            int randarea = 30;

            for (int i = 0; i < 10; i++){
                int num = random.nextInt(randarea + 1);
                list.add(num);
            }
            float summ = 0;
            int min = randarea + 1;
            int max = -1;
            System.out.println("Элементы массива: ");
            for (Integer l : list) System.out.print(l + " ");

            for(int j = 0; j <list.size(); j++){
                Integer num = list.get(j);
                summ += num;
                if (min > num){
                    min = num;
                }
                if (max < num){
                    max = num;
                }
            }
            float med = summ / list.size();
            System.out.println("\nМинимальное значение: " + min + "\nМаксимальное значение: " + max + "\nСреднее арифметическое: " + med);
    }
}

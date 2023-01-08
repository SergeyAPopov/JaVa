// package GIT_DZ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Dz5 {
   

//     /**
//      */
    public static void main( String[] args ){

//         // 1. Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что один человек может иметь несколько телефонов.

        HashMap<String, ArrayList<String>> phoneBook = new HashMap<>();
        
        phoneBook.put ("Ivanov", new ArrayList(Arrays.asList("79055555", "79011111", "79022222")));
        phoneBook.put ("Petrov", new ArrayList(Arrays.asList("7909", "7901", "7902")));
        phoneBook.put ("Sidorov", new ArrayList(Arrays.asList("5555", "1111", "2222")));            
        
        String key = "Ivanov";
        ArrayList result = phoneBook.get(key);
        System.out.println("Key = " + key);


// // 2. Пусть дан список сотрудников: Иван, Пётр, Антон и так далее. Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений. Отсортировать по убыванию популярности.


ArrayList<String> names = new ArrayList<String>();
names.add("John");
names.add("John");
names.add("John");
names.add("zzz");
names.add("John");
names.add("zzz");
names.add("zzz");
names.add("Alex");
names.add("Anna");
names.add("zzz");
names.add("Alex");    
HashMap <String, Integer> counter = new HashMap();

for (String i : names) {
    String name = i;
    Integer count = counter.get(name);
    counter.put(name, count == null ? 1 : count + 1);

        }
        System.out.println(counter);

        ArrayList<Map.Entry<String, Integer>> resort = new ArrayList<>(counter.entrySet());
        Collections.sort(resort, Comparator.comparing(Map.Entry::getValue));
        Collections.reverse(resort);
        Map<String, Integer> sort = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : resort) {
            sort.put(entry.getKey(), entry.getValue());
        }
        System.out.println(sort);

// // 3. Реализовать алгоритм пирамидальной сортировки (HeapSort). сортировка кучей   

    int[] array = {33, 1, 67, 5, 29, 0, 298, 1, 66, 3, 66, 5};

    pyramidalSorting(array);
    for (int element : array) {
        System.out.println(element);
    }
}
    public static void leadToMindHeap(int[] a, int i, int endIndex) {
        int childIndex1 = 2 * i + 1;
        int childIndex2;

        if (childIndex1 < a.length - 1) {
            childIndex2 = childIndex1 + 1;
        } else {
            childIndex2 = childIndex1;
        }
        int child1 = a[childIndex1];
        int child2 = a[childIndex2];
        int maxChild = (child1 > child2) ? child1 : child2;
        int index = (child1 > child2) ? (childIndex1) : (childIndex2);
        if (maxChild > a[i] && index < endIndex) {
            int temp = a[i];
            a[i] = maxChild;
            a[index] = temp;
            if (index <= (a.length / 2) - 1) {
                leadToMindHeap(a, index, endIndex);
            }
        }
    }

    public static void pyramidalSorting(int[] array) {
        int length = array.length;
        int middleIndex = (array.length / 2) - 1;
        for (int i = middleIndex; i >= 0; i--) {
            leadToMindHeap(array, i, length);
        }
        int endIndex = array.length - 1;
        while (endIndex >= 0) {
            int temp = array[0];
            array[0] = array[endIndex];
            array[endIndex] = temp;
            int middle;
            if (endIndex == 1) {
                if (array[0] > array[endIndex]) {
                    temp = array[0];
                    array[0] = array[endIndex];
                    array[endIndex] = temp;
                    return;
                }
            }
            if (endIndex > 3) {
                middle = endIndex / 2 - 1;
            } else {
                middle = endIndex / 2;
            }
            for (int i = 0; i < middle; i++) {
                leadToMindHeap(array, i, endIndex);
            }

            endIndex--;
        }
    }
}

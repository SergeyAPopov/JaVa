import java.util.LinkedList;
import java.util.Random;


public class Dz4 {
   
    public static void main1( String[] args )
    {
      
// // 1. Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.

        LinkedList<Integer> list = new LinkedList<Integer>();

        for (int i = 0; i < 5; i++){
            int num = i+2;
            list.add(num);
        }
        System.out.println("Исходный список:" + list);
    
        LinkedList<Integer> listreverse = new LinkedList<Integer>();
        for (int i = list.size()-1;i >= 0; i--){
            listreverse.add(list.get(i));   
        }
        list = listreverse;
        System.out.println("перевернутый список:" + list);
    }




// // 2. Реализуйте очередь с помощью LinkedList со следующими методами:
// // enqueue() - помещает элемент в конец очереди, 
// // dequeue() - возвращает первый элемент из очереди и удаляет его, 
// // first() - возвращает первый элемент из очереди, не удаляя.
    public static void main2( String[] args ){

            LinkedList<Integer> numbers = new LinkedList<>();
            Random random = new Random();

            for (int i = 0; i < 5; i++){
                int num = random.nextInt(20);
                numbers.add(num);
            }
            System.out.println("Исходный список:" + numbers);
            enqueue(numbers, 100);
            dequeue(numbers);    
            first(numbers);
            System.out.println(numbers);     
    }

        private static void enqueue(LinkedList numbers, int data) {
        numbers.addLast(data);
        System.out.println("Список с добавленным с конец очереди элементом: " + numbers); 
    }
        private static void dequeue(LinkedList numbers) {
        // System.out.println("Первый элемент списка: " + numbers.getFirst());
        System.out.println("Первый элемент списка: " + numbers.removeFirst() + " Внимание, элемент удален!");
        }

        private static void first(LinkedList numbers) {
            System.out.println("Первый элемент списка: " + numbers.getFirst());
        }


}
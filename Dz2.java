import java.util.Arrays;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
* DZ2
 */
public class Dz2 
{
    /**
     * @param args
     */
    public static void main( String[] args )
    {
//1. В файле содержится строка с исходными данными в такой форме: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
// Требуется на её основе построить и вывести на экран новую строку, в форме SQL запроса:
// SELECT * FROM students WHERE name = "Ivanov" AND country = "Russia" AND city = "Moscow";
// Для разбора строки используйте String.split. Сформируйте новую строку, используя StringBuilder. Значения null не включаются в запрос.

    try (FileReader reader = new FileReader("src/main/java/com/example/data.json")){
            char[] buf = new char[256];
            int c;
            while((c=reader.read(buf)) > 0){
                if (c<256){
                    buf = Arrays.copyOf(buf, c);    
                }
            String data = String.copyValueOf(buf);
            String[] res = data.split(":");
            String arraytest = Arrays.toString(res);
            String[] total = arraytest.split(",");
            int length = total.length;
            int count = 0;
            int countnew = 0;
            for (int i = 0; i < length; i+=2){
                total[i] = total[i].substring(2,total[i].length()-1);
                if (total[i+1].contains("null")){
                    count -=2;
                }
                count += 2;
            }
            String[] collection = new String[count];
            for (int j = 0; j <length - 1 ;j++){
                if (total[j+1].contains("null")){
                    System.out.println(j);
                    j++;
                } 
                else 
                    collection[countnew] = total[j];
                    countnew++;
            }
            StringBuilder result = new StringBuilder();
            result.append("SELECT * FROM students WHERE ");
            for (int k = 0; k < count;k++) {
                if(k % 2 == 0){
                    result.append(collection[k] + " =");
                }
                else
                    if (k == count -1){
                        result.append(collection[k]);
                    }
                    else
                    result.append(collection[k] + " AND ");
            }  
        }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        

    // 2. Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.
    int [] mas = {11, 3, 14, 16, 7}; 
        boolean isSorted = false;
        int buf;
        
        Logger logger =  Logger.getLogger(Dz2.class.getName());
        try {
            Handler fiHandler = new FileHandler("src/main/java/com/example/log.txt",true);
            logger.addHandler(fiHandler);    
        } 
        catch (Exception e) {
            logger.log(Level.ALL, " ", e);
        }
            
            while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < mas.length-1; i++) {
                if(mas[i] > mas[i+1]){
                    isSorted = false;
                    buf = mas[i];
                    mas[i] = mas[i+1];
                    mas[i+1] = buf;                    
                }
            logger.info(Arrays.toString(mas));
            }
        }
    

        //3. В файле содержится строка с данными:
        // [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"}, {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"}, {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
        // Напишите метод, который разберёт её на составные части и, используя StringBuilder создаст массив строк такого вида:
        // Студент Иванов получил 5 по предмету Математика.
        // Студент Петрова получил 4 по предмету Информатика.
        // Студент Краснов получил 5 по предмету Физика.

        try {FileReader reader = new FileReader("src/main/java/com/example/task3.txt");
        BufferedReader br = new BufferedReader(reader);
        String data;
        StringBuilder sb = new StringBuilder();

        while ((data = br.readLine()) != null) {
            data = data.substring(1, data.length() - 1);
            data = data.replaceAll("\\{", "");
            data = data.replaceAll("\\}", "");

            String[] dn = data.split(", ");

            for (int i = 0; i < dn.length; i++) {
                String[] data1 = dn[i].split(",");

                for (int j = 0; j < data1.length; j++) {
                    String[] split = data1[j].split(":");
                    String value = split[1];
                    value = value.substring(1, value.length() - 1);
                    sb.append(value);
                    sb.append(" ");
                }

            }
            String[] solution = sb.toString().split(" ");
            for(int i = 0; i < solution.length; i +=3 ){
                System.out.println("Студент " + solution[i] + " получил " + solution[i + 1] + " по предмету " + solution[i + 2] + ".");
            }
        }
        br.close();
       } catch (Exception e) {
        System.out.println(e.getMessage());
       }       
    }
}

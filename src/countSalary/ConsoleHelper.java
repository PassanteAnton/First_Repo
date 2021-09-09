package countSalary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static String readString () {
        String insertDate = null;

        try {
            insertDate = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return insertDate;
    }
    public static int readInt() {
        int insertDate = 0;
        String d;
        while (true){
            d = readString();
            try{
                insertDate = Integer.parseInt(d);
            }catch (NumberFormatException e){
                System.out.println("Вы ввели не число! Введите число");
                continue;
            }
            break;
        }
        return insertDate;
    }
    public static String insertMasterName(){
        System.out.println("В ведите имя мастера");
        return readString();
    }
    public static int insertMasterCategory(){
        System.out.println("В ведите категорию Мастера \n" +
                            "1 - Старший мастер \n" +
                            "2 - Мастер\n" +
                            "3- Помошник");
        return readInt();
    }
    public static int insertRevenue(){
        System.out.println("В ведите выручку");
        return readInt();
    }

    public static void writeMessage(String message){
        System.out.println(message);
    }


}

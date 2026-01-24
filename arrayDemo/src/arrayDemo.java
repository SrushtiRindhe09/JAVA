import java.net.SocketOption;
import java.sql.SQLOutput;

public class arrayDemo {
    public static void main() {

        // first method
//        int[] intarray;
//        intarray = new int[5];
//        intarray[0] = 10;
//        intarray[1] = 5;
//        System.out.println("first element in array: "+intarray[0]);
//        System.out.println("second element in array: "+intarray[1]);
//        System.out.println("third element in array: "+intarray[2]);

        // second method
//        int array[];
//        array = new int[20];

        // third method
//        int[] array = new int[20];

        // fourth method
        int array[] = {5, 10, 15,20,25};
//        System.out.println("first element is: "+array[0]);
//        1.Iteration of array using for each loop
//        for(int value:array)
//        {
//            System.out.println("values of array: "+value);
//        }
//          2.Iteration of array using for loop
        for(int i=0;i<array.length;i++)
        {
            System.out.println("values in array: "+array[i]);
        }

    }
}

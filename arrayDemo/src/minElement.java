import java.io.OutputStream;

public class minElement {
    static void main() {

        int[] array = {12, 45, 89, 45, 63};
        int min = Integer.MAX_VALUE;

        for(int num : array)
        {
            if(num < min)
            {
                min = num;
            }
        }
        System.out.println("Minimum value is:"+min);
    }
}

//Output
//Minimum value is:12
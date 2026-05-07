public class sumOfArray {
    public static void main() {


        // calculate the sum of array elements
         int[] array = {10, 45, 68, 92};
         int sum = 0;
         for(int number:array)
         {
             sum = sum+number;

         }
        System.out.println("sum of array element is: "+sum);

    }
}
//Output
//sum of array element is: 215
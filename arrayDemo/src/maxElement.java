public class maxElement {
    static void main() {

        int[] array = {12, 45, 89, 45, 63};
        int max = 0;

        for(int num : array)
        {
            if(num > max)
            {
                max = num;
            }
        }
        System.out.println("Maximum value is:"+max);







    }
}

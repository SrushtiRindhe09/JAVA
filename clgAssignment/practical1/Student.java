public class Student 
{
    public static void main(String[] args) 
    {
        int[][] data = {{10,20,30}, {40,50,60}, {70,80,90}};

        int sum=0;

        int min = data[0][0];

        int max = data[0][0];



        for(int i=0; i<data.length; i++)

        {

            for(int j = 0; j<data[i].length; j++)

            {



                sum = sum + data[i][j];



                if(data[i][j] > max)

                {

                    max = data[i][j];

                }



                if(data[i][j] < min)

                {

                    min = data[i][j];

                }



            }

        }

        System.out.println("\n sum of all elements: "+sum);

        System.out.println("\n maximum value: "+max);

        System.out.println("\n minimum value: "+min);

    }
}

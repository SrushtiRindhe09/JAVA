public class ShapeArea 
{ 
    public static void main(String args[])
    {
      Area obj = new Area();
        obj.calculateArea(5);
        obj.calculateArea(5, 10);
        obj.calculateArea(7.5);
    }
 

    
}
class Area
{
  void calculateArea(int a)
  {
    System.out.println("Area of Square: "+ a*a);
  }

  void calculateArea(int l, int b)
  {
    System.out.println("Area of Rectangle: "+ l*b);
  }
  void calculateArea(double r)
  {
    System.out.println("Area of Circle: "+3.14*r*r);
  }

}

/*Output:
Area of Square: 25
Area of Rectangle: 50
Area of Circle: 176.625
*/

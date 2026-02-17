/*runtime polymorphism by defining a base class Animal with a method
makeSound(). Derive subclasses Dog, Cat, and Cow, each overriding the
makeSound() method to provide their unique sound implementation.  */



public class Animal {
    public static void main(String args[])
    {
       Animal a1 = new Dog();
       a1.makeSound();
       Animal a2 = new Cat();
       a2.makeSound();
       Animal a3 = new Cow();
       a3.makeSound();

    }
    void makeSound()
    {
        System.out.println("Animals make Sound");
    }
    
}

class Dog extends Animal
{    @Override
    void makeSound()
    {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal
{    @Override
    void makeSound()
    {
        System.out.println("Cat meows");
    }
}
class Cow extends Animal
{    @Override
    void makeSound()
    {
        System.out.println("Cow moos");
    }
}

/*output:
Dog barks
Cat meows
Cow moos
*/
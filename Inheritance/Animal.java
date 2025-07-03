// public class Animal {
    
// }
abstract class Animal{
    String name;
    int age;

    Animal(String name, int age){
        this.name=name;
        this.age=age;
    }

    public abstract void makeSound();
}

class Dog extends Animal{
    Dog(String name, int age){
        super(name,age);
    }
    @Override
    public void makeSound(){
        System.out.println(name+ " Woof Woof");
    }
}

class Cat extends Animal{
    Cat(String name, int age){
        super(name,age);
    }
    @Override
    public void makeSound(){
        System.out.println(name+" Meow");
    }   
}

class Bird extends Animal{
    Bird(String name,int age){
        super(name,age);
    }
    @Override
    public void makeSound(){
        System.out.println(name+" chirp chirp");
    }
}

public class AnimalHierarchy{
    public static void main(String[] args) {
        Dog dog= new Dog("Tommy",5);
        Cat cat=new Cat("kitty",2);
        Bird bird=new Bird("mitthu",1);
        dog.makeSound();
        cat.makeSound();
        bird.makeSound();
    }
}
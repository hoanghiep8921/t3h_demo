package test;

public class Kieblog {
    public static void main(String[] args) {
//        Animal a = new Dog();
//        new Hospital().treatAnimal(a);
//        System.out.println(a.a);
        String a, b, c, d;
        a = "Hello1234";
        b = "Hello" + String.valueOf(1234);
        c = "Hello" + "1234";
        d = new String (new char[]{'H', 'e', 'l', 'l', 'o', '1', '2', '3', '4'});
        System.out.print (a == b);
        System.out.print (" ");
        System.out.print (a.equals(b));
        System.out.print (" ");
        System.out.print (a == c);
        System.out.print ("  ");
        System.out.print (a.equals(c));
        System.out.print (" ");
        System.out.print (a == d);
        System.out.print (" ");
        System.out.print (a.equals(d));
        System.out.print (" ");
    }
}
class Animal {
    public int a = 10;
    public void sayIt(){
    }
}
class Dog extends Animal{
    public int  a= 11;
    public void sayIt(){
        System.out.println("I am Dog");
    }
}
class Cat extends Animal{
    public void sayIt(){
        System.out.println("I am Cat");
    }
}
class Hospital{
    public void treatAnimal(Animal a) {
        if (a instanceof Dog) {
            a.sayIt();
        } else {
            a.sayIt();
        }
    }
}
public class CatApplication extends Cat {


    public static void main(String[] args) {
        Cat tom = new Cat("Anh","Tôm",1,2,10);
        Cat doremon = new Cat("Japan",10);
        Cat kitty = new Cat();
        CatApplication catApplication = new CatApplication();
        catApplication.showInformation();
        catApplication.setName("12323");

        System.out.println("Truy xuất thuộc tính name của Cat : " + tom.name);
        System.out.println("____________________");
        tom.showInformation();
        System.out.println("____________________");
        doremon.showInformation();
        System.out.println("____________________");
        kitty.showInformation();
        System.out.println("______EAT____");
        tom.eat(1);
        kitty.eat(1);
        doremon.eat(2);
        tom.getWeight();
    }
}

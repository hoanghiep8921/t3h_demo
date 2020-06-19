public class Cat extends Animals{
    private String original;
    protected String name;
    private int age;
    private int weight;
    private int speed;

    public Cat() {
    }

    public Cat(String original, String name, int age, int weight, int speed) {
        this.original = original;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.speed = speed;
    }

    public Cat(String original, int weight) {
        this.original = original;
        this.weight = weight;
    }

    void sleep(){
        System.out.println("Con mèo " + name + " đang ngủ");
    }
    void eat(int food){
        weight += food;
        System.out.println("Con mèo " + name + " nặng " +weight+ "kg");
    }
    int jump(){
        System.out.println("Nhảy nhảy nhảy");
        return speed;
    }

    void showInformation(){
        System.out.println("Name : " + name);
        System.out.println("Age : " + age);
        System.out.println("Speed : " + speed);
        System.out.println("Original : " + original);
        System.out.println("Weight : " + weight);
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}

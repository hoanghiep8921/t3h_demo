package exercise;

public class Boxer {
    private String name;
    private int hp;
    private int damage;

    public void fight(Boxer anotherBoxer){
        System.out.println("____Người đấm____");
        this.showHeath();
        int currentHPAntherBoxer = anotherBoxer.getHp();
        anotherBoxer.setHp(currentHPAntherBoxer - this.damage);
        System.out.println("____Người bị đấm____");
        anotherBoxer.showHeath();
    }

    public void showHeath(){
        System.out.println(this.name + " => HP : " + this.hp);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}

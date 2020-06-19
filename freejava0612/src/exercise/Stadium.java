package exercise;

public class Stadium {
    public static void main(String[] args) {
        Boxer trump = new Boxer();
        trump.setHp(100);
        trump.setName("Donal Trump");
        trump.setDamage(20);

        Boxer billaden = new Boxer();
        billaden.setDamage(25);
        billaden.setName("Billaden");
        billaden.setHp(100);
        int round = 0;
        while(billaden.getHp() > 0 && trump.getHp() > 0){
            System.out.println("Round :" + (round + 1));
            //trump thực hiện đấm billaden
            if(round % 2 == 0){
                trump.fight(billaden);
            }else{
                billaden.fight(trump);
            }

            round++;
        }
    }
}

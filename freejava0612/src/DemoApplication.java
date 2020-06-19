public class DemoApplication {
    static int year = 10;
    static long number = 1000;

    boolean isSuccess = true;
    float flt = 0.2f;
    char c = '5';
    String str = "This is string";

    static int sumTwoNumber(int number1,int number2){
        int result = number1 + number2;
        return result;
    }
    static int minusTwoNumber(int number1,int number2){
        return number1+number2;
    }

    public static void main(String[] args) {
        System.out.println("Hello free java");
        System.out.println(
                "Thử cộng 2 biến : " + (year  + number));
        int total = sumTwoNumber(5,10);
        System.out.println("Tính tổng :" + total);

        long maxValue = Integer.MAX_VALUE;
        maxValue++;
        System.out.println(maxValue);
    }

}

public class Main {
    public static void main(String[] args) {
        int computerMove = (int) Math.floor(Math.random() * 10) % 9 + 1;
        System.out.println(computerMove);
    }
}
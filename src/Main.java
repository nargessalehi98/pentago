import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        int rand = random.nextInt(2);
        String red = "  🔴  ";
        String black = "  ⚫  ";
        Map map = new Map();
        map.print();
        if (rand == 0) {
            while (true) {
                map.putDisk(red);
                map.print();
                if (map.checkWinner(red)) {
                    System.out.println("\nRed is winner !");
                    break;
                }
                map.rotate();
                map.print();
                if (map.checkWinner(red) && map.checkWinner(black)) {
                    System.out.println("\nequal!");
                    break;
                }else if(map.checkWinner(red)){
                    System.out.println("\nRed is winner !");
                    break;
                }
                else if(map.checkWinner(black)){
                    System.out.println("\nblack is winner !");
                    break;
                }
                map.putDisk(black);
                map.print();
                if (map.checkWinner(black)) {
                    System.out.println("\nblack is winner !");
                    break;
                }
                map.rotate();
                map.print();
                if (map.checkWinner(red) && map.checkWinner(black)) {
                    System.out.println("\nequal!");
                    break;
                }else if(map.checkWinner(red)){
                    System.out.println("\nRed is winner !");
                    break;
                }
                else if(map.checkWinner(black)){
                    System.out.println("\nblack is winner !");
                    break;
                }

            }
        } else {
            while (true) {
                map.putDisk(black);
                map.print();
                if (map.checkWinner(black)) {
                    System.out.println("\nblack is winner !");
                    break;
                }
                map.rotate();
                map.print();
                if (map.checkWinner(red) && map.checkWinner(black)) {
                    System.out.println("\nequal!");
                    break;
                }else if(map.checkWinner(red)){
                    System.out.println("\nRed is winner !");
                    break;
                }
                else if(map.checkWinner(black)){
                    System.out.println("\nblack is winner !");
                    break;
                }
                map.putDisk(red);
                map.print();
                if (map.checkWinner(red)) {
                    System.out.println("\nRed is winner !");
                    break;
                }
                map.rotate();
                map.print();
                if (map.checkWinner(red) && map.checkWinner(black)) {
                    System.out.println("\nequal!");
                    break;
                }else if(map.checkWinner(red)){
                    System.out.println("\nRed is winner !");
                    break;
                }
                else if(map.checkWinner(black)){
                    System.out.println("\nblack is winner !");
                    break;
                }
            }
        }
    }
}

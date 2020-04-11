import java.util.Random;

/**
 * run whole game
 *
 * @author Narges Salehi
 */
public class Main {

    public static void main(String[] args) {
        //creat a random number to set random color for player
        Random random = new Random();
        int rand = random.nextInt(2);
        //color of player
        String red = "  🔴  ";
        String black = "  ⚫  ";
        //creat a new game
        GameRules game = new GameRules();
        game.print();
        if (rand == 0) {
            //start game
            while (true) {
                game.putDisk(red);
                game.print();
                //check wining condition
                if (game.checkWinner(red)) {
                    System.out.println("\nRed is winner !");
                    break;
                }
                //rotate
                game.rotate();
                game.print();
                //check wining condition
                if (game.checkWinner(red) && game.checkWinner(black)) {
                    System.out.println("\nequal!");
                    break;
                } else if (game.checkWinner(red)) {
                    System.out.println("\nRed is winner !");
                    break;
                } else if (game.checkWinner(black)) {
                    System.out.println("\nblack is winner !");
                    break;
                }
                //same for next player
                game.putDisk(black);
                game.print();
                if (game.checkWinner(black)) {
                    System.out.println("\nblack is winner !");
                    break;
                }
                game.rotate();
                game.print();
                if (game.checkWinner(red) && game.checkWinner(black)) {
                    System.out.println("\nequal!");
                    break;
                } else if (game.checkWinner(red)) {
                    System.out.println("\nRed is winner !");
                    break;
                } else if (game.checkWinner(black)) {
                    System.out.println("\nblack is winner !");
                    break;
                }

            }
        } else {
            while (true) {
                game.putDisk(black);
                game.print();
                if (game.checkWinner(black)) {
                    System.out.println("\nblack is winner !");
                    break;
                }
                game.rotate();
                game.print();
                if (game.checkWinner(red) && game.checkWinner(black)) {
                    System.out.println("\nequal!");
                    break;
                } else if (game.checkWinner(red)) {
                    System.out.println("\nRed is winner !");
                    break;
                } else if (game.checkWinner(black)) {
                    System.out.println("\nblack is winner !");
                    break;
                }
                game.putDisk(red);
                game.print();
                if (game.checkWinner(red)) {
                    System.out.println("\nRed is winner !");
                    break;
                }
                game.rotate();
                game.print();
                if (game.checkWinner(red) && game.checkWinner(black)) {
                    System.out.println("\nequal!");
                    break;
                } else if (game.checkWinner(red)) {
                    System.out.println("\nRed is winner !");
                    break;
                } else if (game.checkWinner(black)) {
                    System.out.println("\nblack is winner !");
                    break;
                }
            }
        }
    }
}

import java.util.ArrayList;
import java.util.Scanner;

/**
 * provide game rules
 * @author  Narges Salehi
 */
public class GameRules {
    //map of game
    private Map map;

    /**
     * creat new game rules
     */
    public GameRules() {
        map = new Map();
    }

    /**
     * check all the lines with wining condition for a player - check circles color
     * @param Color of player
     * @return true or false
     */
    public boolean checkWinner(String Color) {
        // count lines with wining condition
        int counter = 0;
        // check horizontal and vertical lines
        counter += map.checkLine(0, 1, 2, 0, 1, map.getSquare(1), map.getSquare(2), Color);
        counter += map.checkLine(2, 1, 0, 2, 1, map.getSquare(2), map.getSquare(1), Color);
        counter += map.checkLine(3, 4, 5, 3, 4, map.getSquare(1), map.getSquare(2), Color);
        counter += map.checkLine(5, 4, 3, 5, 4, map.getSquare(2), map.getSquare(1), Color);
        counter += map.checkLine(6, 7, 8, 6, 7, map.getSquare(1), map.getSquare(2), Color);
        counter += map.checkLine(8, 7, 6, 7, 8, map.getSquare(2), map.getSquare(1), Color);

        counter += map.checkLine(0, 3, 6, 0, 3, map.getSquare(1), map.getSquare(3), Color);
        counter += map.checkLine(6, 3, 0, 6, 3, map.getSquare(3), map.getSquare(1), Color);
        counter += map.checkLine(1, 4, 7, 1, 4, map.getSquare(1), map.getSquare(3), Color);
        counter += map.checkLine(7, 4, 1, 7, 4, map.getSquare(3), map.getSquare(1), Color);
        counter += map.checkLine(2, 5, 8, 2, 5, map.getSquare(1), map.getSquare(3), Color);
        counter += map.checkLine(8, 5, 2, 8, 5, map.getSquare(3), map.getSquare(1), Color);

        counter += map.checkLine(0, 1, 2, 0, 1, map.getSquare(3), map.getSquare(4), Color);
        counter += map.checkLine(2, 1, 0, 2, 1, map.getSquare(4), map.getSquare(3), Color);
        counter += map.checkLine(3, 4, 5, 3, 4, map.getSquare(3), map.getSquare(4), Color);
        counter += map.checkLine(5, 4, 3, 5, 4, map.getSquare(4), map.getSquare(3), Color);
        counter += map.checkLine(6, 7, 8, 6, 7, map.getSquare(3), map.getSquare(4), Color);
        counter += map.checkLine(8, 7, 6, 7, 8, map.getSquare(4), map.getSquare(3), Color);

        counter += map.checkLine(0, 3, 6, 0, 3, map.getSquare(2), map.getSquare(4), Color);
        counter += map.checkLine(6, 3, 0, 6, 3, map.getSquare(4), map.getSquare(2), Color);
        counter += map.checkLine(1, 4, 7, 1, 4, map.getSquare(2), map.getSquare(4), Color);
        counter += map.checkLine(7, 4, 1, 7, 4, map.getSquare(4), map.getSquare(2), Color);
        counter += map.checkLine(2, 5, 8, 2, 5, map.getSquare(2), map.getSquare(4), Color);
        counter += map.checkLine(8, 5, 2, 8, 5, map.getSquare(4), map.getSquare(2), Color);

        counter += map.checkLine(2, 4, 6, 2, 4, map.getSquare(2), map.getSquare(3), Color);
        counter += map.checkLine(6, 4, 2, 6, 4, map.getSquare(3), map.getSquare(2), Color);
        counter += map.checkLine(0, 4, 8, 0, 4, map.getSquare(1), map.getSquare(4), Color);
        counter += map.checkLine(8, 4, 0, 8, 4, map.getSquare(4), map.getSquare(1), Color);

        // check diagonal lines
        if (map.getSquare(2).get(1).equals(map.getSquare(2).get(3)) && map.getSquare(2).get(1).equals(map.getSquare(1).get(8)) &&
                map.getSquare(2).get(1).equals(map.getSquare(3).get(1)) && map.getSquare(2).get(1).equals(map.getSquare(3).get(3))) {
            if (map.getSquare(2).get(1).equals(Color))
                counter += 1;
        }
        if (map.getSquare(2).get(5).equals(map.getSquare(2).get(7)) && map.getSquare(2).get(5).equals(map.getSquare(4).get(0)) &&
                map.getSquare(2).get(5).equals(map.getSquare(3).get(5)) && map.getSquare(2).get(5).equals(map.getSquare(3).get(7))) {
            if (map.getSquare(2).get(5).equals(Color))
                counter += 1;
        }
        if (map.getSquare(1).get(1).equals(map.getSquare(1).get(5)) && map.getSquare(1).get(1).equals(map.getSquare(2).get(6)) &&
                map.getSquare(1).get(1).equals(map.getSquare(4).get(1)) && map.getSquare(1).get(1).equals(map.getSquare(4).get(5))) {
            if (map.getSquare(1).get(1).equals(Color))
                counter += 1;
        }
        if (map.getSquare(1).get(3).equals(map.getSquare(1).get(7)) && map.getSquare(1).get(3).equals(map.getSquare(3).get(2)) &&
                map.getSquare(1).get(3).equals(map.getSquare(4).get(3)) && map.getSquare(1).get(3).equals(map.getSquare(4).get(7))) {
            if (map.getSquare(1).get(3).equals(Color))
                counter += 1;
        }

        return counter > 0;
    }


    /**
     * rotate given square with given direction
     * @param numberOfSquare number of Array list
     * @param direction of rotate
     */
    public void rotateSquare(int numberOfSquare, String direction) {
        //clockwise
        if (direction.equals("C")) {
            //creat a new array list
            ArrayList<String> temp = new ArrayList<String>();
            //add each circle of map after rotating in temp
            temp.add(0, map.getSquare(numberOfSquare).get(6));
            temp.add(1, map.getSquare(numberOfSquare).get(3));
            temp.add(2, map.getSquare(numberOfSquare).get(0));
            temp.add(3, map.getSquare(numberOfSquare).get(7));
            temp.add(4, map.getSquare(numberOfSquare).get(4));
            temp.add(5, map.getSquare(numberOfSquare).get(1));
            temp.add(6, map.getSquare(numberOfSquare).get(8));
            temp.add(7, map.getSquare(numberOfSquare).get(5));
            temp.add(8, map.getSquare(numberOfSquare).get(2));
            //set temp to given square
            map.setSquare(temp, numberOfSquare);
        }//non-clockwise
        if (direction.equals("NC")) {
            ArrayList<String> temp = new ArrayList<String>();
            temp.add(0, map.getSquare(numberOfSquare).get(2));
            temp.add(1, map.getSquare(numberOfSquare).get(5));
            temp.add(2, map.getSquare(numberOfSquare).get(8));
            temp.add(3, map.getSquare(numberOfSquare).get(1));
            temp.add(4, map.getSquare(numberOfSquare).get(4));
            temp.add(5, map.getSquare(numberOfSquare).get(7));
            temp.add(6, map.getSquare(numberOfSquare).get(0));
            temp.add(7, map.getSquare(numberOfSquare).get(3));
            temp.add(8, map.getSquare(numberOfSquare).get(6));
            map.setSquare(temp, numberOfSquare);
        }
    }

    /**
     * rotate square in map
     */
    public void rotate() {
        //check if there is an empty square skip rotating
        if (map.isEmpty()) {
            System.out.println("\nThere is at least one Empty Square ,You can Skip rotating by Entering skip else Enter anything :");
            Scanner scanner1 = new Scanner(System.in);
            String skip = scanner1.next();
            if (!(skip.equals("skip"))) {
                System.out.print("Enter number of square and rotate direction like 1 C :");
                rotateCheck();
            }
        } else {
            System.out.print("\nEnter number of square and rotate direction like 1 C :");
            rotateCheck();
        }
    }

    /**
     * check direction and square number for rotating
     */
    private void rotateCheck() {
        Scanner scanner2 = new Scanner(System.in);
        int square = scanner2.nextInt();
        String dir = scanner2.next();
        if (square == 1) {
            rotateSquare(1, dir);
        } else if (square == 2) {
            rotateSquare(2, dir);

        } else if (square == 3) {
            rotateSquare(3, dir);
        } else if (square == 4) {
            rotateSquare(4, dir);
        }
    }

    /**
     * put disk in map for player with given color
     * @param Color of player
     */
    public void putDisk(String Color) {
        System.out.println("\nEnter the number of square and circle :");
        Scanner scanner = new Scanner(System.in);
        int square = scanner.nextInt();
        int circle = scanner.nextInt();
        if (square > 4 || square < 1 || circle > 9 || circle < 1)
            putDisk(Color);
        else {
            if (square == 1) {
                if (map.getSquare(1).get(circle - 1).equals("  ⚪  ")) {
                    map.getSquare(1).remove(circle - 1);
                    map.getSquare(1).add(circle - 1, Color);
                } else {
                    System.out.println("Already taken");
                    putDisk(Color);
                }
            }
            if (square == 2) {
                if (map.getSquare(2).get(circle - 1).equals("  ⚪  ")) {
                    map.getSquare(2).remove(circle - 1);
                    map.getSquare(2).add(circle - 1, Color);
                } else {
                    System.out.println("Already taken");
                    putDisk(Color);
                }
            }
            if (square == 3) {
                if (map.getSquare(3).get(circle - 1).equals("  ⚪  ")) {
                    map.getSquare(3).remove(circle - 1);
                    map.getSquare(3).add(circle - 1, Color);
                } else {
                    System.out.println("Already taken");
                    putDisk(Color);
                }
            }
            if (square == 4) {
                if (map.getSquare(4).get(circle - 1).equals("  ⚪  ")) {
                    map.getSquare(4).remove(circle - 1);
                    map.getSquare(4).add(circle - 1, Color);
                } else {
                    System.out.println("Already taken");
                    putDisk(Color);
                }
            }
        }
    }

    /**
     * print map after applying rules
     */
    public void print() {
        map.print();
    }
}

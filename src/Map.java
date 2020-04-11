import java.util.ArrayList;

/**
 * this class provide map info and applications - board game
 *
 * @author Narges Salehi
 */
public class Map {
    //4 Array list for each square of board game
    private ArrayList<String> square1;
    private ArrayList<String> square2;
    private ArrayList<String> square3;
    private ArrayList<String> square4;

    /**
     * creat a new map for board game
     */
    public Map() {
        //defining map with empty value
        square1 = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            square1.add("  ⚪  ");
        }
        square2 = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            square2.add("  ⚪  ");
        }
        square3 = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            square3.add("  ⚪  ");
        }
        square4 = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            square4.add("  ⚪  ");
        }

    }

    /**
     * check given line(horizontal and vertical only) of map that allows player to win - provide game wining rule
     * @param main start point of line
     * @param a next disk on the line
     * @param b next disk on the line
     * @param c next disk on the line
     * @param d next disk on the line
     * @param one a square that contains start point of line
     * @param two  a square that contains finish point of line
     * @param Color color of player
     * @return number of line with given condition of wining
     */
    public int checkLine(int main, int a, int b, int c, int d, ArrayList<String> one, ArrayList<String> two, String Color) {
        //count to one if the line has the condition of wining
        int counter = 0;
        //check color of 5 disk in line
        if (one.get(main).equals(one.get(a)) && one.get(main).equals(one.get(b)) && one.get(main).equals(two.get(c))
                && one.get(main).equals(two.get(d))) {
            if (one.get(main).equals(Color))
                counter++;
        }
        return counter;
    }


    /**
     * return square with given number
     * @param num of square
     * @return Array list
     */
    public ArrayList<String> getSquare(int num) {
        if (num == 1)
            return square1;
        if (num == 2)
            return square2;
        if (num == 3)
            return square3;
        if (num == 4)
            return square4;
        else
            return null;
    }

    /**
     * set given Array list to given square
     * @param temp given array list
     * @param num of square
     */
    public void setSquare(ArrayList<String> temp, int num) {
        if (num == 1)
            square1 = temp;
        if (num == 2)
            square2 = temp;
        if (num == 3)
            square3 = temp;
        if (num == 4)
            square4 = temp;
    }

    /**
     * check if there is an empty square
     * @return true of false
     */
    public boolean isEmpty() {
        //check square to find an empty square - if preset square is not empty check out next square else return true
        boolean check = true;
        for (String circle1 : square1) {
            if (!(circle1.equals("  ⚪  "))) {
                for (String circle2 : square2) {
                    if (!(circle2.equals("  ⚪  "))) {
                        for (String circle3 : square3) {
                            if (!(circle3.equals("  ⚪  "))) {
                                for (String circle : square4) {
                                    if (!(circle.equals("  ⚪  "))) {
                                        check=false;
                                        return check;
                                    }
                                }
                            } else
                                return check;
                        }
                    }
                    else
                         return check;
                }
            }
            else
                return check;
        }
        return false;
    }

    /**
     * print map of game
     */
    public void print() {
        System.out.println("Square 1                    Square 2");
        printSquares(square1, square2);
        System.out.println("  ==    ==    ==     ==    ==   == ");
        printSquares(square3, square4);
        System.out.print("Square 3                   Square 4");
    }

    /**
     * print neighbor squares in a line
     * @param square1 left square
     * @param square2 right square
     */
    private void printSquares(ArrayList<String> square1, ArrayList<String> square2) {
        for (int i = 0; i < 9; i++) {
            if (i == 2 || i == 5 || i == 8) {
                System.out.print(square1.get(i) + "‖");
                if (i == 2) {
                    System.out.println(square2.get(0) + square2.get(1) + square2.get(2));
                    System.out.println();
                }
                if (i == 5) {
                    System.out.println(square2.get(3) + square2.get(4) + square2.get(5));
                    System.out.println();
                }
                if (i == 8)
                    System.out.println(square2.get(6) + square2.get(7) + square2.get(8));
            } else
                System.out.print(square1.get(i));
        }
    }

}
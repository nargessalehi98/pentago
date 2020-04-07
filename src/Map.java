import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Map {
    private ArrayList<String> square1;
    private ArrayList<String> square2;
    private ArrayList<String> square3;
    private ArrayList<String> square4;
    String red = "  🔴  ";
    String black = "  ⚫  ";

    public Map() {
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

    public int checkLine(int main, int a, int b, int c, int d, ArrayList one, ArrayList two, String Color) {
        int counter = 0;
        if (one.get(main).equals(one.get(a)) && one.get(main).equals(one.get(b)) && one.get(main).equals(two.get(c))
                && one.get(main).equals(two.get(d))) {
            if (one.get(main).equals(Color))
                counter++;
        }
        return counter;
    }

    public boolean checkWinner(String Color) {
        int counter = 0;
        counter += checkLine(0, 1, 2, 0, 1, square1, square2, Color);
        counter += checkLine(2, 1, 0, 2, 1, square2, square1, Color);
        counter += checkLine(3, 4, 5, 3, 4, square1, square2, Color);
        counter += checkLine(5, 4, 3, 5, 4, square2, square1, Color);
        counter += checkLine(6, 7, 8, 6, 7, square1, square2, Color);
        counter += checkLine(8, 7, 6, 7, 8, square2, square1, Color);

        counter += checkLine(0, 3, 6, 0, 3, square1, square3, Color);
        counter += checkLine(6, 3, 0, 6, 3, square3, square1, Color);
        counter += checkLine(1, 4, 7, 1, 4, square1, square3, Color);
        counter += checkLine(7, 4, 1, 7, 4, square3, square1, Color);
        counter += checkLine(2, 5, 8, 2, 5, square1, square3, Color);
        counter += checkLine(8, 5, 2, 8, 5, square3, square1, Color);

        counter += checkLine(0, 1, 2, 0, 1, square3, square4, Color);
        counter += checkLine(2, 1, 0, 2, 1, square4, square3, Color);
        counter += checkLine(3, 4, 5, 3, 4, square3, square4, Color);
        counter += checkLine(5, 4, 3, 5, 4, square4, square3, Color);
        counter += checkLine(6, 7, 8, 6, 7, square3, square4, Color);
        counter += checkLine(8, 7, 6, 7, 8, square4, square3, Color);

        counter += checkLine(0, 3, 6, 0, 3, square2, square4, Color);
        counter += checkLine(6, 3, 0, 6, 3, square4, square2, Color);
        counter += checkLine(1, 4, 7, 1, 4, square2, square4, Color);
        counter += checkLine(7, 4, 1, 7, 4, square4, square2, Color);
        counter += checkLine(2, 5, 8, 2, 5, square2, square4, Color);
        counter += checkLine(8, 5, 2, 8, 5, square4, square2, Color);

        counter += checkLine(2, 4, 6, 2, 4, square2, square3, Color);
        counter += checkLine(6, 4, 2, 6, 4, square3, square2, Color);
        counter += checkLine(0, 4, 8, 0, 4, square1, square4, Color);
        counter += checkLine(8, 4, 0, 8, 4, square4, square1, Color);

        if (square2.get(1).equals(square2.get(3)) && square2.get(1).equals(square1.get(8)) &&
                square2.get(1).equals(square3.get(1)) && square2.get(1).equals(square3.get(3))) {
            if (square2.get(1).equals(Color))
                counter += 1;
        }
        if (square2.get(5).equals(square2.get(7)) && square2.get(5).equals(square4.get(0)) &&
                square2.get(5).equals(square3.get(5)) && square2.get(5).equals(square3.get(7))) {
            if (square2.get(5).equals(Color))
                counter += 1;
        }
        if (square1.get(1).equals(square1.get(5)) && square1.get(1).equals(square2.get(6)) &&
                square1.get(1).equals(square4.get(1)) && square1.get(1).equals(square4.get(5))) {
            if (square1.get(1).equals(Color))
                counter += 1;
        }
        if (square1.get(3).equals(square1.get(7)) && square1.get(3).equals(square3.get(2)) &&
                square1.get(3).equals(square4.get(3)) && square1.get(3).equals(square4.get(7))) {
            if (square1.get(3).equals(Color))
                counter += 1;
        }

        return counter > 0;
    }

    public void rotate() {
        System.out.println("\nEnter number of square and rotate direction like 1 C :");
        Scanner scanner1 = new Scanner(System.in);
        int square = scanner1.nextInt();
        String dir = scanner1.next();
        if (square == 1) {
            if (dir.equals("C")) {
                ArrayList<String> temp = new ArrayList();
                temp.add(0, square1.get(6));
                temp.add(1, square1.get(3));
                temp.add(2, square1.get(0));
                temp.add(3, square1.get(7));
                temp.add(4, square1.get(4));
                temp.add(5, square1.get(1));
                temp.add(6, square1.get(8));
                temp.add(7, square1.get(5));
                temp.add(8, square1.get(2));
                square1 = temp;
            }
            if (dir.equals("NC")) {
                ArrayList<String> temp = new ArrayList();
                temp.add(0, square1.get(2));
                temp.add(1, square1.get(5));
                temp.add(2, square1.get(8));
                temp.add(3, square1.get(1));
                temp.add(4, square1.get(4));
                temp.add(5, square1.get(7));
                temp.add(6, square1.get(0));
                temp.add(7, square1.get(3));
                temp.add(8, square1.get(6));
                square1 = temp;
            }
        } else if (square == 2) {
            if (dir.equals("C")) {
                ArrayList<String> temp = new ArrayList();
                temp.add(0, square2.get(6));
                temp.add(1, square2.get(3));
                temp.add(2, square2.get(0));
                temp.add(3, square2.get(7));
                temp.add(4, square2.get(4));
                temp.add(5, square2.get(1));
                temp.add(6, square2.get(8));
                temp.add(7, square2.get(5));
                temp.add(8, square2.get(2));
                square2 = temp;
            }
            if (dir.equals("NC")) {
                ArrayList<String> temp = new ArrayList();
                temp.add(0, square2.get(2));
                temp.add(1, square2.get(5));
                temp.add(2, square2.get(8));
                temp.add(3, square2.get(1));
                temp.add(4, square2.get(4));
                temp.add(5, square2.get(7));
                temp.add(6, square2.get(0));
                temp.add(7, square2.get(3));
                temp.add(8, square2.get(6));
                square2 = temp;
            }

        } else if (square == 3) {
            if (dir.equals("C")) {
                ArrayList<String> temp = new ArrayList();
                temp.add(0, square3.get(6));
                temp.add(1, square3.get(3));
                temp.add(2, square3.get(0));
                temp.add(3, square3.get(7));
                temp.add(4, square3.get(4));
                temp.add(5, square3.get(1));
                temp.add(6, square3.get(8));
                temp.add(7, square3.get(5));
                temp.add(8, square3.get(2));
                square3 = temp;
            }
            if (dir.equals("NC")) {
                ArrayList<String> temp = new ArrayList();
                temp.add(0, square3.get(2));
                temp.add(1, square3.get(5));
                temp.add(2, square3.get(8));
                temp.add(3, square3.get(1));
                temp.add(4, square3.get(4));
                temp.add(5, square3.get(7));
                temp.add(6, square3.get(0));
                temp.add(7, square3.get(3));
                temp.add(8, square3.get(6));
                square3 = temp;
            }
        } else if (square == 4) {
            if (dir.equals("C")) {
                ArrayList<String> temp = new ArrayList();
                temp.add(0, square4.get(6));
                temp.add(1, square4.get(3));
                temp.add(2, square4.get(0));
                temp.add(3, square4.get(7));
                temp.add(4, square4.get(4));
                temp.add(5, square4.get(1));
                temp.add(6, square4.get(8));
                temp.add(7, square4.get(5));
                temp.add(8, square4.get(2));
                square4 = temp;
            }
            if (dir.equals("NC")) {
                ArrayList<String> temp = new ArrayList();
                temp.add(0, square4.get(2));
                temp.add(1, square4.get(5));
                temp.add(2, square4.get(8));
                temp.add(3, square4.get(1));
                temp.add(4, square4.get(4));
                temp.add(5, square4.get(7));
                temp.add(6, square4.get(0));
                temp.add(7, square4.get(3));
                temp.add(8, square4.get(6));
                square4 = temp;
            }
        }
    }

    public void putDisk(String Color) {
        System.out.println("\nEnter the number of square and circle :");
        Scanner scanner = new Scanner(System.in);
        int square = scanner.nextInt();
        int circle = scanner.nextInt();
        if (square > 4 || square < 1 || circle > 9 || circle < 1)
            putDisk(Color);
        else {
            if (square == 1) {
                if (square1.get(circle - 1).equals("  ⚪  ")) {
                    square1.remove(circle - 1);
                    square1.add(circle - 1, Color);
                } else {
                    System.out.println("Already taken");
                    putDisk(Color);
                }
            }
            if (square == 2) {
                if (square2.get(circle - 1).equals("  ⚪  ")) {
                    square2.remove(circle - 1);
                    square2.add(circle - 1, Color);
                } else {
                    System.out.println("Already taken");
                    putDisk(Color);
                }
            }
            if (square == 3) {
                if (square3.get(circle - 1).equals("  ⚪  ")) {
                    square3.remove(circle - 1);
                    square3.add(circle - 1, Color);
                } else {
                    System.out.println("Already taken");
                    putDisk(Color);
                }
            }
            if (square == 4) {
                if (square4.get(circle - 1).equals("  ⚪  ")) {
                    square4.remove(circle - 1);
                    square4.add(circle - 1, Color);
                } else {
                    System.out.println("Already taken");
                    putDisk(Color);
                }
            }
        }
    }

    public void print() {
        System.out.println("Square 1                    Square 2");
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
        System.out.println("  ==    ==    ==     ==    ==   == ");
        for (int i = 0; i < 9; i++) {
            if (i == 2 || i == 5 || i == 8) {
                System.out.print(square3.get(i) + "‖");
                if (i == 2) {
                    System.out.println(square4.get(0) + square4.get(1) + square4.get(2));
                    System.out.println();
                }
                if (i == 5) {
                    System.out.println(square4.get(3) + square4.get(4) + square4.get(5));
                    System.out.println();
                }
                if (i == 8)
                    System.out.println(square4.get(6) + square4.get(7) + square4.get(8));
            } else
                System.out.print(square3.get(i));
        }
        System.out.print("Square 3                   Square 4");
    }
}
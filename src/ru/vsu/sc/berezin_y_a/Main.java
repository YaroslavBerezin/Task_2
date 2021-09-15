package ru.vsu.sc.berezin_y_a;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        compareBoxes();

    }

    public static void compareBoxes() {

        System.out.println("Enter sizes of the first box: ");
        System.out.print("X: ");
        int x1 = readNum();
        System.out.print("Y: ");
        int y1 = readNum();
        System.out.print("Z: ");
        int z1 = readNum();

        System.out.println("Enter sizes of the second box: ");
        System.out.print("X: ");
        int x2 = readNum();
        System.out.print("Y: ");
        int y2 = readNum();
        System.out.print("Z: ");
        int z2 = readNum();

        if (((x1 > x2) && (y1 > y2) && (z1 > z2)) || ((x1 > x2) && (y1 > z2) && (z1 > y2)) || ((y1 > y2) && (x1 > z2) && (z1 > x2)) || ((z1 > z2) && (x1 > y2) && (y1 > x2))) {
            System.out.println("The second box is placed in the first");
        } else if (((x2 > x1) && (y2 > y1) && (z2 > z1)) || ((x2 > x1) && (y2 > z1) && (z2 > y1)) || ((y2 > y1) && (x2 > z1) && (z2 > x1)) || ((z2 > z1) && (x2 > y1) && (y2 > x1))) {
            System.out.println("The first box is placed in the second");
        } else {
            System.out.println("It's impossible to place one box in another");
        }

    }

    public static int readNum() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

}
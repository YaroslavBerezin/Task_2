package ru.vsu.sc.berezin_y_a;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        printSomething("Enter sizes of the first box: ");
        int sideX1 = readNum("X: ");
        checkNum(sideX1);
        int sideY1 = readNum("Y: ");
        checkNum(sideY1);
        int sideZ1 = readNum("Z: ");
        checkNum(sideZ1);

        printSomething("Enter sizes of the first box: ");
        int sideX2 = readNum("X: ");
        checkNum(sideX1);
        int sideY2 = readNum("Y: ");
        checkNum(sideY1);
        int sideZ2 = readNum("Z: ");
        checkNum(sideZ1);

        printFinalAnswerOfATask(sideX1, sideY1, sideZ1, sideX2, sideY2, sideZ2);

    }

    public enum states{
        SECONDINFIRST,
        FIRSTINSECOND,
        BOXESAREDIFFERENT;
    }

    static void printSomething(String text) {
        System.out.println(text);
    }

    static int readNum(String text) {
        System.out.print(text);
        Scanner scanner = new Scanner(System.in);
        return (scanner.nextInt());
    }

    static states checkPlacementOfBoxes(int x1, int y1, int z1, int x2, int y2, int z2) {
        if (((x1 > x2) && (y1 > y2) && (z1 > z2)) ||
                ((x1 > x2) && (y1 > z2) && (z1 > y2)) ||
                ((y1 > y2) && (x1 > z2) && (z1 > x2)) ||
                ((z1 > z2) && (x1 > y2) && (y1 > x2))) {
            return (states.SECONDINFIRST);
        } else if (((x2 > x1) && (y2 > y1) && (z2 > z1)) ||
                ((x2 > x1) && (y2 > z1) && (z2 > y1)) ||
                ((y2 > y1) && (x2 > z1) && (z2 > x1)) ||
                ((z2 > z1) && (x2 > y1) && (y2 > x1))) {
            return (states.FIRSTINSECOND);
        } else {
            return (states.BOXESAREDIFFERENT);
        }
    }

    static String getStringKnowingState(states state) {
        if (state == states.SECONDINFIRST) {
            return ("The second box is in the first");
        } else if (state == states.FIRSTINSECOND) {
            return ("The first box is in the second");
        } else {
            return ("Boxes are different");
        }
    }

    static void checkNum(int num) {
        if (num < 0) {
            System.out.println("Error, the side can't be less than 0");
            System.exit(0);
        }
    }

    static void printFinalAnswerOfATask(int x1, int y1, int z1, int x2, int y2, int z2) {
        printSomething(getStringKnowingState(checkPlacementOfBoxes(x1, y1, z1, x2, y2, z2)));
    }

}
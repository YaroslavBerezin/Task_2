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

        states state = checkPlacementOfBoxes(sideX1, sideY1, sideZ1, sideX2, sideY2, sideZ2);

        printStringKnowingState(state);

    }

    private enum states{
        SECONDINFIRST,
        FIRSTINSECOND,
        BOXESAREDIFFERENT;
    }

    private static void printSomething(String text) {
        System.out.println(text);
    }

    private static int readNum(String text) {
        System.out.print(text);
        Scanner scanner = new Scanner(System.in);
        return (scanner.nextInt());
    }

    private static void checkNum(int num) {
        if (num < 0) {
            System.out.println("Error, the side can't be less than 0");
            System.exit(0);
        }
    }

    private static states checkPlacementOfBoxes(int x1, int y1, int z1, int x2, int y2, int z2) {
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

    private static void printStringKnowingState(states state) {
        switch (state) {
            case SECONDINFIRST:
                System.out.println("The second box is in the first");
                break;
            case FIRSTINSECOND:
                System.out.println("The first box is in the second");
                break;
            case BOXESAREDIFFERENT:
                System.out.println("Boxes are different");
                break;
        }
    }

}

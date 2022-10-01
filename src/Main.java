import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int SIZE = 8;
        System.out.println("Введите угол поворота матрицы");
        int angle = scanner.nextInt();
        int ANGLE;
        int[][] colors = new int[SIZE][SIZE];
        int[][] rotatedColors;
        Random random = new Random();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                colors[i][j] = random.nextInt(256);
            }
        }
        switch (angle) {
            case 90 -> ANGLE = 1;
            case 180 -> ANGLE = 2;
            case 270 -> ANGLE = 3;
            default -> {
                System.out.println("Введен неправильный угол!");
                return;
            }
        }
        rotatedColors = colors;
        for (int i = 1; i <= ANGLE; i++) {
            rotatedColors = newMatrixMethod(SIZE, rotatedColors);
        }
        System.out.println("Дана следующая матрица:");
        matrixMethod(SIZE, colors);
        System.out.println("Вывод:");
        matrixMethod(SIZE, rotatedColors);
    }

    public static void matrixMethod(int SIZE, int[][] colors) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.format("%4d", colors[i][j]);
            }
            System.out.println();
        }
    }

    public static int[][] newMatrixMethod(int SIZE, int[][] colors) {
        int[][] rotatedColors = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                rotatedColors[j][i] = colors[SIZE - i - 1][j];
            }
        }
        return rotatedColors;
    }
}
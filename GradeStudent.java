
import java.util.Scanner;

public class GradeStudent {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        begin();
        System.out.println();
        double x=midTerm();
        System.out.println();
        double y= finalTerm();
        System.out.println();
        double z= homework();
        System.out.println();
        report(x, y, z);
    }

    public static void begin() {
        System.out.println("This program reads exam/homework scores and reports your overall course grade.");
    }

    static int weight;

    public static double midTerm() {
        System.out.println("Midterm:");
        do {
            System.out.print("Weight (0-100)? ");
            weight = sc.nextInt();
            if (weight > 0 && weight < 100) {
                break;
            }
            System.out.println("Wrong weight! Try again.");
        } while (true);
        System.out.print("Score earned? ");
        int score = sc.nextInt();
        System.out.print("Were scores shifted (1=yes, 2=no)? ");
        int chose = sc.nextInt();
        int totalScore, shiftScore = 0;
        if (chose == 1) {
            System.out.print("Shift amount? ");
            shiftScore = sc.nextInt();
        }
        totalScore = score + shiftScore;
        if (totalScore > 100) {
            totalScore = 100;
        }
        System.out.println("Total points = " + totalScore + " / 100");
        double totalWeight = Math.round((double) totalScore / 100 * weight * 10.0) / 10.0;
        System.out.println("Weighted score = " + totalWeight + " / " + weight);
        return totalWeight;
    }

    static int weight1;

    public static double finalTerm() {
        System.out.println("Final:");
        do {
            System.out.print("Weight (0-100)? ");
            weight1 = sc.nextInt();
            if (weight1 < 100 - weight && weight1 > 0) {
                break;
            }
            System.out.println("Wrong weight! Try again.");
        } while (true);
        System.out.print("Score earned? ");
        int score = sc.nextInt();
        System.out.print("Were scores shifted (1=yes, 2=no)? ");
        int chose = sc.nextInt();
        int totalScore, shiftScore = 0;
        if (chose == 1) {
            System.out.print("Shift amount? ");
            shiftScore = sc.nextInt();
        }
        totalScore = score + shiftScore;
        if (totalScore > 100) {
            totalScore = 100;
        }
        System.out.println("Total points = " + totalScore + " / 100");
        double totalWeight = Math.round((double) totalScore / 100 * weight1 * 10.0) / 10.0;
        System.out.println("Weighted score = " + totalWeight + " / " + weight1);
        return totalWeight;
    }

    public static double homework() {
        System.out.println("Homework:");
        int weight2;
        do {
            System.out.print("Weight (0-100)? ");
            weight2 = sc.nextInt();
            if (weight2 == 100 - weight - weight1) {
                break;
            }
            System.out.println("Wrong weight! Try again.");
        } while (true);
        int sum = 0, sumMax = 0;
        System.out.print("Number of assignments? ");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            int x, y;
            do {
                System.out.print("Assignment " + i + " score and max? ");
                x = sc.nextInt();
                y = sc.nextInt();
                if (x <= y && x >= 0 && y != 0) {
                    break;
                }
                System.out.println("Some thing wrong! Try again.");
            } while (true);
            sum = sum + x;
            sumMax = sumMax + y;
        }
        if (sum > 150) {
            sum = 150;
        }
        if (sumMax > 150) {
            sumMax = 150;
        }
        System.out.print("How many sections did you attend? ");
        int attend = sc.nextInt();
        int attendScore = attend * 5;
        if (attendScore > 30) {
            attendScore = 30;
        }
        int totalScore = sum + attendScore;
        int totalScoreMax = sumMax + 30;
        System.out.println("Section points= " + attendScore + " / 30");
        System.out.println("Total points = " + totalScore + " / " + totalScoreMax);
        double weightScore = Math.round((double) totalScore / totalScoreMax * weight2 * 10.0) / 10.0;
        System.out.println("Weighted score = " + weightScore + " / " + weight2);
        return weightScore;
    }

    public static void report(double midTerm, double finalTerm, double homework) {
        double totalWeightScore = midTerm + finalTerm + homework;
        System.out.println("Overall percentage = " + totalWeightScore);
        double GPA;
        if (totalWeightScore < 60) {
            GPA = 0.0;
            System.out.println("Your grade will be at least: " + GPA);
            System.out.println("You are Poor student!");

        } else if (totalWeightScore < 75) {
            GPA = 1.0;
            System.out.println("Your grade will be at least: " + GPA);
            System.out.println("You are Average student!");

        } else if (totalWeightScore < 85) {
            GPA = 2.0;
            System.out.println("Your grade will be at least: " + GPA);
            System.out.println("You are Good student!");

        } else {
            GPA = 3.0;
            System.out.println("Your grade will be at least: " + GPA);
            System.out.println("You are Excellent student!");
        }
    }
}
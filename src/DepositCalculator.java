import java.util.Scanner;

public class DepositCalculator {

    private static double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return roundWithPrecision(pay, 2);
    }

    private static double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return roundWithPrecision(amount + amount * yearRate * depositPeriod, 2);
    }

    private static double roundWithPrecision(double value, int precision) {
        double scale = Math.pow(10, precision);
        return Math.round(value * scale) / scale;
    }

    private static void computeAmountWithPercentInPeriod() {
        int period;
        int action;
        int amount;
        double amountWithPercent;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        if (action == 1) {
            amountWithPercent = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            amountWithPercent = calculateComplexPercent(amount, 0.06, period);
        } else {
            amountWithPercent = 0;
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + amountWithPercent);
    }

    public static void main(String[] args) {
        computeAmountWithPercentInPeriod();
    }
}

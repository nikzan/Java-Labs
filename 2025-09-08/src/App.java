import java.util.Scanner;
import java.util.Random;

public class App {
    
    public int sumLastNums(int x) {
        int lastDigit = x % 10;
        int secondLastDigit = (x / 10) % 10;
        return lastDigit + secondLastDigit;
    }
    
    public boolean isPositive(int x) {
        return x > 0;
    }
    
    public boolean isUpperCase(char x) {
        return x >= 'A' && x <= 'Z';
    }
    
    public boolean isDivisor(int a, int b) {
        return a % b == 0 || b % a == 0;
    }
    
    public int lastNumSum(int a, int b) {
        int lastA = a % 10;
        int lastB = b % 10;
        return lastA + lastB;
    }
    
    public double safeDiv(int x, int y) {
        if (y == 0) {
            return 0;
        }
        return (double) x / y;
    }
    
    public String makeDecision(int x, int y) {
        if (x > y) {
            return x + ">" + y;
        } else if (x < y) {
            return x + "<" + y;
        } else {
            return x + "==" + y;
        }
    }
    
    public boolean sum3(int x, int y, int z) {
        return x + y == z || x + z == y || y + z == x;
    }
    
    public String age(int x) {
        int lastDigit = x % 10;
        int lastTwoDigits = x % 100;
        
        if (lastTwoDigits >= 11 && lastTwoDigits <= 14) {
            return x + " лет";
        } else if (lastDigit == 1) {
            return x + " год";
        } else if (lastDigit >= 2 && lastDigit <= 4) {
            return x + " года";
        } else {
            return x + " лет";
        }
    }
    
    public void printDays(String x) {
        String[] days = {"понедельник", "вторник", "среда", "четверг", "пятница", "суббота", "воскресенье"};
        
        int startIndex = -1;
        for (int i = 0; i < days.length; i++) {
            if (days[i].equals(x)) {
                startIndex = i;
                break;
            }
        }
        
        if (startIndex == -1) {
            System.out.println("это не день недели");
            return;
        }
        
        for (int i = startIndex; i < days.length; i++) {
            System.out.println(days[i]);
        }
    }
    
    public String reverseListNums(int x) {
        String result = "";
        for (int i = x; i >= 0; i--) {
            result += i + " ";
        }
        return result.trim();
    }
    
    public int pow(int x, int y) {
        int result = 1;
        for (int i = 0; i < y; i++) {
            result *= x;
        }
        return result;
    }
    
    public boolean equalNum(int x) {
        if (x < 0) {
            x = -x;
        }
        int firstDigit = x % 10;
        while (x > 0) {
            if (x % 10 != firstDigit) {
                return false;
            }
            x /= 10;
        }
        return true;
    }
    
    public void leftTriangle(int x) {
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    
    public void guessGame(Scanner scanner) {
        Random random = new Random();
        int secretNumber = random.nextInt(10);
        int attempts = 0;
        
        while (true) {
            attempts++;
            int guess;
            if (attempts == 1) {
                guess = safeIntInput(scanner, "Введите число от 0 до 9: ");
            } else {
                guess = safeIntInput(scanner, "Вы не угадали, введите число от 0 до 9: ");
            }
            
            if (guess == secretNumber) {
                System.out.println("Вы угадали!");
                System.out.println("Вы отгадали число за " + attempts + " попытки");
                break;
            }
        }
    }
    
    public int findLast(int[] arr, int x) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == x) {
                return i;
            }
        }
        return -1;
    }
    
    public int[] add(int[] arr, int x, int pos) {
        int[] newArr = new int[arr.length + 1];
        for (int i = 0; i < pos; i++) {
            newArr[i] = arr[i];
        }
        newArr[pos] = x;
        for (int i = pos; i < arr.length; i++) {
            newArr[i + 1] = arr[i];
        }
        return newArr;
    }
    
    public void reverse(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
    }
    
    public int[] concat(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        for (int i = 0; i < arr1.length; i++) {
            result[i] = arr1[i];
        }
        for (int i = 0; i < arr2.length; i++) {
            result[arr1.length + i] = arr2[i];
        }
        return result;
    }
    
    public int[] deleteNegative(int[] arr) {
        int[] temp = new int[arr.length];
        int count = 0;
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                temp[count] = arr[i];
                count++;
            }
        }
        
        int[] result = new int[count];
        for (int i = 0; i < count; i++) {
            result[i] = temp[i];
        }
        return result;
    }
    
    private int safeIntInput(Scanner scanner, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Ошибка ввода! Введите целое число.");
                scanner.nextLine();
            }
        }
    }
}

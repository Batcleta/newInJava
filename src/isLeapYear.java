import java.time.Year;

public class isLeapYear {

    public static void main(String[] args) {
        if (isLeapYear(Year.now().getValue()))
            System.out.println("This year is leap year.");
        else
            System.out.println("This year is not leap year.");


        if (Year.now().isLeap())
            System.out.println("This year is leap year.");
        else
            System.out.println("This year is not leap year.");
    }

    public static boolean isLeapYear(int year) {
        if (year % 4 != 0) {
            return false;
        } else if (year % 100 != 0) {
            return true;
        } else if (year % 400 != 0) {
            return false;
        } else {
            return true;
        }
    }
}

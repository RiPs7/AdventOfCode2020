import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public enum DaysEnum {
    DAY1(Day1.class),
    DAY2(Day2.class),
    DAY3(Day3.class),
    DAY4(Day4.class),
    DAY5(Day5.class),
    DAY6(Day6.class),
    DAY7(Day7.class),
    DAY8(Day8.class);

    private Day day;

    DaysEnum(Class<? extends Day> day) {
        try {
            this.day = day.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            this.day = null;
        }
    }

    void run() {
        try {
            System.out.println("PART 1");
            day.part1();
            System.out.println("PART 2");
            day.part2();
        } catch (IOException ioe) {
            System.err.println("Can't run " + this.day.getClass().getSimpleName());
            ioe.printStackTrace();
        }
    }
}

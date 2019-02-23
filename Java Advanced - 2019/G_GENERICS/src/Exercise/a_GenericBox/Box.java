package Exercise.a_GenericBox;

import java.util.List;

public class Box<T> {
    private T text;

    public Box(T text) {
        this.text = text;
    }

    public static <T extends Comparable<T>> Integer getCount(List<T> list, T element) {
        int count = 0;

        for (T t : list) {
            if (t.compareTo(element) > 0) {
                count++;
            }
        }

        return count;
    }

    @Override
    public String toString() {
        return this.text.getClass().getName() + ": " + this.text;
    }
}

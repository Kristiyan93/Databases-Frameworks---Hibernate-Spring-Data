package Lab.d_ListUtilities;

import java.util.List;
import java.util.stream.Collectors;

public class ListUtils {

    public static <T> T getMax(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException();
        }

        if (list.size() == 1) {
            return list.get(0);
        }

        List<T> collect =  list.stream().sorted().collect(Collectors.toList());

        return collect.get(collect.size() - 1);
    }

    public static <T extends Comparable<T>> T getMin(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException();
        }

        T currentMIn = list.get(0);

        if (list.size() > 1) {
            for (int i = 1; i < list.size(); i++) {
                if (currentMIn.compareTo(list.get(i)) > 0) {
                    currentMIn = list.get(i);
                }
            }
        }

        return currentMIn;
    }
}

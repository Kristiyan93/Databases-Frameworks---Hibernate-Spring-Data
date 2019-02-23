package Lab.d_ListUtilities;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> listUtils = Arrays.asList(1, 2, 0 , 5, 3, 5, 9);

        System.out.println(ListUtils.getMax(listUtils));
        System.out.println(ListUtils.getMin(listUtils));
    }
}

package Lab.b_GenericArrayCreator;

public class Main {
    public static void main(String[] args) {
        /*String[] input = ArrayCreator.create(String.class, 10, "empty");

        int count = 0;

        for (String s : input) {
            System.out.println(count++ + " " + s);
            System.out.println(count);
        }*/

        String[] input2 = ArrayCreator.create(10, "Empty");
        int count = -1;

        for (String s : input2) {
            System.out.println(++count + " " + s);
            System.out.println(count);
        }
    }
}

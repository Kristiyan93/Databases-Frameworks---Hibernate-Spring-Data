package Lab.c_GenericScale;

public class Main {
    public static void main(String[] args) {
        Scale<Integer> integerScale = new Scale<>(7, 5);

        System.out.println(integerScale.getHeavier());
    }
}

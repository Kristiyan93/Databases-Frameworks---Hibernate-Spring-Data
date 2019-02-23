package Lab.a_JarOfT;

public class Main {
    public static void main(String[] args) {
        Jar<String> jar = new Jar<>();

        jar.add("first");
        jar.add("second");


        System.out.println(jar.remove());
    }
}

public class main {
    public static void main(String[] args) {
        a<String> cs1 = new a("Hello");
        String str = cs1.getT();
        System.out.println(str);

        a<Integer> cs2 = new a(1);
        Integer i = cs2.getT();
        System.out.println(i);
    }
}

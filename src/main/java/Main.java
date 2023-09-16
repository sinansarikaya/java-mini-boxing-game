public class Main {
    public static void main(String[] args) {

        Fighter f1 = new Fighter("Cabbar", 15, 120, 100, 40);
        Fighter f2 = new Fighter("Kemal", 15, 100, 85, 40);

        Match match = new Match(f1, f2, 85, 100);
        match.run();
    }
}

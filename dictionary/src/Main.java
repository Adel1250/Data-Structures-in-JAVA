public class Main {
    public static void main(String[] args) {
        Dictionary<String, Integer> dictionary = new Dictionary<>();
        dictionary.set("Adel", 24);
        dictionary.set("Ashraf", 54);
        dictionary.set("Mohamed", 100);
        dictionary.print();
        System.out.println(dictionary.size());
        dictionary.remove("Ashraf");
        dictionary.print();
        System.out.println(dictionary.size());
    }
}
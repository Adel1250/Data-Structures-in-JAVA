public class Main {
    public static void main(String[] args) {
        HashTable<String, Integer> hashTable = new HashTable<>();
        hashTable.set("Adel", 24);
        hashTable.set("Ashraf", 54);
        hashTable.set("Mohamed", 100);
        hashTable.set("Mohamed", 124);
        hashTable.print();
        System.out.println(hashTable.size());
        System.out.println(hashTable.get("Adel"));
    }
}
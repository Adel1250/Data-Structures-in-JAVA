import java.util.Arrays;

public class HashTable<K, V> {
    private Pair<K, V>[] pairs;
    private int entriesCount = 0;

    private static final long OFFSET_BASIS = 2166136261L;
    private static final long PRIME = 16777619L;

    @SuppressWarnings("unchecked")
    public HashTable() {
        int initialSize = 3;
        pairs = (Pair<K, V>[]) new Pair[initialSize];
    }

    private int hash32(K key) {
        long hash = OFFSET_BASIS;
        byte[] data = key.toString().getBytes();
        for (byte b : data) {
            hash ^= b;
            hash *= PRIME;
        }
        return Math.abs((int) (hash % (long) pairs.length));
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        if (entriesCount < pairs.length)
            return;
        Pair<K, V>[] pairsCopy = (Pair<K, V>[]) new Pair[pairs.length];
        System.arraycopy(this.pairs, 0, pairsCopy, 0, pairs.length);
        pairs = (Pair<K, V>[]) new Pair[pairs.length * 2];
        for (Pair<K, V> pair : pairsCopy) {
            add(pair.getKey(), pair.getValue());
        }
    }

    private int collisionHandling(K key, int hash, boolean set) {
        for (int i = 1; i < pairs.length; i++) {
            int newHash = (hash + i) % pairs.length;
            if (set && (pairs[newHash] == null || pairs[newHash].getKey().equals(key))) {
                return newHash;
            } else if (!set && pairs[newHash].getKey().equals(key)) {
                return newHash;
            }
        }
        return -1;
    }

    private void add(K key, V value) {
        int hash = hash32(key);

        if (pairs[hash] != null && !pairs[hash].getKey().equals(key)) {
            hash = collisionHandling(key, hash, true);
        }

        if (hash == -1) {
            throw new RuntimeException("Invalid hashtable!");
        }

        if (pairs[hash] == null) {
            pairs[hash] = new Pair<>(key, value);
            entriesCount++;
        } else if (pairs[hash].getKey().equals(key)) {
            pairs[hash].setValue(value);
        } else {
            throw new RuntimeException("Invalid hashtable!");
        }
    }

    public void set(K key, V value) {
        resize();
        add(key, value);
    }

    public V get(K key) {
        int hash = hash32(key);

        if (pairs[hash] != null && !pairs[hash].getKey().equals(key)) {
            hash = collisionHandling(key, hash, false);
            if (hash == -1) {
                return null;
            }
        }

        if (pairs[hash].getKey().equals(key)) {
            return pairs[hash].getValue();
        } else {
            return null;
        }
    }

    public long size() {
        return this.entriesCount;
    }

    public void print() {
        System.out.println(Arrays.toString(pairs));
    }
}

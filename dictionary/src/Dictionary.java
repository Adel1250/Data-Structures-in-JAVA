import java.util.Arrays;

public class Dictionary<K, V> {
    private Pair<K, V>[] pairs;
    private int entriesCount = 0;
    private  final int initialSize = 3;

    @SuppressWarnings("unchecked")
    public Dictionary() {
        pairs = (Pair<K, V>[]) new Pair[initialSize];
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        if (this.entriesCount < this.pairs.length - 1)
            return;
        Pair<K, V>[] newPairs = (Pair<K, V>[]) new Pair[this.initialSize + this.pairs.length];
        System.arraycopy(this.pairs, 0, newPairs, 0, this.pairs.length);
        this.pairs = newPairs;
    }

    public long size() {
        return this.entriesCount;
    }

    public void set(K key, V value) {
        for (Pair<K, V> kvPair : pairs) {
            if (kvPair != null && key.equals(kvPair.getKey())) {
                kvPair.setValue(value);
                return;
            }
        }
        this.resize();
        Pair<K, V> pair = new Pair<>(key, value);
        pairs[this.entriesCount] = pair;
        this.entriesCount++;
    }

    public void remove(K key) {
        for (int i = 0; i < this.pairs.length; i++) {
            if (this.pairs[i].getKey().equals(key)) {
                this.pairs[i] = this.pairs[this.entriesCount - 1];
                this.pairs[entriesCount - 1] = null;
                this.entriesCount--;
                return;
            }
        }
    }

    public void print() {
        System.out.println(Arrays.toString(this.pairs));
    }
}

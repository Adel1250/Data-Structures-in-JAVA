import java.util.Arrays;

public class Heap<T extends Comparable<T>> {
    private T[] array;
    private final int initialSize = 5;
    private int entriesCount = 0;

    @SuppressWarnings("unchecked")
    public Heap() {
        this.array = (T[]) new Comparable[initialSize];
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        if (entriesCount < array.length - 1)
            return;
        T[] newArray = (T[]) new Comparable[initialSize + array.length];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    public void insert(T data) {
        resize();
        if (entriesCount == 0) {
            array[0] = data;
            entriesCount++;
            return;
        }
        int i = entriesCount;
        entriesCount++;
        array[i] = data;
        int parentIndex = (i - 1) / 2;
        while (i != 0 && array[i].compareTo(array[parentIndex]) < 0) {
            T temp = array[i];
            array[i] = array[parentIndex];
            array[parentIndex] = temp;
            i = parentIndex;
            parentIndex = (i - 1) / 2;
        }
    }

    public T pop() {
        int i = 0;
        T data = array[i];
        array[i] = array[entriesCount - 1];
        array[entriesCount - 1] = null;
        entriesCount--;
        int leftIndex = 1;
        while (leftIndex < entriesCount) {
            int rightIndex = (2 * i) + 2;
            int smallerIndex = leftIndex;

            if (array[rightIndex].compareTo(array[leftIndex]) < 0) {
                smallerIndex = rightIndex;
            }

            if (array[smallerIndex].compareTo(array[i]) >= 0)
                break;

            T temp = array[i];
            array[i] = array[smallerIndex];
            array[smallerIndex] = temp;

            i = smallerIndex;
            leftIndex = (2 * i) + 1;
        }
        return data;
    }

    public void printHeap() {
        System.out.println(Arrays.toString(array));
    }
}

package dsa.dynamicarray;

import java.util.Arrays;
import java.util.Iterator;

@SuppressWarnings({ "unchecked"})
public class DynamicArray <T> implements Iterable<T> {
    private T[] arr;
    private int length;
    private int capacity;

    public DynamicArray(T[] array) {
        arr = Arrays.copyOf(array, array.length);
        length = array.length;
    }

    public DynamicArray() {
        length = 0;
        capacity = 0;
        arr = (T[]) new Object[0];
    }

    public int size() {
        return this.length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public T get(int index) {
        if(index >= length) throw new IndexOutOfBoundsException("Index out of range");
        return arr[index];
    }

    public void add(T item) {
        if(capacity == length){
            capacity = capacity * 2 + 1;
            arr = Arrays.copyOf(arr, capacity);
        }
        arr[length] = item;
        length++;
    }

    public void set(int index, T item) {
        if(index >= length) throw new IndexOutOfBoundsException();
        arr[index] = item;
    }

    public boolean contains(T item) {
        for(var i : arr) {
            if(i.toString() == item.toString()) return true;
        }
        return false;
    }

    public void reverse() {
        int i = 0, j = length - 1;
        while(j > i) {
            T temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i ++;
            j --;
        }
    }

    public void sort() {
        Arrays.sort(arr, 0, length - 1 );
    }


    public boolean remove(T item) {
        boolean found = false;
        for(int i = 0; i < length ; i++) {
            if(arr[i] == item) {
                if(i != length - 1) arr[i] = arr[i + 1];
            }
        }
        if(found) length -= 1;
        return found;
    }

    public void clear() {
        length = 0;
        capacity = 0;
        arr = (T[]) new Object[0];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return index < length;
            }

            @Override
            public T next() {
                index ++;
                return arr[index - 1];
            }
            
        };
    }

    @Override
    public String toString() {
        String res = "[ ";
        for(int i = 0; i < length; i++) {
            res += arr[i].toString() + " , ";
        }
        res += " ]";
        return res;
    }

    public static void main(String[] args) {
        DynamicArray<Integer> arr = new DynamicArray<>();
        arr.add(Integer.valueOf(20));
        arr.add(Integer.valueOf(100));
        arr.add(Integer.valueOf(300));
        arr.add(Integer.valueOf(100));
        arr.add(Integer.valueOf(200));
        System.out.println(arr);
        arr.sort();
        System.out.println(arr);
    }
    
}

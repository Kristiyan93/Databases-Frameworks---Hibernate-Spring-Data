package Exercise.g_CustomList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Custom<T extends Comparable<T>> {
    private List<T> list;

    public Custom() {
        this.list = new ArrayList<>();
    }

    public void addElement(T element) {
        this.list.add(element);
    }

    public T remove(int index) {
        return this.list.remove(index);
    }

    public Boolean contains(T element) {
        return this.list.contains(element);
    }

    public void swap(Integer index1, Integer index2) {
        T element1 = list.get(index1);
        T element2 = list.get(index2);

        list.set(index1, element2);
        list.set(index2, element1);
    }

    public Integer countGreaterThan(T element) {
        Integer count = 0;

        for (T t : list) {
            if (t.compareTo(element) > 0) {
                count++;
            }
        }

        return count;
    }

    public T getMax() {
        return Collections.max(this.list);
    }

    public T getMin() {
        return Collections.min(this.list);
    }

    public void sort() {
        this.list.sort(Comparable::compareTo);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (T t : list) {
            sb.append(t).append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
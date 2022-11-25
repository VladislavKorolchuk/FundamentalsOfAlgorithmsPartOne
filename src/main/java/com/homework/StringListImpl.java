package com.homework;

import javax.lang.model.element.Element;
import java.sql.Array;
import java.util.Arrays;

public class StringListImpl implements StringList {

    private final String[] line;
    private int size;

    public StringListImpl() {
        line = new String[10];
    }

    public StringListImpl(int lineSize) {
        line = new String[lineSize];
    }


    @Override
    public String add(String item) {
        validateItem(item);
        validateSize();
        line[size++] = item;
        return item;
    }

    @Override
    public String add(int index, String item) {
        validateIndex(index);
        validateItem(item);
        line[index] = item;
        return item;
    }

    @Override
    public String set(int index, String item) {
        validateIndex(index);
        validateItem(item);
        line[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        int i = indexOf(item);
        if (i == -1) {
            throw new ElementNotFoundExeption();
        }
        if (i != size) {
            System.arraycopy(line, i + 1, line, i, size - i);
        }
        size--;
        return item;
    }

    @Override
    public String remove(int index) {
        validateIndex(index);
        int i=index;
        String item = line[i];
        if (i != size) {
            System.arraycopy(line, i + 1, line, i, size - i);
        }
        size--;
        return item;
    }

    @Override
    public boolean contains(String item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < size; i++) {
            if (item.equals(line[i])) {
                return i;
            }

        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = size - 1; i >= 0; i--) {
            if (item.equals(line[i])) {
                return i;
            }

        }
        return -1;
    }

    @Override
    public String get(int index) {
        validateIndex(index); // Выкидываем исключение если индекс выходит за пределы
        return line[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(line, size);
    }

    // ---------------------------Обработка исключений----------------------------------

    private void validateSize() {
        if (size == line.length) {
            throw new StorageIsFullException();
        }
    }

    private void validateItem(String item) {
        if (item == null) {
            throw new NullItemException();
        }
    }

    private void validateIndex(int index) {
        if (index > size || index < 0) {
            throw new InvalidIndexException();
        }
    }

}


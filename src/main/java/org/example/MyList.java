package org.example;

import java.util.Arrays;

public class MyList<T> {
    private T[] arrayT;
    private int elementCounter = 1;

    public MyList() {
        arrayT = (T[]) new Object[10];
    }

    public MyList(int size) {
        arrayT = (T[]) new Object[size];
    }

    public int size() {
        return this.elementCounter - 1;
    }

    public int getCapacity() {
        return arrayT.length;
    }

    public void add(T data) {
        if ((elementCounter - 1) < arrayT.length) {
            arrayT[elementCounter - 1] = data;
        } else {
            T[] tempArrayT = (T[]) new Object[arrayT.length * 2];
            for (int i = 0; i < arrayT.length; i++) {
                tempArrayT[i] = arrayT[i];
            }
            arrayT = tempArrayT;
            arrayT[elementCounter - 1] = data;
        }
        ++elementCounter;
    }

    public T get(int index) {
        if (index < 0 || index > arrayT.length - 1) {
            return null;
        } else {
            return arrayT[index];
        }
    }

    public T remove(int index) {
        if (index < 0 || index > elementCounter - 1) {
            return null;
        } else {
            T temp = arrayT[index];
            int iter = index;
            while (arrayT[iter + 1] != null) {
                arrayT[iter] = arrayT[iter + 1];
                ++iter;
            }
            arrayT[iter] = null;
            --elementCounter;
            return temp;
        }
    }

    public T set(int index, T data) {
        if (index < 0 || index > elementCounter - 1) {
            return null;
        } else {
            arrayT[index] = data;
            return data;
        }
    }

    public String toString() {
        String elements = "[";
        int iter = 0;
        while ((iter < elementCounter - 1) && (elementCounter != 1)) {
            if (iter > 0)
                elements += ",";
            elements += arrayT[iter].toString();
            ++iter;
        }
        elements += "]";
        return elements;
    }

    public int indexof(T data) {
        int iter = 0;
        while (iter < elementCounter - 1) {
            if (arrayT[iter] == data) {
                return iter;
            }
            ++iter;
        }
        return -1;
    }

    public int lastIndexOf(T data) {
        int iter = 0;
        int index = -1;
        while (iter < elementCounter - 1) {
            if (arrayT[iter] == data) {
                index = iter;
            }
            ++iter;
        }
        return index;
    }

    public boolean isEmpty() {
        return (elementCounter == 1);
    }

    public T[] toArray() {
        return arrayT;
    }

    public void clear() {
        elementCounter = 1;
    }

    public MyList<T> sublist(int start, int finish) {
        MyList<T> tempList = new MyList<>();
        for (int iter = start; iter < finish; iter++) {
            tempList.add(arrayT[iter]);
        }
        return tempList;
    }

    public boolean contains(T data) {
        int iter = 0;
        while (iter < elementCounter - 1) {
            if (arrayT[iter] == data) {
                return true;
            }
            ++iter;
        }
        return false;
    }
}

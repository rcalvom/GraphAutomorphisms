package DataStructures.List;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<T> extends List<T> {

    protected T[] Elements;

    @SuppressWarnings("unchecked")
    public ArrayList(int InitialCapacity) {
        if (InitialCapacity < 1) {
            throw new IllegalArgumentException("The Initial Capacity must be greater than zero.");
        }
        this.Elements = (T[]) new Object[InitialCapacity];
        this.Size = 0;
    }

    public ArrayList() {
        this(8);
    }

    @Override
    public T Get(int index) {
        this.CheckIndex(index);
        return this.Elements[index];
    }

    @Override
    public int IndexOf(T Element) {
        for (int i = 0; i < this.Size; i++) {
            if (this.Elements[i].equals(Element)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int LastIndexOf(T Element) {
        for (int i = this.Size - 1; i >= 0; i--) {
            if (this.Elements[i].equals(Element)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public T Remove(int index) {
        this.CheckIndex(index);
        T removedElement = this.Elements[index];
        if (this.Size - index + 1 >= 0) {
            System.arraycopy(this.Elements, index + 1, this.Elements, index + 1 - 1, this.Size - index + 1);
        }
        this.Elements[--this.Size] = null;
        return removedElement;
    }

    @Override
    public void Clear() {
        this.Elements = null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void Add(int index, T Element) {
        if (index < 0 || index > Size) {
            throw new IndexOutOfBoundsException("Index = " + index + "; Size = " + this.Size);
        }
        if (this.Size == this.Elements.length) {
            T[] old = this.Elements;
            this.Elements = (T[]) new Object[2 * this.Size];
            System.arraycopy(old, 0, this.Elements, 0, this.Size);
        }
        if (this.Size - index >= 0) System.arraycopy(this.Elements, index, this.Elements, index + 1, this.Size - index);
        this.Elements[index] = Element;
        this.Size++;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator<>(this);
    }

    @Override
    public T Set(int index, T Element) {
        this.CheckIndex(index);
        T e = this.Elements[index];
        this.Elements[index] = Element;
        return e;
    }

    public void Sort() {
        Arrays.sort(this.Elements, 0, this.Size);
    }

    protected static class ArrayListIterator<E> implements Iterator<E> {

        protected ArrayList<E> list;
        protected int nextIndex;

        public ArrayListIterator(ArrayList<E> theList) {
            this.list = theList;
            this.nextIndex = 0;
        }

        @Override
        public boolean hasNext() {
            return this.nextIndex < this.list.Size;
        }

        @Override
        public E next() {
            if (this.nextIndex < this.list.Size) {
                return this.list.Elements[this.nextIndex++];
            } else {
                throw new NoSuchElementException("No next element");
            }
        }

    }

}

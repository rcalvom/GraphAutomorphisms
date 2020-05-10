package DataStructures.List;

import java.util.Iterator;

public interface IList<T> extends Iterable<T>{

    boolean IsEmpty();
    int Size();
    T Get(int index);
    int IndexOf(T Element);
    int LastIndexOf(T Element);
    T Remove(int index);
    boolean Remove(T Element);
    boolean RemoveAll(T ... Elements);
    void Clear();
    void Add(int index, T Element);
    void Add(T Element);
    void AddAll(T ... Elements);
    void AddAll(int index, T ... Elements);
    boolean Contains(T Element);
    @Override
    Iterator<T> iterator();
    T Set(int index, T Element);
    String ToString();

}

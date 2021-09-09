package models;


public interface ICriteria<T> {
    public boolean find(T t);
    public boolean isExist(T t);
    public boolean remove(T t);
    public boolean compareTo(T o1,T o2);
    public boolean verification(T o1,T o2);
}

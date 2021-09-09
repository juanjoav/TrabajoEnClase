package models;


public interface ICriteria<T> {
    public boolean find(T t);
    public boolean isExist(T t);
    public boolean remove(T t);
}

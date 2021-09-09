package models;

import excepcion.LessData;

import java.util.Comparator;


public class MyArray<T>{

    private T[] datas;

    /**
     *Metodo Construtor vacio para iniciar el arreglo dinamico
     */
    public MyArray() {
        this.datas  = (T[]) new Object[0];;
    }

    /**
     *Metodo Constructor que inicaliza el numero de espacios que va a tener el arreglo dinamico inicalmente
     * @param size
     */
    public MyArray(int size) {
        this.datas  = (T[]) new Object[size];;
    }

    /**
     *Metodo Constructor sobrecargado que recibe otro arreglo de objetos
     * @param datas
     */
    public MyArray(T[] datas) {
        this.datas = datas;
    }

    /**
     *Realiza y retiene el dato en la posicion data
     * @param index
     * @return
     */
    public T get(int index){
        if(index <= datas.length-1){// validar index
            return datas[index];
        }else{
            return datas[datas.length-1];
        }
    }

    /**
     *Setea donde exactamente quiere, si no hay eespacio o el indice es diferente se crea mas espacios
     * @param index indice
     * @param value objeto a colocar
     */
    public void set(int index, T value){
        if(index > datas.length) {
            try {
                resize(index);
                datas[index-1] = value;
            } catch (LessData lessData) {
                lessData.printStackTrace();
            }
        }else{

            datas[index] = value;
        }
    }

    /**
     *Obtiene la longitud del arreglo 
     * @return
     */
    public int size(){
        return datas.length;
    }

    /**
     *Administra el cambio de dimension del arreglo dinamico
     * @param size El nuevo tamaño
     * @throws LessData esta excepcion salta cuando el seteo del tamaño es menor al arreglo actual
     */
    public void resize(int size) throws LessData { // dinamismo
        if(size > datas.length){
            T[] aux = (T[]) new Object[size];
            System.arraycopy(datas,0,aux,0,datas.length);
            datas = aux;
        }else if(size < datas.length){
            T[] aux = (T[]) new Object[size];
            System.arraycopy(datas,0,aux,0,size);
            datas = aux;
            throw new LessData();
        }

    }

    /**
     * Este metodo se encarga de ordenar a partir de un comparador
     * @param comparator criterio de comparacion
     */
    public void sort(Comparator<T> comparator) {
        for (int i = 0; i < datas.length; i++) {
            for (int j = 0; j < datas.length; j++) {
                if (comparator.compare(datas[i], datas[j]) < 0) {
                    T variable = datas[i];
                    datas[i] = datas[j];
                    datas[j] = variable;
                }
            }
        }
    }

    /**
     *  Busca apartir de un criterio o criterios y mira si existe
     * @param iCriteria criterio a evaluar
     * @return  true si existe al menos un elemento que cumpla con el ctiterio
     * falso si no lo hay
     */
    public boolean isExist(ICriteria<T> iCriteria){
        for (int i = 0; i < datas.length; i++) {
            if(iCriteria.isExist(datas[i])){
                return true;
            }
        }
        return false;
    }

    /**
     *Busca elementos apartor de un criterio
     * @param iCriteria
     * @return
     */
    public MyArray<T> find(ICriteria<T> iCriteria) {
        MyArray<T> result = new MyArray<>();
        for (int i = 0; i < datas.length; i++) {
            if(iCriteria.find(datas[i])){
                result.addElement(datas[i]);
            }
        }
        return result;
    }

    /**
     *Agrega a la ultima posicion el objeto
     * @param thing objeto cualquiera
     */
    public void addElement(T thing){
        T[] aux = (T[]) new Object[datas.length + 1];
        aux[datas.length] = thing;
        System.arraycopy(datas, 0, aux, 0, datas.length);
        datas = aux;
    }

    /**
     *Borra un objecto sin importar el indice en que este
     * @param iCriteria critrio o criterios
     */
    public void remove(ICriteria<T> iCriteria){
        T[] aux = (T[]) new Object[datas.length-1];
        int counter = 0;
        for (int i = 0; i < datas.length; i++) {
            if (!iCriteria.remove(datas[i])) {
                aux[counter] = datas[i];
                counter++;
            }
        }
        datas=aux;
    }
}

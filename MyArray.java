package OOP_seminar4_homework;


import java.util.Arrays;

public class MyArray<T extends Comparable<T>>{
    private T[] myArray;
    private int arrayLenght;

    
    // Конструктор без параметров – конструктор по умолчанию, проводяющий базовую иницаилизацию массива
   public MyArray(){
        this.arrayLenght = 0;
        this.myArray = (T[]) new Comparable[0];
   }

    // Конструктор с параметром T[] – конструктор, который проводит инициализацию и заполняет массив данными,
    // пришедшими из параметра
    public MyArray(T array[]){
        this.myArray = Arrays.copyOf(array, array.length);
        this.arrayLenght = array.length;
    }
   
    // 1. Вставка в массив
    public void add(T value){
        myArray = Arrays.copyOf(myArray, arrayLenght +1);
        myArray[arrayLenght] = value;
        arrayLenght++;
        
    }

    // 2. Удаление элемента по индексу
    public void removeByIndex(int i){
        if (0 > i || i >= arrayLenght) {
            throw new IndexOutOfBoundsException("Индекс выходит за пределы массива");
        }
        for (int j = i; j < arrayLenght - 1; j++) {
            myArray[j] = myArray[j + 1];
        }
        arrayLenght--;
        myArray = Arrays.copyOf(myArray, arrayLenght);
    }

    //3. Удаление всех элементов с заданным значением
    public void removeByValue(T value){
        for (int i = 0; i < this.myArray.length; i++) {
            if (myArray[i].equals(value))
                removeByIndex(i);
        }
        myArray = Arrays.copyOf(myArray, arrayLenght);
    }

    //4. Поиск минимума
    public T getMin(){
        T min = myArray[0];
        for (int i = 0; i < arrayLenght; i++) {
            if (this.myArray[i].compareTo(min) < 0) {
                min = myArray[i];
            }
        }
        return min;

    }

    //5. Поиск максимума
    public T getMax(){
        T max = myArray[0];
        for (int i = 0; i < arrayLenght; i++) {
            if (this.myArray[i].compareTo(max) > 0) {
                max = myArray[i];
            }
        }
        return max;

    }

    // 6. Поиск суммы элементов массива
    public Object sumArray(){
        if (myArray[0] instanceof Number){
            Number sum = 0;
            for (T item: this.myArray) {
                sum = sum.doubleValue() + ((Number)item).doubleValue();
            }
        
            return sum;
        }
        if (myArray[0] instanceof String){
            StringBuilder sum = new StringBuilder();
            for (int i = 0; i < arrayLenght; i++) {
                sum.append((String) myArray[i]);
                sum.append(" ");
            }
            return sum;
        
        }
        return null;
    }

    // 7. Поиск произведения элементов массива
    public Object multyArray(){
        if (myArray[0] instanceof Number){
            Number multy = 1;
            for (T item: this.myArray) {
                multy = multy.doubleValue() * ((Number)item).doubleValue();
            }
            return multy;
        }
        if (myArray[0] instanceof String) throw new IllegalArgumentException("Невозможно посчитать произведение строк");
        return null;
    }

    // 8. Поиск индекса заданного элемента в массиве, если такого элемента в массиве нет то возвращать -1
    public Integer indexSearch(T value){
        for (int i = 0; i < arrayLenght; i++){
            if (myArray[i].equals(value)) return i;
        
        }
        return -1;
    }

    // 9. Проверка наличия элемента в массиве. Возвращает true, если элемент в массиве есть, false – нет.
    public Boolean elementInArray(T value){
        for(T element: myArray){
            if (element.equals(value)) return true;
        }
        return false;
    }

    // 10. Пузырьковая сортировка
    public void bubbleSort(){
        for (int i = 0; i < arrayLenght; i ++){
            for (int j = 0; j < arrayLenght - 1 - i; j ++){
                if (this.myArray[j].compareTo(this.myArray[j + 1]) > 0) {
                    T temp = myArray[j];
                    myArray[j] = myArray[j + 1];
                    myArray[j + 1] = temp;
                }
            }
        }
    }

    //11. Сортировка простыми вставками
    public void simpleInsertSort(){
        for (int i = 1; i < arrayLenght; i++) {
            T temp = myArray[i];
            int j = i - 1;
            while (j >= 0 && myArray[j].compareTo(temp) > 0){
                myArray[j + 1] = myArray[j];
                j--;
            }
            myArray[j + 1] = temp;
        }
    }

    // 12. Сортировка простым выбором
    public void simpleSelectSort(){
        for (int i = 0; i < arrayLenght - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arrayLenght; j++) {
                if (myArray[j].compareTo(myArray[minIndex]) < 0){
                    minIndex = j;
                }
            }
            T temp = myArray[minIndex];
            myArray[minIndex] = myArray[i];
            myArray[i] = temp;
        }
    }

    //13. Получение элемента массива по индексу
    public T getByIndex(int i){
        if (0 > i || i >= arrayLenght) {
            throw new IndexOutOfBoundsException("Индекс выходит за пределы массива");
        }
        return this.myArray[i];
    }

    //14. Задание значения элементу массива с заданным индексом
    public void setValueByIndex(T value, int i){
        if (i < 0 || i >= arrayLenght) {
            throw new IndexOutOfBoundsException("Индекс выходит за пределы массива");
        } else {
            this.myArray[i] = value;
        }
    }
       

    // 15. Печать массива на экран
    public void print(){
        System.out.println(Arrays.toString(myArray));
    }

    // 16. Длинна массива
    public  int getArrayLenght(){
        return arrayLenght;
    }
    

}

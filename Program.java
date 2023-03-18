/*
 * Реализовать класс для работы с одномерными динамическими массивами произвольных данных(произвольного типа). Класс будет иметь следующие конструкторы:
1. Конструктор без параметров – конструктор по умолчанию, проводяющий базовую иницаилизацию массива
2. Конструктор с параметром T[] – конструктор, который проводит инициализацию и заполняет массив данными, пришедшими из параметра
Так же класс будет иметь следующие публичные методы:
1. Вставка в массив
2. Удаление элемента по индексу
3. Удаление всех элементов с заданным значением
4. Поиск минимума
5. Поиск максимума
6. Поиск суммы элементов массива
7. Поиск произведения элементов массива
8. Поиск индекса заданного элемента в массиве, если такого элемента в массиве нет то возвращать -1
9. Проверка наличия элемента в массиве. Возвращает true, если элемент в массиве есть, false – нет.
10. Пузырьковая сортировка
11. Сортировка простыми вставками
12. Сортировка простым выбором
13. Получение элемента массива по индексу
14. Задание значения элементу массива с заданным индексом
15. Печать массива на экран
16. Длинна массива
Так же класс должен содержать следующие приватные поля:
1. Сам массив произвольных данных.
2. Длинну массива
*Так же массив должен содержать следующие перегруженные операторы:
1. Оператор, получающий элемент по заданному индексу
2. Оператор, позволяющий установить значение элемента по заданному индексу
*Так же в случае, если могут произойти ошибки или некорретная работа в конструкторах или методах, необходимо использовать механизм исключений для обработки возможных ошибок.
 */





package OOP_seminar4_homework;

public class Program {

    public static void main(String[] args) {
        Integer[] values = {44, 7, 5, 18, 26};
        MyArray<Integer> someArray = new MyArray<>(values);

        String[] valueStrings = {"make", "love", "not", "war"};
        MyArray<String> someStringArray = new MyArray<>(valueStrings);

        someArray.print();
        someStringArray.print();

        someArray.add(33);
        someArray.print();
        someStringArray.add("ever");
        someStringArray.print();

        someArray.removeByIndex(2);
        someArray.print();
        someStringArray.removeByIndex(3);
        someStringArray.print();

        someArray.removeByValue(18);
        someArray.print();

        System.out.println();
        System.out.println("Минимальный элемент: ");
        System.out.println(someArray.getMin());
        System.out.println(someStringArray.getMin());

        System.out.println();
        System.out.println("Максимальный элемент: ");
        System.out.println(someArray.getMax());
        System.out.println(someStringArray.getMax());

        System.out.println();
        System.out.println("Сумма элементов массива: ");
        System.out.println(someArray.sumArray());
        System.out.println(someStringArray.sumArray());

        System.out.println();
        System.out.println("Произведение элементов массива: ");
        System.out.println(someArray.multyArray());
        //System.out.println(someStringArray.multyArray()) - выдает исключение;

        System.out.println();
        System.out.println("Поиск индекса заданного элемента в массиве: ");
        System.out.println(someArray.indexSearch(0));
        System.out.println(someStringArray.indexSearch("not"));

        System.out.println();
        System.out.println("Проверка наличия элемента в массиве: ");
        System.out.println(someArray.elementInArray(14));
        System.out.println(someStringArray.elementInArray("not"));

        System.out.println();
        System.out.println("Пузырьковая сортировка: ");
        someArray.bubbleSort();
        someArray.print();
        someStringArray.bubbleSort();
        someStringArray.print();

        System.out.println();
        System.out.println("Сортировка простыми вставками: ");
        someArray.simpleInsertSort();
        someArray.print();
        someStringArray.simpleInsertSort();
        someStringArray.print();

        System.out.println();
        System.out.println("Сортировка простым выбором: ");
        someArray.simpleSelectSort();
        someArray.print();
        someStringArray.simpleSelectSort();;
        someStringArray.print();

        System.out.println();
        System.out.println("Получение элемента массива по индексу: ");
        System.out.println(someArray.getByIndex(2));
        System.out.println(someStringArray.getByIndex(2));

        System.out.println();
        System.out.println("Задание значения элементу массива с заданным индексом: ");
        someArray.setValueByIndex(77, 0);
        someArray.print();
        someStringArray.setValueByIndex("peace", 0);
        someStringArray.print();
        
        
    }
}

import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;

public class Main implements Array {
    private int[] array;
    private int[] orderedArray;

    public static void main(String[] args) {
        Main main = new Main();
        main.createArray();
        main.findElement();
        main.insertElement();
        main.deleteElement();
        main.orderedArray();
        main.findElementInOrderedArray(2);
        main.binarySearchInOrderedArray(2);
        main.insertElementInOrderedArray(1);
        main.deleteElementFromOrderedArray(2);

    }

    public void createArray() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите длину массива");
        int length = scanner.nextInt();
        array = new int[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(100) + 1;
        }
        System.out.println("Массив: " + Arrays.toString(array));
    }

    public void findElement() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите элемент, который нужно найти");
        int elementToFind = scanner.nextInt();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == elementToFind) {
                System.out.println("Элемент найден на позиции " + i);
                return;
            }
        }
        System.out.println("Элемент не найден");
    }

    public void insertElement() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите элемент, который нужно вставить");
        int elementToInsert = scanner.nextInt();
        System.out.println("Введите позицию для вставки");
        int positionToInsert = scanner.nextInt();
        if (positionToInsert < 0 || positionToInsert > array.length) {
            System.out.println("Неверная позиция для вставки");
            return;
        }
        int[] newArray = new int[array.length + 1];
        for (int i = 0; i < positionToInsert; i++) {
            newArray[i] = array[i];
        }
        newArray[positionToInsert] = elementToInsert;
        for (int i = positionToInsert; i < array.length; i++) {
            newArray[i + 1] = array[i];
        }
        array = newArray;
        System.out.println("Массив после вставки: " + Arrays.toString(array));
    }

    public void deleteElement() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите позицию элемента, который нужно удалить");
        int positionToDelete = scanner.nextInt();
        if (positionToDelete < 0 || positionToDelete >= array.length) {
            System.out.println("Неверная позиция для удаления");
            return;
        }
        int[] newArray = new int[array.length - 1];
        for (int i = 0, j = 0; i < array.length; i++) {
            if (i != positionToDelete) {
                newArray[j++] = array[i];
            }
        }
        array = newArray;
        System.out.println("Массив после удаления: " + Arrays.toString(array));
    }

    public void orderedArray() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите длину упорядоченного массива");

        int length = scanner.nextInt();  // Take input for length of ordered array
        orderedArray = new int[length];  // Initialize the instance field, not a local variable

        for (int i = 0; i < length; i++) {
            orderedArray[i] = i * 2;    // Populate the ordered array
        }
        System.out.println("Упорядоченный массив: " + Arrays.toString(orderedArray));
    }
    // Функция поиска элемента в упорядоченном массиве
    public void findElementInOrderedArray(int elementToFind) {
        int index = Arrays.binarySearch(orderedArray, elementToFind);
        if (index >= 0) {
            System.out.println("Элемент найден на позиции " + index);
        } else {
            System.out.println("Элемент не найден");
        }
    }

    // Функция двоичного поиска в упорядоченном массиве
    public void binarySearchInOrderedArray(int elementToFind) {
        int start = 0;
        int end = orderedArray.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (orderedArray[mid] == elementToFind) {
                System.out.println("Элемент найден на позиции " + mid);
                return;
            } else if (orderedArray[mid] < elementToFind) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println("Элемент не найден");
    }

    // Функция вставки элемента в упорядоченный массив
    public void insertElementInOrderedArray(int elementToInsert) {
        int index = Arrays.binarySearch(orderedArray, elementToInsert);
        if (index >= 0) {
            System.out.println("Элемент уже существует в массиве");
        } else {
            int insertionPoint = -index - 1;
            int[] newArray = new int[orderedArray.length + 1];
            System.arraycopy(orderedArray, 0, newArray, 0, insertionPoint);
            newArray[insertionPoint] = elementToInsert;
            System.arraycopy(orderedArray, insertionPoint, newArray, insertionPoint + 1, orderedArray.length - insertionPoint);
            orderedArray = newArray;
            System.out.println("Массив после вставки: " + Arrays.toString(orderedArray));
        }
    }

    // Функция удаления элемента из упорядоченного массива
    public void deleteElementFromOrderedArray(int elementToDelete) {
        int index = Arrays.binarySearch(orderedArray, elementToDelete);
        if (index >= 0) {
            int[] newArray = new int[orderedArray.length - 1];
            System.arraycopy(orderedArray, 0, newArray, 0, index);
            System.arraycopy(orderedArray, index + 1, newArray, index, orderedArray.length - index - 1);
            orderedArray = newArray;
            System.out.println("Массив после удаления: " + Arrays.toString(orderedArray));
        } else {
            System.out.println("Элемент не найден в массиве");
        }
    }
}


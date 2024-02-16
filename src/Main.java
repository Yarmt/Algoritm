import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;

public class Main implements Array {
    private int[] array;

    public static void main(String[] args) {
        Main main = new Main();
        main.createArray();
        main.findElement();
        main.insertElement();
        main.deleteElement();
        main.orderedArray();
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

        int[] orderedArray = new int[length];
        for (int i = 0; i < length; i++) {
            orderedArray[i] = i * 2;
        }
        System.out.println("Упорядоченный массив: " + Arrays.toString(orderedArray));
    }
}


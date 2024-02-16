import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class Main implements Array {
    public static void main(String[] args) {
        private int flag = 0;
        public void setFlag(int flag) {
            this.flag = flag;
        }
        public int getFlag() {
            return flag;
        }
        //-1 задание
        System.out.println("введите длину масива");
        int[] array = new int[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(100) + 1;
        }
        System.out.println("Массив: " + Arrays.toString(array));
        //-2 задание
        //поиск
        System.out.println("введите элемент, которого нужно найти");
        int elementToFind = scanner.nextInt(); // Пример: элемент, который нужно найти
        for (int i = 0; i < length; i++) {
            if (array[i] == elementToFind) {
                System.out.println("Элемент найден на позиции " + i);
                break;
            }
        }
        // вставка
        System.out.println("введите элемент, которого нужный нужно вставить");
        int elementToInsert = scanner.nextInt();
        System.out.println("укажите номер элемента, которого нужный нужно вставить");
        int positionToInsert = scanner.nextInt();
        array = insertElement(array, elementToInsert, positionToInsert);
        System.out.println("Массив после вставки: " + Arrays.toString(array));

        System.out.println("введите позицию элемента, которого нужный нужно удалить");
        int positionToDelete = scanner.nextInt();
        array = deleteElement(array, positionToDelete);
        System.out.println("Массив после удаления: " + Arrays.toString(array));
        //3 задание
        System.out.println("введите длину упорядоченного масива");
        flag += 1;
        int[] orderedArray = new int[length];
        for (int i = 0; i < length; i++) {
            orderedArray[i] = i * 2;
        }
        System.out.println("Упорядоченный массив: " + Arrays.toString(orderedArray));
    }


    public static int[] insertElement(int[] array, int element, int position) {
        int[] newArray = new int[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, position);
        newArray[position] = element;
        System.arraycopy(array, position, newArray, position + 1, array.length - position);
        return newArray;
    }

    public static int[] deleteElement(int[] array, int position) {
        int[] newArray = new int[array.length - 1];
        System.arraycopy(array, 0, newArray, 0, position);
        System.arraycopy(array, position + 1, newArray, position, array.length - position - 1);
        return newArray;
    }
}


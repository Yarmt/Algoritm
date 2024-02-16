import java.util.Scanner;
interface Array {
    Scanner scanner = new Scanner(System.in);
    void createArray();
    void findElement();
    void insertElement();
    void deleteElement();
    void orderedArray();
    int length = scanner.nextInt();
}
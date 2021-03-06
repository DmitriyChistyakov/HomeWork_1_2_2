import Exception.MyArraySizeException;
import Exception.MyArrayDataException;
/** Bpvtytybz*/

/**
 * 1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4,
 * при подаче массива другого размера необходимо бросить исключение MyArraySizeException.
 * <done>
 * 2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать.
 * Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
 * должно быть брошено исключение MyArrayDataException, с детализацией в какой именно ячейке лежат неверные данные.
 *  * <done>
 * 3. В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException и MyArrayDataException,
 * и вывести результат расчета.
 *  * <done>
 */

public class Main {

    public static void main(String[] args) {
        String[][] arr = {
//                {"1", "5", "8", "9"},  // массив с сиволом
//                {"1", "5", "8", "9"},
//                {"1", "rrr", "8", "9"},
//                {"1", "5", "8", "4"},
//
//                {"1", "5", "8", "4"},    // массив >4
//                {"1", "5", "8", "4"},
//                {"1", "5", "8", "4"},
//                {"1", "5", "8", "4", "4"},

//                {"1", "5", "8", "4"},   // массив >4
//                {"1", "5", "8", "4"},
//                {"1", "5", "8", "4"},
//                {"1", "5", "8", "4"},
//                {"1", "5", "8", "4"},


                {"1", "1", "1", "1"},   //массив удовлетворяющий всем условия
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},



        };
        doIt(arr);
    }

    public static void doIt(String arr[][]) throws MyArrayDataException, MyArraySizeException {
        int size = 4;
        if (arr.length != size) {
            throw new MyArraySizeException("массив должен быть размера " + size);
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4) {
                throw new MyArraySizeException("Вложенный массив  " + i + " должен быть размера " + size);
            }
        }

        int summ = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    summ += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    String message = String.format("символ  %s  в массиве не число  i= [%s]  j= [%s]", arr[i][j], i, j);
                    throw new MyArrayDataException(message, e);
//                    throw new MyArrayDataException(message); /**не понял как вызвать метод с выводом просто сообщения...*/
                } finally {
//                    System.out.printf("Это собщение должно всегда выводиться...%nТолько если программист не сломает код...%n Но я не понял, когда это произойдет %n");
                    // Думал "сломать" код break или System.exit но не смог...
                }
            }
        }
        System.out.printf("Массив подходит под все условия.%nСумма чисел массива равняется =  %S", summ);
    }
}





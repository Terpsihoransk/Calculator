package KataCalc;

/** by @TerpsihoraNSK релиз без MapThree и Scanner*/

import java.io.BufferedReader; // Импорт библиотеки ввода данных
import java.io.InputStreamReader;

public class CalulatorKata {

    private static void chekNumb(int num1, int num2) throws Exception { // принимаем числа, сразу присвоив переменные и проверяем корректность от 1 до 10
        if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10)
            throw new Exception("Введите числа в диапазоне от 1 до 10");
    }

    private static int operations(int num1, char operator, int num2) throws Exception { // производим вычисления
        chekNumb(num1, num2);
        return switch (operator) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            case '/' -> num1 / num2;
            default -> throw new Exception("Оператор " + operator + " не подходит, используйте +, -, * или /");
        };
    }

    public static void main(String[] args) { // отсюда стартуем

        System.out.println("Введите два операнда и один оператор через пробел в виде A + B.");
        System.out.println("Работаем с римскими и арабскими числами от 1 до 10 и операторами: +, -, *, /");
        System.out.println("Input: ");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // создаём объект, который позволяет принимать ввод в консоль
        int result;  // сразу объявляем переменную результата в числовом формате, т.к. римские конвертируем при вводе
        try {
            String input = reader.readLine().toUpperCase(); // считываем ввод, приведя к верхнему регистру
            String[] inputArray = input.split(" "); // создаём массив с разделителем в виде пробела
            if (inputArray.length !=3) // проверяем длину строки, если не три символа, выдаём ошибку
                throw new Exception("Формат математической операции не удовлетворяет заданию - два операнда и один оператор через пробел");
            if (inputArray[0] != inputArray[2])
                throw new Exception("Используются одновременно разные системы счисления");
            char operator = inputArray[1].charAt(0); // оператору присваиваем символьную переменную
            int num1, num2; // переменным числовую

            try { // арабские числа считаем сразу в числовом формате
                num1 = Integer.parseInt(inputArray[0]);
                num2 = Integer.parseInt(inputArray[2]);
                result = operations(num1, operator, num2);
                System.out.println("Output: \n" + result);
            }
            catch (NumberFormatException e) { // римские конвертируем и считаем
                num1 = ConvertRoman.romanToArabic(inputArray[0]);
                num2 = ConvertRoman.romanToArabic(inputArray[2]);
                result = operations(num1, operator, num2);
                if (result < 1) throw new Exception("В римской системе нет отрицательных чисел");
                System.out.println("Output: \n" + ConvertRoman.arabicToRoman(result)); // результат конвертируем и выводим в римском формате
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
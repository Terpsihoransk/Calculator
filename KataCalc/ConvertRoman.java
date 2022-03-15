package KataCalc;

public class ConvertRoman { // преобразуем римские в арабские от 1 до 10, больше не требуется
    static int romanToArabic(String roman) throws Exception {
        return switch (roman) {
            case "I" -> 1;
            case "II" -> 2;
            case "III" -> 3;
            case "IV" -> 4;
            case "V" -> 5;
            case "VI" -> 6;
            case "VII" -> 7;
            case "VIII" -> 8;
            case "IX" -> 9;
            case "X" -> 10;
            default -> throw new Exception("Некорректное значение. Введите число в диапазоне I-X");
        };
    }

    static String arabicToRoman(int arabic) { // переводим арабские в римские, т.к. ответ может быть больше 10
        String roman = switch (arabic / 10) {
            case 1 -> "X";
            case 2 -> "XX";
            case 3 -> "XXX";
            case 4 -> "XL";
            case 5 -> "L";
            case 6 -> "LX";
            case 7 -> "LXX";
            case 8 -> "LXXX";
            case 9 -> "XC";
            case 10 -> "C";
            default -> "";
        };
        roman += switch (arabic % 10) {
            case 1 -> "I";
            case 2 -> "II";
            case 3 -> "III";
            case 4 -> "IV";
            case 5 -> "V";
            case 6 -> "VI";
            case 7 -> "VII";
            case 8 -> "VIII";
            case 9 -> "IX";
            default -> "";
        };
        return roman;
    }
}

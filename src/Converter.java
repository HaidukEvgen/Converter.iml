import java.util.Scanner;
public class Converter {
    public static Scanner scanner= new Scanner(System.in);

    static final int MIN_ANYTHING = 1;
    static final int MAX_CURRENCY = 8;
    static final int MAX_LENGTH = 6;
    static final int MAX_TIME = 8;
    static final int MAX_SQUARE = 8;
    static final int MAX_VOLUME = 7;
    static final int MAX_SPEED = 4;
    static final int MAX_TEMPERATURE = 4;
    static final int MAX_WEIGHT = 7;

    public static int getChoice(int MAX_CHOICE, int MIN_CHOICE){
        int choice = 0;
        boolean isIncorrect;
        do {
            isIncorrect = false;
            System.out.print("Выберите величину ввода:");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Вы ввели неподходящий код величины");
                isIncorrect = true;
            }
            if (!isIncorrect && (choice < MIN_CHOICE) || (choice > MAX_CHOICE)) {
                System.out.println("Вы ввели неподходящий код величины");
                choice = 0;
                isIncorrect = true;
            }
        } while (isIncorrect);
        return choice;
    }

    public static int getOutput(int MAX_OUTPUT, int MIN_OUTPUT, int choice){
        int output = 0;
        boolean isIncorrect;
        do {
            isIncorrect = false;
            System.out.print("Выберите величиу вывода:");
            try {
                output = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Вы ввели неподходящий код величины");
                isIncorrect = true;
            }
            if (!isIncorrect && (output < MIN_OUTPUT) || (output > MAX_OUTPUT)) {
                System.out.println("Вы ввели неподходящий код величины");
                output = 0;
                isIncorrect = true;
            }
            if (!isIncorrect && choice == output) {
                System.out.println("Та же величина не может быть конвертирована");
                isIncorrect = true;
            }
        } while (isIncorrect);
        return output;
    }

    public static double getInput(String inType){
        double input = 0;
        boolean isIncorrect;
        do {
            isIncorrect = false;
            System.out.print("Введите число для конвертации из " + inType);
            try {
                input = Double.parseDouble(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Вы ввели неподходящее число");
                isIncorrect = true;
            }
            if (!isIncorrect && (input < 0)) {
                System.out.println("Вы ввели неподходяще число");
                input = 0;
                isIncorrect = true;
            }
        } while (isIncorrect);
        return input;
    }

    public static void Currency() {
        char us_dollar_sym = 36;
        char pound_sym = 163;
        char euro_sym = 8364;
        char yen_sym = 165;
        char bel_rub_sym = 8381;
        char rus_rub_sym = 8381;
        char zloty_sym = 90;

        String us_dollar = "Американский доллар";
        String pound = "Английский фунт";
        String yen = "Японская йена";
        String euro = "Евро";
        String bel_rub = "Белорусский рубль";
        String rus_rub = "Российский рубль";
        String zloty = "Польский злотый";

        double result;

        // Интерфейс

        System.out.println("Вы выбрали конвертацию валют.");
        System.out.println("Используйте следующие коды для ввода выбранной валюты:");
        System.out.println(" 1 - Американский доллар \n 2 - Евро \n 3 - Английский фунт \n 4 - Японская йена \n 5 - Белорусский рубль \n 6 - Российский рубль \n 7 - Польский злотый \n 8 - Завершить конвертацию валют \n");

        //Ввод первой валюты и проверка

        int choice = getChoice(MAX_CURRENCY, MIN_ANYTHING);
        if (choice == 8)
            return;

        String inType = "";

        switch (choice) {
            case 1 -> inType = "Американский доллар >> " + us_dollar_sym;
            case 2 -> inType = "Евро >> " + euro_sym;
            case 3 -> inType = "Английский фунт >> " + pound_sym;
            case 4 -> inType = "Японская йена >> " + yen_sym;
            case 5 -> inType = "Белорусский рубль >> " + bel_rub_sym;
            case 6 -> inType = "Российский рубль >> " + rus_rub_sym;
            case 7 -> inType = "Польский злотый >> " + zloty_sym;
        }

        //Ввод второй валюты и проверка
        int output = getOutput(MAX_CURRENCY, MIN_ANYTHING, choice);
        if (output == 8)
            return;

        //Ввод сумма перевода и проверка
        double input = getInput(inType);

        double rate;

        //Конвертация величин
        switch (choice) {
            //Доллар во все валюты
            case 1 -> {
                switch (output) {
                    case 2 -> {
                        double dollar_euro_rate = 0.852988;
                        result = input * dollar_euro_rate;
                        System.out.printf("%s" + input + " по курсу " + dollar_euro_rate + " Американский доллар в %s = %s%.2f\n", us_dollar_sym, euro, euro_sym, result);
                    }
                    case 3 -> {
                        double dollar_pound_rate = 0.732562;
                        result = input * dollar_pound_rate;
                        System.out.printf("%s" + input + " по курсу " + dollar_pound_rate + " Американский доллар в %s = %s%.2f\n", us_dollar_sym, pound, pound_sym, result);
                    }
                    case 4 -> {
                        double dollar_yen_rate = 109.633;
                        result = input * dollar_yen_rate;
                        System.out.printf("%s" + input + " по курсу " + dollar_yen_rate + " Американский доллар в %s = %s%.2f\n", us_dollar_sym, yen, yen_sym, result);
                    }
                    case 5 -> {
                        double dollar_bel_rub_rate = 2.50223;
                        result = input * dollar_bel_rub_rate;
                        System.out.printf("%s" + input + " по курсу " + dollar_bel_rub_rate + " Американский доллар в %s = %s%.2f\n", us_dollar_sym, bel_rub, bel_rub_sym, result);
                    }
                    case 6 -> {
                        double dollar_rus_rub_rate = 72.8849;
                        result = input * dollar_rus_rub_rate;
                        System.out.printf("%s" + input + " по курсу " + dollar_rus_rub_rate + " Американский доллар в %s = %s%.2f\n", us_dollar_sym, rus_rub, rus_rub_sym, result);
                    }
                    case 7 -> {
                        double dollar_zloty_rate = 3.94333;
                        result = input * dollar_zloty_rate;
                        System.out.printf("%s" + input + " по курсу " + dollar_zloty_rate + " Американский доллар в %s = %s%.2f\n", us_dollar_sym, zloty, zloty_sym, result);
                    }
                }
            }
            //Евро во все валюты
            case 2 -> {
                switch (output) {
                    case 1 -> {
                        double euro_dollar_rate = 1.1728;
                        result = input * euro_dollar_rate;
                        System.out.printf("%s" + input + " по курсу " + euro_dollar_rate + " Евро в %s = %s%.2f\n", euro_sym, us_dollar, euro_sym, result);
                    }
                    case 3 -> {
                        double euro_pound_rate = 0.792648;
                        result = input * euro_pound_rate;
                        System.out.printf("%s" + input + " по курсу " + euro_pound_rate + " Евро в %s = %s%.2f\n", euro_sym, pound, pound_sym, result);
                    }
                    case 4 -> {
                        double euro_yen_rate = 136.708;
                        result = input * euro_yen_rate;
                        System.out.printf("%s" + input + " по курсу " + euro_yen_rate + " Евро в %s = %s%.2f\n", euro_sym, yen, yen_sym, result);
                    }
                    case 5 -> {
                        double euro_bel_rub_rate = 2.9394;
                        result = input * euro_bel_rub_rate;
                        System.out.printf("%s" + input + " по курсу " + euro_bel_rub_rate + " Евро в %s = %s%.2f\n", euro_sym, bel_rub, bel_rub_sym, result);
                    }
                    case 6 -> {
                        double euro_rus_rub_rate = 84.875;
                        result = input * euro_rus_rub_rate;
                        System.out.printf("%s" + input + " по курсу " + euro_rus_rub_rate + " Евро в %s = %s%.2f\n", euro_sym, rus_rub, rus_rub_sym, result);
                    }
                }
            }
            //Английский фунт во все валюты
            case 3 -> {
                switch (output) {
                    case 1 -> {
                        double pound_dollar_rate = 1.60972;
                        result = input * pound_dollar_rate;
                        System.out.printf("%s" + input + " по курсу " + pound_dollar_rate + " Английский фунт в %s = %.2f\n", pound_sym, us_dollar, result);
                    } case 2 -> {
                        double pound_euro_rate = 1.26161;
                        result = input * pound_euro_rate;
                        System.out.printf("%s" + input + " по курсу " + pound_euro_rate + " Английский фунт в %s = %.2f\n", pound_sym, euro, result);
                    } case 4 -> {
                        double pound_yen_rate = 172.511;
                        result = input * pound_yen_rate;
                        System.out.printf("%s" + input + " по курсу " + pound_yen_rate + " Английский фунт в %s = %.2f\n", pound_sym, yen, result);
                    } case 5 -> {
                        double pound_bel_rub_rate = 3.4181;
                        result = input * pound_bel_rub_rate;
                        System.out.printf("%s" + input + " по курсу " + pound_bel_rub_rate + " Английский фунт в %s = %.2f\n", pound_sym, bel_rub, result);
                    } case 6 -> {
                        double pound_rus_rub_rate = 99.0681;
                        result = input * pound_rus_rub_rate;
                        System.out.printf("%s" + input + " по курсу " + pound_rus_rub_rate + " Английский фунт в %s = %.2f\n", pound_sym, rus_rub, result);
                    } case 7 -> {
                        double pound_zloty_rate = 5.4007;
                        result = input * pound_zloty_rate;
                        System.out.printf("%s" + input + " по курсу " + pound_zloty_rate + " Английский фунт в %s = %.2f\n", pound_sym, zloty, result);
                    }
                }
            }
            //Йена во все валюты
            case 4 -> {
                switch (output){
                    case 1 -> {
                        double yen_dollar_rate = 0.00932574;
                        result = input * yen_dollar_rate;
                        System.out.printf("%s" + input + " по курсу " + yen_dollar_rate + " Японская йена %s = %.2f\n", yen_sym, us_dollar, result);
                    } case 2 -> {
                        double yen_euro_rate = 0.00730615;
                        result = input * yen_euro_rate;
                        System.out.printf("%s" + input + " по курсу " + yen_euro_rate + " Японская йена %s = %.2f\n", yen_sym, euro, result);
                    } case 3 -> {
                        double yen_pound_rate = 0.00579135;
                        result = input * yen_pound_rate;
                        System.out.printf("%s" + input + " по курсу " + yen_pound_rate + " Японская йена %s = %.2f\n", yen_sym, pound, result);
                    } case 5 -> {
                        double yen_bel_rub_rate = 0.022;
                        result = input * yen_bel_rub_rate;
                        System.out.printf("%s" + input + " по курсу " + yen_bel_rub_rate + " Японская йена в %s = %.2f\n", yen_sym, bel_rub, result);
                    } case 6 -> {
                        double yen_rus_rub_rate = 65.16;
                        result = input * yen_rus_rub_rate;
                        System.out.printf("%s" + input + " по курсу " + yen_rus_rub_rate + " Японская йена в %s = %.2f\n", yen_sym, rus_rub, result);
                    } case 7 -> {
                        double yen_zloty_rate = 0.036;
                        result = input * yen_zloty_rate;
                        System.out.printf("%s" + input + " по курсу " + yen_zloty_rate + " Японская йена в %s = %.2f\n", yen_sym, zloty, result);
                    }
                }
            }
            //Бел руб во все валюты
            case 5 -> {
                switch (output) {
                    case 1 -> {
                        double bel_rub_dollar_rate = 0.3987;
                        result = input * bel_rub_dollar_rate;
                        System.out.printf("%s" + input + " по курсу " + bel_rub_dollar_rate + " Белорусский рубль в %s = %.2f\n", bel_rub_sym, us_dollar, result);
                    } case 2 -> {
                        double bel_rub_euro_rate = 0.342;
                        result = input * bel_rub_euro_rate;
                        System.out.printf("%s" + input + " по курсу " + bel_rub_euro_rate + " Белорусский рубль в %s = %.2f\n", bel_rub_sym, euro, result);
                    } case 3 -> {
                        double bel_rub_pound_rate = 0.29;
                        result = input * bel_rub_pound_rate;
                        System.out.printf("%s" + input + " по курсу " + bel_rub_pound_rate + " Белорусский рубль в %s = %.2f\n", bel_rub_sym, pound, result);
                    } case 4 -> {
                        double bel_rub_yen_rate = 44.74;
                        result = input * bel_rub_yen_rate;
                        System.out.printf("%s" + input + " по курсу " + bel_rub_yen_rate + " Белорусский рубль в %s = %.2f\n", bel_rub_sym, yen, result);
                    } case 6 -> {
                        double bel_rub_rus_rub_rate = 29.025;
                        result = input * bel_rub_rus_rub_rate;
                        System.out.printf("%s" + input + " по курсу " + bel_rub_rus_rub_rate + " Белорусский рубль в %s = %.2f\n", bel_rub_sym, rus_rub, result);
                    } case 7 -> {
                        double bel_rub_zloty_rate = 1.58;
                        result = input * bel_rub_zloty_rate;
                        System.out.printf("%s" + input + " по курсу " + bel_rub_zloty_rate + " Белорусский рубль в %s = %.2f\n", bel_rub_sym, zloty, result);
                    }
                }
            }
            // Рос руб во все валюты
            case 6 -> {
                switch (output) {
                    case 1 -> {
                        double rus_rub_dollar_rate = 0.0137;
                        result = input * rus_rub_dollar_rate;
                        System.out.printf("%s" + input + " по курсу " + rus_rub_dollar_rate + " Российский рубль в %s = %.2f\n", rus_rub_sym, us_dollar, result);
                    } case 2 -> {
                        double rus_rub_euro_rate = 0.012;
                        result = input * rus_rub_euro_rate;
                        System.out.printf("%s" + input + " по курсу " + rus_rub_euro_rate + " Российский рубль в %s = %.2f\n", rus_rub_sym, euro, result);
                    } case 3 -> {
                        double rus_rub_pound_rate = 0.0102;
                        result = input * rus_rub_pound_rate;
                        System.out.printf("%s" + input + " по курсу " + rus_rub_pound_rate + " Российский рубль в %s = %.2f\n", rus_rub_sym, pound, result);
                    } case 4 -> {
                        double rus_rub_yen_rate = 1.5347;
                        result = input * rus_rub_yen_rate;
                        System.out.printf("%s" + input + " по курсу " + rus_rub_yen_rate + " Российский рубль в %s = %.2f\n", rus_rub_sym, yen, result);
                    } case 5 -> {
                        double rus_rub_bel_rub_rate = 0.034;
                        result = input * rus_rub_bel_rub_rate;
                        System.out.printf("%s" + input + " по курсу " + rus_rub_bel_rub_rate + " Российский рубль в %s = %.2f\n", rus_rub_sym, bel_rub, result);
                    } case 7 -> {
                        double rus_rub_zloty_rate = 0.055;
                        result = input * rus_rub_zloty_rate;
                        System.out.printf("%s" + input + " по курсу " + rus_rub_zloty_rate + " Российский рубль в %s = %.2f\n", rus_rub_sym, zloty, result);
                    }
                }
            }
            // Злотый во все валюты
            case 7 -> {
                switch (output) {
                    case 1 -> {
                        double zloty_dollar_rate = 0.253;
                        result = input * zloty_dollar_rate;
                        System.out.printf("%s" + input + " по курсу " + zloty_dollar_rate + " Польский злотый в %s = %.2f\n", zloty_sym, us_dollar, result);
                    } case 2 -> {
                        double zloty_euro_rate = 0.2166;
                        result = input * zloty_euro_rate;
                        System.out.printf("%s" + input + " по курсу " + zloty_euro_rate + " Польский злотый в %s = %.2f\n", zloty_sym, euro, result);
                    } case 3 -> {
                        double zloty_pound_rate = 0.1852;
                        result = input * zloty_pound_rate;
                        System.out.printf("%s" + input + " по курсу " + zloty_pound_rate + " Польский злотый в %s = %.2f\n", zloty_sym, pound, result);
                    } case 4 -> {
                        double zloty_yen_rate = 28.04;
                        result = input * zloty_yen_rate;
                        System.out.printf("%s" + input + " по курсу " + zloty_yen_rate + " Польский злотый в %s = %.2f\n", zloty_sym, yen, result);
                    } case 5 -> {
                        double zloty_bel_rub_rate = 0.6329;
                        result = input * zloty_bel_rub_rate;
                        System.out.printf("%s" + input + " по курсу " + zloty_bel_rub_rate + " Польский злотый в %s = %.2f\n", zloty_sym, bel_rub, result);
                    } case 6 ->  {
                        double zloty_rus_rub_rate = 18.3435;
                        result = input * zloty_rus_rub_rate;
                        System.out.printf("%s" + input + " по курсу " + zloty_rus_rub_rate + " Польский злотый в %s = %.2f\n", zloty_sym, rus_rub, result);
                    } default ->{
                    }
                }
            }
        }
    }
    public static void Length() {
        double result;
        // Интерфейс
        System.out.println("Вы выбрали перевод единиц длины");
        System.out.println("Используйте следующие коды для ввода выбранной единицы длины:");
        System.out.println(" 1 - Километры \n 2 - Метры \n 3 - Дециметры \n 4 - Сантиметры \n 5 - Миллиметры \n 6 - Завершить конвертацию единиц длины \n");

        //Ввод первой величины и проверка
        int choice = getChoice(MAX_LENGTH, MIN_ANYTHING);
        if (choice == 6)
            return;
        String inType;
        switch (choice) {
            case 1 -> inType = "Километры >> ";
            case 2 -> inType = "Метры >> ";
            case 3 -> inType = "Дециметры >> ";
            case 4 -> inType = "Сантиметры >> ";
            case 5 -> inType = "Миллиметры >> ";
            default -> {
                return;
            }
        }
        //Ввод второй величины и проверка
        int output = getOutput(MAX_LENGTH, MIN_ANYTHING, choice);
        if (output == 6)
            return;

        //Ввод суммы перевода
        double input = getInput(inType);

        //Конвертация
        switch (choice) {
            //Километр во все величины
            case 1 -> {
                switch (output) {
                    case 2 -> {
                        double km_m_rate = 1000;
                        result = input * km_m_rate;
                        System.out.printf("Километр в метр: %f км = %.0f м\n", input, result);
                    }
                    case 3 -> {
                        double km_dcm_rate = 10000;
                        result = input * km_dcm_rate;
                        System.out.printf("Километр в дециметр: %f км = %.0f дм\n", input, result);
                    }
                    case 4 -> {
                        double km_cm_rate = 100000;
                        result = input * km_cm_rate;
                        System.out.printf("Километр в сантиметр: %f км = %.0f см\n", input, result);
                    }
                    case 5 -> {
                        double km_mm_rate = 1000000;
                        result = input * km_mm_rate;
                        System.out.printf("Километр в миллиметр: %f км = %.0f мм\n", input, result);
                    }
                }
            }
            //Метр во все величины
            case 2 -> {
                switch (output) {
                    case 1 -> {
                        double m_km_rate = 0.001;
                        result = input * m_km_rate;
                        System.out.printf("Метр в километр: %f м = %.0f км\n", input, result);
                    }
                    case 3 -> {
                        double m_dcm_rate = 10;
                        result = input * m_dcm_rate;
                        System.out.printf("Метр в дециметр: %f м = %.0f дцм\n", input, result);
                    }
                    case 4 -> {
                        double m_cm_rate = 100;
                        result = input * m_cm_rate;
                        System.out.printf("Метр в сантиметр: %f м = %.0f см\n", input, result);
                    }
                    case 5 -> {
                        double m_mm_rate = 1000;
                        result = input * m_mm_rate;
                        System.out.printf("Метр в миллиметр: %f м = %.0f мм\n", input, result);
                    }
                }
            }
            //Дециметр во все величины
            case 3 -> {
                switch (output) {
                    case 1 -> {
                        double dcm_km_rate = 0.0001;
                        result = input * dcm_km_rate;
                        System.out.printf("Дециметр в километр: %f дцм = %.0f км\n", input, result);
                    }
                    case 2 -> {
                        double dcm_m_rate = 0.1;
                        result = input * dcm_m_rate;
                        System.out.printf("Дециметр в метр: %f дцм = %.0f м\n", input, result);
                    }
                    case 4 -> {
                        double dcm_cm_rate = 10;
                        result = input * dcm_cm_rate;
                        System.out.printf("Дециметр в сантиметр: %f дцм = %.0f см\n", input, result);
                    }
                    case 5 -> {
                        double dcm_mm_rate = 100;
                        result = input * dcm_mm_rate;
                        System.out.printf("Дециметр в миллиметр: %f дцм = %.0f мм\n", input, result);
                    }
                }
            }
            //Сантиметр во все величины
            case 4 -> {
                switch (output) {
                    case 1 -> {
                        double cm_km_rate = 0.00001;
                        result = input * cm_km_rate;
                        System.out.printf("Сантиметр в километр: %f см = %.0f км\n", input, result);
                    }
                    case 2 -> {
                        double cm_m_rate = 0.01;
                        result = input * cm_m_rate;
                        System.out.printf("Сантиметр в метр: %f см = %.0f м\n", input, result);
                    }
                    case 3 -> {
                        double cm_dcm_rate = 0.1;
                        result = input * cm_dcm_rate;
                        System.out.printf("Сантиметр в децииметр: %f см = %.0f дцм\n", input, result);
                    }
                    case 5 -> {
                        double cm_mm_rate = 10;
                        result = input * cm_mm_rate;
                        System.out.printf("Сантиметр в миллиметр: %f см = %.0f мм\n", input, result);
                    }
                }
            }
            //Миллиметр во все величины
            case 5 -> {
                switch (output) {
                    case 1 -> {
                        double mm_km_rate = 0.000001;
                        result = input * mm_km_rate;
                        System.out.printf("Миллиметр в километр: %f мм = %.0f км\n", input, result);
                    }
                    case 2 -> {
                        double mm_m_rate = 0.001;
                        result = input * mm_m_rate;
                        System.out.printf("Миллиметр в метр: %f мм = %.0f м\n", input, result);
                    }
                    case 3 -> {
                        double mm_dcm_rate = 0.01;
                        result = input * mm_dcm_rate;
                        System.out.printf("Миллиметр в децииметр: %f мм = %.0f дцм\n", input, result);
                    }
                    case 4 -> {
                        double mm_cm_rate = 0.1;
                        result = input * mm_cm_rate;
                        System.out.printf("Миллиметр в сантиметр: %f мм = %.0f см\n", input, result);
                    }
                }
            }
        }
    }
    public static void Time() {
        double result;

        // Интерфейс
        System.out.println("Вы выбрали перевод единиц времени");
        System.out.println("Используйте следующие коды для ввода выбранной единицы времени:");
        System.out.println("1 - Года  \n 2 - Недели \n 3 - Дни \n 4 - Часы \n 5 - Минуты \n 6 - Секунды \n 7 - Миллисекунлы \n 8 - Заверщить конвертацию единиц времени");

        //Ввод первой величины и проверка
        int choice = getChoice(MAX_TIME, MIN_ANYTHING);
        if(choice == 8)
            return;
        String inType;
        switch (choice) {
            case 1 -> inType = "Годы >> ";
            case 2 -> inType = "Недели >> ";
            case 3 -> inType = "Дни >> ";
            case 4 -> inType = "Часы >> ";
            case 5 -> inType = "Минуты >> ";
            case 6 -> inType = "Секунды >> ";
            case 7 -> inType = "Миллисекунды >> ";
            default -> {
                return;
            }
        }
        //Ввод второй величины и проверка
        int output = getOutput(MAX_TIME, MIN_ANYTHING, choice);
        if(output == 8)
            return;

        //Ввод суммы перевода
        double input = getInput(inType);

        //Конвертация
        switch (choice) {
            //Годы во все величины
            case 1 -> {
                switch (output) {
                    case 2 -> {
                        double year_week_rate = 52.1428571;
                        result = input * year_week_rate;
                        System.out.printf("Годы в недели: %f лет = %.2f недели\n", input, result);
                    } case 3 -> {
                        double year_day_rate = 365;
                        result = input * year_day_rate;
                        System.out.printf("Годы в дни: %f лет = %.2f дней\n", input, result);
                    } case 4 -> {
                        double year_hour_rate = 8760;
                        result = input * year_hour_rate;
                        System.out.printf("Годы в часы: %f лет = %.2f часов\n", input, result);
                    } case 5 -> {
                        double year_minute_rate = 252600;
                        result = input * year_minute_rate;
                        System.out.printf("Годы в минуты: %f лет = %.2f минут\n", input, result);
                    } case 6 -> {
                        double year_second_rate = 31536000;
                        result = input * year_second_rate;
                        System.out.printf("Годы в секунды: %f лет = %.2f секунд\n", input, result);
                    } case 7 -> {
                        double year_millisecond_rate = 3.1536e10;
                        result = input * year_millisecond_rate;
                        System.out.printf("Годы в миллисекунды: %f лет = %.2f миллисекунды\n", input, result);
                    }

                }
            }
            //Недели во все величины
            case 2 -> {
                switch (output){
                    case 1 -> {


                    }
                }
            }
        }
    }
    public static void Square() {
        double result;
        System.out.println("Вы выбрали перевод единиц площади");
        System.out.println("Используйте следующие коды для ввода выбранной единицы площади:");
        System.out.println(" 1 - Квадратный километры  \n 2 - Гектары \n 3 - Ары \n 4 - Квадратные метры \n 5 - Квадратные дециметры \n 6 - Квадратные сантиметры \n 7 - Квадратные миллиметры \n 8 - Завершить конвертацию единиц площади \n");

        int choice = getChoice(MAX_SQUARE, MIN_ANYTHING);
        if (choice == 8)
            return;
        String inType;
        switch (choice) {
            case 1 -> inType = "Квадратные километры >> ";
            case 2 -> inType = "Гектары >> ";
            case 3 -> inType = "Ары >> ";
            case 4 -> inType = "Квадратные метры >> ";
            case 5 -> inType = "Квадратные дециметры >> ";
            case 6 -> inType = "Квадратные сантиметры >> ";
            case 7 -> inType = "Квадратные миллиметры >> ";
            default -> {
                return;
            }
        }
        //Ввод второй величины и проверка
        int output = getOutput(MAX_SQUARE, MIN_ANYTHING, choice);
        if (output == 8)
            return;

        //Ввод суммы перевода
        double input = getInput(inType);

        switch (choice) {
            //Квадратные километры во все величины
            case 1 -> {
                switch (output) {
                    case 2 -> {
                        double sqrkm_gek_rate = 100;
                        result = input * sqrkm_gek_rate;
                        System.out.printf("Квадратные километры в Гектары: %f кв.км = %.2f гектаров\n", input, result);
                    }
                    case 3 -> {
                        double sqrkm_ar_rate = 1E4;
                        result = input * sqrkm_ar_rate;
                        System.out.printf("Квадратные километры в Ары: %f кв.км = %.2f ар\n", input, result);
                    }
                    case 4 -> {
                        double sqrkm_sqrm_rate = 1E6;
                        result = input * sqrkm_sqrm_rate;
                        System.out.printf("Квадратные километры в Квадратные метры: %f кв.км = %.2f кв.м\n", input, result);
                    }
                    case 5 -> {
                        double sqrkm_sqrdm_rate = 1E8;
                        result = input * sqrkm_sqrdm_rate;
                        System.out.printf("Квадратный километры в Квадратные дециметры: %f кв.км = %.2f кв.дм\n", input, result);
                    }
                    case 6 -> {
                        double sqrkm_sqrcm_rate = 1E10;
                        result = input * sqrkm_sqrcm_rate;
                        System.out.printf("Квадратные километры в Квадратные сантиметры: %f кв.км = %.2f кв.см\n", input, result);
                    }
                    case 7 -> {
                        double sqrkm_sqrmm_rate = 1E12;
                        result = input * sqrkm_sqrmm_rate;
                        System.out.printf("Квадратные километры в Квадратные миллиметры: %f кв.км = %.2f кв.мм\n", input, result);
                    }

                }
            }
            //Гектары во все величины
            case 2 -> {
                switch (output) {
                    case 1 -> {
                        double gek_sqrkm_rate = 0.01;
                        result = input * gek_sqrkm_rate;
                        System.out.printf("Гектары в квадратные километры: %f гектаров = %.2f кв.км\n", input, result);
                    }
                    case 3 -> {
                        double gek_ar_rate = 100;
                        result = input * gek_ar_rate;
                        System.out.printf("Гектары в квадратные в Ары: %f гектаров = %.2f ар\n", input, result);
                    }
                    case 4 -> {
                        double gek_sqrm_rate = 1E4;
                        result = input * gek_sqrm_rate;
                        System.out.printf("Гектары в квадратные метры: %f гектаров = %.2f кв.м\n", input, result);
                    }
                    case 5 -> {
                        double gek_sqrdm_rate = 1E6;
                        result = input * gek_sqrdm_rate;
                        System.out.printf("Гектары в квадратные дециметры: %f гектаров = %.2f кв.дм\n", input, result);
                    }
                    case 6 -> {
                        double gek_sqrcm_rate = 1E8;
                        result = input * gek_sqrcm_rate;
                        System.out.printf("Гектары в квадратные сантиметры: %f гектаров = %.2f кв.см\n", input, result);
                    }
                    case 7 -> {
                        double gek_sqrmm_rate = 1E10;
                        result = input * gek_sqrmm_rate;
                        System.out.printf("Гектары в квадратные миллиметры: %f гектаров = %.2f кв.мм\n", input, result);
                    }

                }
            }
            //Ары во все величины
            case 3 -> {
                switch (output) {
                    case 1 -> {
                        double ar_sqrkm_rate = 1E-4;
                        result = input * ar_sqrkm_rate;
                        System.out.printf("Ары в квадратные километры: %f ар = %.2f кв.км\n", input, result);
                    }
                    case 2 -> {
                        double ar_gek_rate = 0.01;
                        result = input * ar_gek_rate;
                        System.out.printf("Ары в гектары: %f ар = %.2f гектаров\n", input, result);
                    }
                    case 4 -> {
                        double ar_sqrm_rate = 100;
                        result = input * ar_sqrm_rate;
                        System.out.printf("Ары в квадратные метры: %f ар = %.2f кв.м\n", input, result);
                    }
                    case 5 -> {
                        double ar_sqrdm_rate = 1E4;
                        result = input * ar_sqrdm_rate;
                        System.out.printf("Ары в квадратные дециметры: %f ар = %.2f кв.дм\n", input, result);
                    }
                    case 6 -> {
                        double ar_sqrcm_rate = 1E6;
                        result = input * ar_sqrcm_rate;
                        System.out.printf("Ары в квадратные сантиметры: %f ар = %.2f кв.см\n", input, result);
                    }
                    case 7 -> {
                        double ar_sqrmm_rate = 1E8;
                        result = input * ar_sqrmm_rate;
                        System.out.printf("Ары в квадратные миллиметры: %f ар = %.2f кв.мм\n", input, result);
                    }

                }
            }
            //Квадратные метры во все велчины
            case 4 -> {
                switch (output) {
                    case 1 -> {
                        double sqrm_sqrkm_rate = 1E-6;
                        result = input * sqrm_sqrkm_rate;
                        System.out.printf("Квадратные метры в квадратные километры: %f кв.м = %.2f кв.км\n", input, result);
                    }
                    case 2 -> {
                        double sqrm_gek_rate = 1E-4;
                        result = input * sqrm_gek_rate;
                        System.out.printf("Квадратные метры в гектары: %f кв.м = %.2f гектаров\n", input, result);
                    }
                    case 3 -> {
                        double sqrm_ar_rate = 0.01;
                        result = input * sqrm_ar_rate;
                        System.out.printf("Квадратные метры в ары: %f кв.м = %.2f ар\n", input, result);
                    }
                    case 5 -> {
                        double sqrm_sqrdm_rate = 10;
                        result = input * sqrm_sqrdm_rate;
                        System.out.printf("Квадратные метры в квадратные дециметры: %f кв.м = %.2f кв.дм\n", input, result);
                    }
                    case 6 -> {
                        double sqrm_sqrcm_rate = 1E4;
                        result = input * sqrm_sqrcm_rate;
                        System.out.printf("Квадратные метры в квадратные сантиметры: %f кв.м = %.2f кв.см\n", input, result);
                    }
                    case 7 -> {
                        double sqrm_sqrmm_rate = 1E6;
                        result = input * sqrm_sqrmm_rate;
                        System.out.printf("Квадратные метры в квадратные миллиметры: %f кв.м = %.2f кв.мм\n", input, result);
                    }

                }
            }
            //Квадратные дециметры во все велчины
            case 5 -> {
                switch (output) {
                    case 1 -> {
                        double sqrdm_sqrkm_rate = 1E-8;
                        result = input * sqrdm_sqrkm_rate;
                        System.out.printf("Квадратные дециметры в квадратные километры: %f кв.дм = %.2f кв.км\n", input, result);
                    }
                    case 2 -> {
                        double sqrdm_gek_rate = 1E-6;
                        result = input * sqrdm_gek_rate;
                        System.out.printf("Квадратные дециметры в гектары: %f кв.дм = %.2f гектаров\n", input, result);
                    }
                    case 3 -> {
                        double sqrdm_ar_rate = 1E-4;
                        result = input * sqrdm_ar_rate;
                        System.out.printf("Квадратные дециметры в ары: %f кв.дм = %.2f ар\n", input, result);
                    }
                    case 4 -> {
                        double sqrdm_sqrm_rate = 0.01;
                        result = input * sqrdm_sqrm_rate;
                        System.out.printf("Квадратные дециметры в квадратные метры: %f кв.дм = %.2f кв.м\n", input, result);
                    }
                    case 6 -> {
                        double sqrdm_sqrcm_rate = 100;
                        result = input * sqrdm_sqrcm_rate;
                        System.out.printf("Квадратные дециметры в квадратные сантиметры: %f кв.дм = %.2f кв.см\n", input, result);
                    }
                    case 7 -> {
                        double sqrdm_sqrmm_rate = 1E4;
                        result = input * sqrdm_sqrmm_rate;
                        System.out.printf("Квадратные дециметры в квадратные миллиметры: %f кв.дм = %.2f кв.мм\n", input, result);
                    }

                }
            }
            //Квадратные сантиметры во все велчины
            case 6 -> {
                switch (output) {
                    case 1 -> {
                        double sqrcm_sqrkm_rate = 1E-10;
                        result = input * sqrcm_sqrkm_rate;
                        System.out.printf("Квадратные сантиметры в квадратные километры: %f кв.см = %.2f кв.км\n", input, result);
                    }
                    case 2 -> {
                        double sqrcm_gek_rate = 1E-8;
                        result = input * sqrcm_gek_rate;
                        System.out.printf("Квадратные сантиметры в гектары: %f кв.см = %.2f гектаров\n", input, result);
                    }
                    case 3 -> {
                        double sqrcm_ar_rate = 1E-6;
                        result = input * sqrcm_ar_rate;
                        System.out.printf("Квадратные сантиметры в ары: %f кв.см = %.2f ар\n", input, result);
                    }
                    case 4 -> {
                        double sqrcm_sqrm_rate = 1E-4;
                        result = input * sqrcm_sqrm_rate;
                        System.out.printf("Квадратные сантиметры в квадратные метры: %f кв.см = %.2f кв.м\n", input, result);
                    }
                    case 5 -> {
                        double sqrcm_sqrdm_rate = 0.01;
                        result = input * sqrcm_sqrdm_rate;
                        System.out.printf("Квадратные сантиметры в квадратные децииметры: %f кв.см = %.2f кв.дм\n", input, result);
                    }
                    case 7 -> {
                        double sqrcm_sqrmm_rate = 100;
                        result = input * sqrcm_sqrmm_rate;
                        System.out.printf("Квадратные сантиметры в квадратные миллиметры: %f кв.см = %.2f кв.мм\n", input, result);
                    }

                }
            }
            //Квадратные сантиметры во все велчины
            case 7 -> {
                switch (output) {
                    case 1 -> {
                        double sqrmm_sqrkm_rate = 1E-12;
                        result = input * sqrmm_sqrkm_rate;
                        System.out.printf("Квадратные миллиметры в квадратные километры: %f кв.мм = %.2f кв.км\n", input, result);
                    }
                    case 2 -> {
                        double sqrmm_gek_rate = 1E-10;
                        result = input * sqrmm_gek_rate;
                        System.out.printf("Квадратные миллиметры в гектары: %f кв.мм = %.2f гектаров\n", input, result);
                    }
                    case 3 -> {
                        double sqrmm_ar_rate = 1E-8;
                        result = input * sqrmm_ar_rate;
                        System.out.printf("Квадратные миллиметры в ары: %f кв.мм = %.2f ар\n", input, result);
                    }
                    case 4 -> {
                        double sqrmm_sqrm_rate = 1E-6;
                        result = input * sqrmm_sqrm_rate;
                        System.out.printf("Квадратные миллиметры в квадратные метры: %f кв.мм = %.2f кв.м\n", input, result);
                    }
                    case 5 -> {
                        double sqrmm_sqrdm_rate = 1E-4;
                        result = input * sqrmm_sqrdm_rate;
                        System.out.printf("Квадратные миллиметры в квадратные децииметры: %f кв.мм = %.2f кв.дм\n", input, result);
                    }
                    case 6 -> {
                        double sqrmm_sqrcm_rate = 0.01;
                        result = input * sqrmm_sqrcm_rate;
                        System.out.printf("Квадратные миллииметры в квадратные сантииметры: %f кв.мм = %.2f кв.см\n", input, result);
                    }

                }
            }
        }
    }
    public static void Volume() {
        double result;
        System.out.println("Вы выбрали перевод единиц объёма");
        System.out.println("Используйте следующие коды для ввода выбранной единицы объёма:");
        System.out.println(" 1 - Кубические метры  \n 2 - Кубические дециметры \n 3 - Кубические сантиметры \n 4 - Кубические миллиметры \n 5 - Литры \n 6 - Миллилитры \n 7 - Завершить конвертацию единиц объёма \n");

        int choice = getChoice(MAX_VOLUME, MIN_ANYTHING);
        if(choice == 7)
            return;

        String inType;
        switch (choice) {
            case 1 -> inType = "Кубические метры >> ";
            case 2 -> inType = "Кубические дециметры >> ";
            case 3 -> inType = "Кубические сантиметры >> ";
            case 4 -> inType = "Кубические миллиметры >> ";
            case 5 -> inType = "Литры >> ";
            case 6 -> inType = "Миллилитры >> ";
            default -> {
                return;
            }
        }
        //Ввод второй величины и проверка
        int output = getOutput(MAX_VOLUME, MIN_ANYTHING, choice);
        if(output == 7)
            return;

        //Ввод суммы перевода
        double input = getInput(inType);
    }
    public static void Speed() {
        double result;
        System.out.println("Вы выбрали перевод единиц скорости");
        System.out.println("Используйте следующие коды для ввода выбранной единицы скорости:");
        System.out.println(" 1 - Метры в секунду  \n 2 - Километры в час \n 3 - Километры в секунду \n 4 - Завершить конвертацию единиц скорости \n");

        int choice = getChoice(MAX_SPEED, MIN_ANYTHING);
        if(choice == 4)
            return;
        String inType;
        switch (choice) {
            case 1 -> inType = "Метры в секунду >> ";
            case 2 -> inType = "Километры в час >> ";
            case 3 -> inType = "Километры в секунду >> ";
            default -> {
                return;
            }
        }
        //Ввод второй величины и проверка
        int output = getOutput(MAX_SPEED, MIN_ANYTHING, choice);
        if(output == 4)
            return;

        //Ввод суммы перевода
        double input = getInput(inType);

        double rate;

        switch (choice) {
            //Метры в секунду во все величины
            case 1 -> {
                switch (output) {
                    case 2 -> {
                        rate = 3.6;
                        result = input * rate;
                        System.out.printf("М/с в км/ч: %f м/с = %.2f км/ч\n", input, result);
                    }
                    case 3 -> {
                        rate = 0.001;
                        result = input * rate;
                        System.out.printf("М/с в км/с: %f м/с = %.2f км/с\n", input, result);
                    }
                }
            }
            //Километры в час во все велчины
            case 2 -> {
                switch (output) {
                    case 1 -> {
                        rate = 0.277778;
                        result = input * rate;
                        System.out.printf("Км/ч в м/с: %f км/ч = %.2f м/с\n", input, result);
                    }
                    case 3 -> {
                        rate = 0.000277778;
                        result = input * rate;
                        System.out.printf("км/ч в км/с: %f км/ч = %.2f км/с\n", input, result);
                    }
                }
            }//Километры в секунду во все велчины
            case 3 -> {
                switch (output) {
                    case 1 -> {
                        rate = 1000;
                        result = input * rate;
                        System.out.printf("Км/с в м/с: %f км/с = %.2f м/с\n", input, result);
                    }
                    case 2 -> {
                        rate = 3600;
                        result = input * rate;
                        System.out.printf("км/с в км/ч: %f км/с = %.2f км/ч\n", input, result);
                    }
                }
            }
        }
    }
    public static void Temperature() {
        char grad = 176;
        double result;
        System.out.println("Вы выбрали перевод единиц температуры");
        System.out.println("Используйте следующие коды для ввода выбранной единицы температуры:");
        System.out.println(" 1 - Градусы Цельсия  \n 2 - Градусы Фаренгейта \n 3 - Кельвины \n 4 - Завершить конвертацию единиц температуры \n");

        int choice = getChoice(MAX_TEMPERATURE, MIN_ANYTHING);
        if(choice == 4)
            return;

        String inType;
        switch (choice) {
            case 1 -> inType = "Градусы Цельсия >> ";
            case 2 -> inType = "Градусы Фаренгейта >> ";
            case 3 -> inType = "Кельвины >> ";
            default -> {
                return;
            }
        }
        //Ввод второй величины и проверка
        int output = getOutput(MAX_TEMPERATURE, MIN_ANYTHING, choice);
        if(output == 4)
            return;

        //Ввод суммы перевода
        double input = getInput(inType);

        switch (choice) {
            //Градусы Цельсия во все величины
            case 1 -> {
                switch (output) {
                    case 2 -> {
                        result = (input * 9 / 5) + 32;
                        System.out.printf("Градусы Цельсия в Градусы Фаренгейта: %f %sC = %.2f %sF\n", input, grad, result, grad);
                    }
                    case 3 -> {
                        result = input + 273.15;
                        System.out.printf("Градусы Цельсия в Кельвины: %f %sC = %.2f K\n", input,grad, result);
                    }
                }
            }
            //Градусы Фаренгейта во все величины
            case 2 -> {
                switch (output) {
                    case 1 -> {
                        result = (input - 32) * 5 / 9;
                        System.out.printf("Градусы Фаренгейта в Градусы Цельсия: %f %sF = %.2f %sC\n", input, grad, result, grad);
                    }
                    case 3 -> {
                        result = (input - 32) * 5 / 9 + 273.15;
                        System.out.printf("Градусы Фаренгейта в Кельвины: %f %sF = %.2f K\n", input,grad, result);
                    }
                }
            }
            //Кельвины во все величины
            case 3 -> {
                switch (output) {
                    case 1 -> {
                        result = input - 273.15;
                        System.out.printf("Кельвины в Градусы Цельсия: %f K = %.2f %sC\n", input, result, grad);
                    }
                    case 2 -> {
                        result = (input - 273.15) * 9 / 5 + 32;
                        System.out.printf("Кельвины в Градусы Фаренгейта: %f K= %.2f %sF\n", input, result, grad);
                    }
                }
            }
        }
    }
    public static void Weight() {
        double result;
        System.out.println("Вы выбрали перевод единиц массы");
        System.out.println("Используйте следующие коды для ввода выбранной единицы массы:");
        System.out.println(" 1 - Тонны  \n 2 - Центнеры \n 3 - Килограммы \n 4 - Граммы \n 5 - Миллиграммы \n 6 - Фунты \n 7 - Завершить конвертацию единиц массы \n");

        int choice = getChoice(MAX_WEIGHT, MIN_ANYTHING);
        if(choice == 7)
            return;
        String inType;
        switch (choice) {
            case 1 -> inType = "Тонны >> ";
            case 2 -> inType = "Центнеры >> ";
            case 3 -> inType = "Килограммы >> ";
            case 4 -> inType = "Граммы >> ";
            case 5 -> inType = "Миллиграммы >> ";
            case 6 -> inType = "Фунты >> ";
            default -> {
                return;
            }
        }
        //Ввод второй величины и проверка
        int output = getOutput(MAX_WEIGHT, MIN_ANYTHING, choice);
        if(output == 7)
            return;

        //Ввод суммы перевода
        double input = getInput(inType);
    }

    public static void main(String[] args) {
        boolean isIncorrect;
        boolean isTrue;
        System.out.println("Добро пожаловать в программу конвертации величин");
        do {
            System.out.println("\n***********************************************************************************\nИспользуйте следующие коды для выбора величины для конвертации: \n 1 - Валюта \n 2 - Длина \n 3 - Время \n 4 - Площадь \n 5 - Объём \n 6 - Скорость \n 7 - Температура \n 8 - Масса \n 9 - Завершить программу \n");

            isTrue = true;
            int choice = 0;
            do {
                isIncorrect = false;
                System.out.print("Выберите величину для конвертации:");
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                } catch (Exception e) {
                    System.out.println("Вы ввели неподходящий код величины");
                    isIncorrect = true;
                }
                if (!isIncorrect && (choice < 1) || (choice > 9)) {
                    System.out.println("Вы ввели неподходящий код величины");
                    choice = 0;
                    isIncorrect = true;
                }
            } while (isIncorrect);

            switch (choice) {
                case 1 ->Currency();
                case 2 -> Length();
                case 3 -> Time();
                case 4 -> Square();
                case 5 -> Volume();
                case 6 -> Speed();
                case 7 -> Temperature();
                case 8 -> Weight();
                case 9 -> isTrue = false;
            }
        } while (isTrue);
        scanner.close();
    }
}

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.Scanner;

public class Main {
    private static final String VALIDATE_PATTERN = "^[A-Za-z0-9_]+$"; // условие для логина и пароля

    public static Scanner scanner = new Scanner(System.in); // вывод логина в консоль

    public static void main(String[] args) {
        System.out.println("Введите логин");
        String login = scanner.nextLine();
        try {
            checkLogin(login);
        } catch (WrongLoginException exception){
            System.out.println(exception.getMessage());
        }
        System.out.print("Введите пароль: ");
        String password = scanner.nextLine();
        System.out.print("Повторите пароль: ");
        String confirmPassword = scanner.nextLine();
        try {
            checkPasswords(password,confirmPassword);
        } catch (WrongPasswordException exception){
            System.out.println(exception.getMessage());
        }



    }

    public static void checkLogin(String login) throws WrongLoginException{
        if(login.length() >= 20){
            throw new WrongLoginException("Ошибка! Превышена длина логина.");
        }

        CharacterIterator it = new StringCharacterIterator(login);
        while (it.current() != CharacterIterator.DONE)
        {
            if(!login.matches(VALIDATE_PATTERN)){
                throw new WrongLoginException("Ошибка! Используются недопустимые символы");
            }
            it.next();
        }
    }
    public static void checkPasswords(String password, String confirmPassword) throws WrongPasswordException{

        if(!password.equals(confirmPassword)){
            throw new WrongPasswordException("Ошибка! Пароли не одинаковые.");
        }

        if(password.length() >= 12){
            throw new WrongPasswordException("Ошибка! Превышена длина логина.");
        }

        char[] character = password.toCharArray();
        for (char ch: character) {
            if(!password.matches(VALIDATE_PATTERN)){
                throw new WrongPasswordException("Ошибка! Используются недопустимые символы");
            }
        }

    }
}

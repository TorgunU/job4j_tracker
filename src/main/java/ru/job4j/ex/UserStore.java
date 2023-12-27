package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User find = null;
        for (User user : users) {
            if (user.getUsername().equals(login)) {
                find = user;
                break;
            }
        }
        if (find == null) {
            throw new UserNotFoundException("Пользователь не найден");
        }
        return find;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid() || user.getUsername().length() < 3) {
            throw new UserInvalidException("Пользователь не валидный");
        }
        return true;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true),
                new User("Ivan", false)
        };
        try {
            User user = findUser(users, "Iv");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException userInvalidException) {
            System.out.println(userInvalidException.getMessage());
        } catch (UserNotFoundException userNotFoundException) {
            System.out.println(userNotFoundException.getMessage());
        }
    }
}
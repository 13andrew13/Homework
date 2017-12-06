package my.prog;

import my.prog.Factoy.Factory;
import my.prog.controller.UserController;
import my.prog.model.User;

public class Main {
    public static void main (String[] args) {
        UserController controller = Factory.getController (Factory.getUserSevice (Factory.getUserDAO ()));
        User user = new User ();
        user.setName ("Anton");
        user.setEmail ("anton@mail.ru");
        user.setPassword ("12345678");

        controller.create (user);
        user = new User ();
        user.setName ("Andrew");
        user.setEmail ("andrew1304@mail.ru");
        user.setId (6l);
        controller.update (user);






    }
}

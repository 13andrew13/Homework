package my.prog;

import my.prog.Factoy.Factory;
import my.prog.controller.UserController;
import my.prog.model.User;

public class Main {
    public static void main (String[] args) {
        UserController controller = Factory.getController (Factory.getUserSevice (Factory.getUserDAO ()));
        User user = new User ();
        User del = new User();
        del.setName ("Anton");
        user.setId (2l);
        user.setName ("Anton");
        user.setEmail ("anton@mail.ru");
        user.setPassword ("258486");


        System.out.println (controller.create (user));
        user = new User ();
        user.setEmail ("dsad");
        System.out.println (controller.delete (user));




    }
}

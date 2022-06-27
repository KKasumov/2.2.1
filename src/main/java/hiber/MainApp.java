package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);


      userService.add(new User("Арнольд", "Шварценеггер", "arni@mail.ru", new Car ("Лада", 2106)));
      userService.add(new User("Сильвестр", "Сталлоне", "slay@mail.ru", new Car ("Волга", 3110)));
      userService.add(new User("Жан-Клод", "Ван Дамм", "JCVD@mail.ru", new Car ("Москвич", 2141)));
      userService.add(new User("Брюс", "Ли", "dragon@mail.ru", new Car ("УАЗ", 469)));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = " +user.getCar());
         System.out.println();
      }

      context.close();
   }
}

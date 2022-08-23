package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User vasiliy = new User("Vasiliy", "Dubrov", "vd@mail.ru", new Car("Aston Martin", 3));
      User anastasia = new User("Anastasia", "Frolova", "af@mail.ru", new Car("Cadillac CTS", 8));
      User gleb = new User("Gleb", "Ozhiganov", "go@mail.ru", new Car("Leyat Helica", 5));

      userService.add(vasiliy);
      userService.add(anastasia);
      userService.add(gleb);

      System.out.println(userService.listUsers());

      System.out.println(userService.getUserByModelAndSeries("Cadillac CTS", 8));

      context.close();
   }
}

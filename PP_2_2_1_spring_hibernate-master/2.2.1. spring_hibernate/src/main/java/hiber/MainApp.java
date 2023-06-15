package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));

      User user1 = new User("User1", "Lastname1", "user1@mail.ru");
      Car car1 = new Car("Matiz", 7);
      car1.setUser(user1);
      user1.setCar(car1);
      userService.add(user1);

      User user2 = new User("User2", "Lastname2", "user2@mail.ru");
      Car car2 = new Car("Mercedes", 124);
      car2.setUser(user2);
      user2.setCar(car2);
      userService.add(user2);

//      List<User> users = userService.listUsers();
//      for (User user : users) {
//         System.out.println("Id = " + user.getId());
//         System.out.println("First Name = " + user.getFirstName());
//         System.out.println("Last Name = " + user.getLastName());
//         System.out.println("Email = " + user.getEmail());
//         System.out.println("Car = " + user.getCar());
//         System.out.println();
//      }

      User user3 = userService.getUserByCar("Mercedes", 124);
      System.out.println("Person with car: " + user3);

      context.close();
   }
}

package security;

import java.util.Scanner;

/**
 *
 * @author nicolas
 */
public class StockFactory implements SecurityFactory {

    public Security createSecurity(Scanner sc) {
        System.out.println("Enter code, name and stock exchange:");
        sc.nextLine();
        String command = sc.nextLine();
        String[] cmd = command.split(",");
        String code = cmd[0];
        String name = cmd[1];
        String exchange = cmd[2];
        System.out.println("New security record created.");
        return new Stock(code, name, exchange, 0);
    }
}

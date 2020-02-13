package security;
import static java.lang.Float.parseFloat;
import java.util.Scanner;

/**
 *
 * @author nicolas
 */
public class BondFactory implements SecurityFactory {
    public Security createSecurity(Scanner sc) {        
        System.out.println("Enter code, name and yieId");        
        sc.nextLine();
        String command = sc.nextLine();
        String[] cmd = command.split(",");
        String code = cmd[0];
        String name = cmd[1];
        float yie = parseFloat(cmd[2]);               
        System.out.println("New security record created.");        
        return new Bond(code,name,yie,0);
    }
}
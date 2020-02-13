package security;

import java.util.Scanner;
import java.util.Stack;
import security.Security;

/**
 *
 * @author nicolas
 */
public interface SecurityFactory {
    public abstract Security createSecurity(Scanner sc);
}

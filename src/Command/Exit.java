package Command;

/**
 *
 * @author nicolas
 */
public class Exit implements Command{
   
    public void execute() {
        System.exit(0);
    }
    
    public void undo() {

    }

    @Override
    public void redo() {
        
    }
}

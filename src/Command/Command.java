package Command;
/**
 *
 * @author nicolas
 */
public interface Command {

    abstract void execute();

    abstract void undo();
    
    abstract void redo();
    
}

package invoker;

import command.Command;

public class Invoker {
    private final Command onCommand;
    private final Command offCommand;
    private final Command opCommand;
    private final Command downCommand;

    public Invoker(Command onCommand, Command offCommand, Command opCommand, Command downCommand) {
        this.onCommand = onCommand;
        this.offCommand = offCommand;
        this.opCommand = opCommand;
        this.downCommand = downCommand;
    }

    public void clickOn(){
        onCommand.execute();
    }

    public void clickOff(){
        offCommand.execute();
    }

    public void clickOp(){
        opCommand.execute();
    }

    public void clickDown(){
        downCommand.execute();
    }
}

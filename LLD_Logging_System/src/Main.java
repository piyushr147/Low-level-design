import logger.Logger;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.debug("This is a debug message");
        logger.warn("This is a warn message");
        logger.error("This is an error message");
        logger.info("This is a info message");
    }
}
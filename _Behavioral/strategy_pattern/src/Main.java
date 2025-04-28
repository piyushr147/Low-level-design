import WithStrategy.Controller.RouteController;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        RouteController routeController = new RouteController();
        routeController.navigate("cab");
    }
}
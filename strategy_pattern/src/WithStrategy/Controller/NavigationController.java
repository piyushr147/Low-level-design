package WithStrategy.Controller;

import WithStrategy.service.RouteService;
import WithStrategy.strategy.ConcreteStrategy.BusStrategy;
import WithStrategy.strategy.ConcreteStrategy.CabStrategy;
import WithStrategy.strategy.ConcreteStrategy.WalkStrategy;
import WithStrategy.strategy.StrategyInterface.RouteStrategy;

public class NavigationController {
    private RouteService routeService = new RouteService();

    public void navigate(String userChoice) {
        RouteStrategy strategy = getStrategy(userChoice);
        if (strategy != null) {
            routeService.setStrategy(strategy);
            routeService.calculateTime();  // Assuming execute logic exists in RouteService
        } else {
            System.out.println("Invalid choice! Please select bus, cab, or walk.");
        }
    }

    private RouteStrategy getStrategy(String userChoice) {
        switch (userChoice.toLowerCase()) {
            case "bus":
                return new BusStrategy();
            case "cab":
                return new CabStrategy();
            case "walk":
                return new WalkStrategy();
            default:
                return null;  // Invalid choice handling
        }
    }
}

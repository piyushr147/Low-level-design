package WithStrategy.service;

import WithStrategy.strategy.ConcreteStrategy.BusStrategy;
import WithStrategy.strategy.StrategyInterface.RouteStrategy;

public class RouteService {
    public RouteStrategy userRouteStrategy;
    public void RouteStrategy(RouteStrategy routeStrategy){
        userRouteStrategy = routeStrategy;
    }
    public int calculateTime(){
        return userRouteStrategy.calculateTime();
    }

    public void setStrategy(RouteStrategy routeStrategy) {
        userRouteStrategy = routeStrategy;
    }
}

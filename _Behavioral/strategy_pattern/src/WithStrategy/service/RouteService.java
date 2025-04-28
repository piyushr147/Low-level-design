package WithStrategy.service;

import WithStrategy.strategy.StrategyInterface.RouteStrategy;

public class RouteService {
    public RouteStrategy userRouteStrategy;

    public void RouteStrategy(RouteStrategy routeStrategy){
        userRouteStrategy = routeStrategy;
    }

    public void calculateTime(){
        userRouteStrategy.calculateTime();
    }

    public void calculateShortestPath(){
        userRouteStrategy.calculateShortestPath();
    }


    public void setStrategy(RouteStrategy routeStrategy) {
        userRouteStrategy = routeStrategy;
    }
}

package WithStrategy.strategy.ConcreteStrategy;

import WithStrategy.strategy.StrategyInterface.TransportStrategy;

public class BusStrategy implements TransportStrategy {
    @Override
    public int calculateTime() {
        System.out.println("bus calculating time");
        return 0;
    }

    @Override
    public int calculateShortestPath() {
        System.out.println("bus calculating shortest path");
        return 0;
    }

    @Override
    public int calculateFare() {
        System.out.println("bus calculating fare");
        return 0;
    }
}

package WithStrategy.strategy.ConcreteStrategy;

import WithStrategy.strategy.StrategyInterface.TransportStrategy;

public class CabStrategy implements TransportStrategy {
    @Override
    public int calculateTime() {
        System.out.println("cab calculating time");
        return 0;
    }

    @Override
    public int calculateShortestPath() {
        System.out.println("cab calculating shortest path");
        return 0;
    }

    @Override
    public int calculateFare() {
        System.out.println("cab calculating time");
        return 0;
    }
}

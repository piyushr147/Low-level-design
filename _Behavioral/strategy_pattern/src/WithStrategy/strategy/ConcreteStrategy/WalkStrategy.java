package WithStrategy.strategy.ConcreteStrategy;

import WithStrategy.strategy.StrategyInterface.NoTransportStrategy;

public class WalkStrategy implements NoTransportStrategy {
    @Override
    public int calculateSteps() {
        System.out.println("walk calculating steps");
        return 0;
    }

    @Override
    public int calculateTime() {
        System.out.println("walk calculating time");
        return 0;
    }

    @Override
    public int calculateShortestPath() {
        System.out.println("walk calculating shortest path");
        return 0;
    }
}

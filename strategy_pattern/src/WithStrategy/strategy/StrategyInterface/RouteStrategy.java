package WithStrategy.strategy.StrategyInterface;

import WithStrategy.strategy.ConcreteStrategy.BusStrategy;

public interface RouteStrategy {
    public int calculateTime();
    public int calculateShortestPath();
}

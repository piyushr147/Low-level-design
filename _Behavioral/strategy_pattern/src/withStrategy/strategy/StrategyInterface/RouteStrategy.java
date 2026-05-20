package WithStrategy.strategy.StrategyInterface;

public interface RouteStrategy {
    public int calculateTime();
    public int calculateShortestPath();

    default Optional<Integer> calculateFare(){
        return Optional.empty();
    }
    default Optional<Integer> calculateSteps(){
        return Optional.empty();
    }
}

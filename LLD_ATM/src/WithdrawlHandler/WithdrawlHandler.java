package WithdrawlHandler;

public abstract class WithdrawlHandler {
    private WithdrawlHandler nextHandler;

    public WithdrawlHandler(WithdrawlHandler nextHandler){
        this.nextHandler = nextHandler;
    }

    public boolean applyChain(int remainingAmount){
        return nextHandler.applyChain(remainingAmount);
    }
}

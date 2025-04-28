package interfaces;

import userData.UserData;

public abstract class Security {
    protected Security securityNext;

    public void setSecurityNext(Security securityNext){
        this.securityNext = securityNext;
    }
    public abstract boolean applyChain(UserData userData);
}

package interfaces;

import userData.UserData;

public abstract class SecurityFilter {
    private SecurityFilter next;

    public SecurityFilter setNext(SecurityFilter next){
        this.next = next;
        return next;
    }

    public boolean doFilter(UserData userData){
        if(next != null)
            return next.doFilter(userData);
        return false;
    }
}

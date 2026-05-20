package securityConcreteClass;

import interfaces.SecurityFilter;
import userData.UserData;

public class Authorization extends SecurityFilter {

    @Override
    public boolean doFilter(UserData userData) {
        if(userData.role == "admin"){
            System.out.println("Admin access granted");
            return super.doFilter(userData);
        }
        else{
            System.out.println("Admin access not for this user");
            return false;
        }
    }
}

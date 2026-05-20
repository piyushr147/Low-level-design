package user;

import enums.AccessLevel;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String name;
    private List<AccessLevel> accessLevels;

    public User(String name) {
        this.name = name;
        this.accessLevels = new ArrayList<>();
    }

    public List<AccessLevel> getAccessLevels() {
        return accessLevels;
    }

    public void addAccessLevels(AccessLevel accessLevel) {
        if(accessLevels.stream().anyMatch(ac -> ac == accessLevel)) {
            return;
        }
        this.accessLevels.add(accessLevel);
    }

    public void removeAccessLevels(AccessLevel accessLevel) {
        accessLevels.remove(accessLevel);
    }

    public boolean hasPermission(AccessLevel accessLevel) {
        return accessLevels.contains(accessLevel);
    }
}

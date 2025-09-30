package user;

import utils.PropertyReader;

public class UserFactory {
    public static User standardUser() {
        return new User(PropertyReader.getProperty("sandbox.login"),
                PropertyReader.getProperty("sandbox.password"));
    }
    public static User blockedUser() {
        return new User(PropertyReader.getProperty("sandbox.lockedLogin"),
                PropertyReader.getProperty("sandbox.password"));
    }

    public static User withOutLogin() {
        return new User("", PropertyReader.getProperty("sandbox.password"));
    }

    public static User withOutPassword() {
        return new User(PropertyReader.getProperty("sandbox.login"), "");
    }
}

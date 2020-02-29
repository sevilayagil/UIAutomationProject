package steps.base;

public class User {
    public String getUserName() {
        return userName;
    }

    private void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    private void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    private String userName;
    private String userPassword;

    User() {
        setUserName("sevotest10@gmail.com");
        setUserPassword("dCQhFEFa3");
    }
}

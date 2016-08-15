package accounts;

public class UserProfile {
    private String login;
    private String pass;

    public UserProfile(String login, String pass) {
        this.login = login;
        this.pass = pass;

    }

    public String getLogin() {
        return login;
    }

    public String getPass() {
        return pass;
    }
}



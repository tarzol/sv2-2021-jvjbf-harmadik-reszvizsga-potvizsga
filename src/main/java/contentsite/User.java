package contentsite;

public class User {

    private String userName;
    private String password;
    private boolean logIn;
    private boolean premiumMember;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }


    public void upgradeForPremium() {
        premiumMember = true;
    }

    public void setLogIn(boolean value) {
        logIn = value;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public boolean isLogIn() {
        return logIn;
    }

    public boolean isPremiumMember() {
        return premiumMember;
    }
}

package contentsite;

import java.util.HashSet;
import java.util.Set;

public class ContentService {

    private Set<User> allUsers = new HashSet<>();
    private Set<Content> allContent = new HashSet<>();

    public void registerUser(String name, String password) {
        for (User actualUser : allUsers) {
            if ( actualUser.getUserName().equals(name)) {
                throw new IllegalArgumentException("Username is already taken: "+actualUser.getUserName());
            }
        }
        allUsers.add(new User(name, password));
    }

    public void addContent(Content content) {
        for (Content actualContent : allContent) {
            if (actualContent.getTitle().equals(content.getTitle())) {
                throw new IllegalArgumentException("Content name is already taken: "+actualContent.getTitle());
            }
        }
        allContent.add(content);

    }

    public void logIn(String username, String password) {
        for (User actualUser : allUsers) {
            if (actualUser.getUserName().equals(username)) {

            }
        }
        throw new IllegalArgumentException("Username is wrong!");
    }

    public void clickOnContent(User user, Content content) {
        if (!user.isLogIn()) {
            throw new IllegalArgumentException("Log in to watch this content!");
        }
        if ( (content instanceof Video) && user.isPremiumMember()) {
            content.click(user);
        } else {
            throw new IllegalArgumentException("Upgrade for Premium to watch this content!");
        }
    }

    public Set<User> getAllUsers() {
        return allUsers;
    }

    public Set<Content> getAllContent() {
        return allContent;
    }
}

package contentsite;

import java.util.List;

public class Video implements  Content {
    private String title;
    private int length;


    public Video(int length, String title) {
        this.length = length;
        this.title = title;
    }

    public Video(String title, int length) {
        this.title = title;
        this.length = length;
    }

    @Override
    public boolean isPremiumContent() {
        if ( length >= 15 ) {
            return true;
        }
        return false;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public List<User> clickedBy() {

        return null;
    }

    @Override
    public void click(User user) {

    }
}

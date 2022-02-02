package contentsite;

import java.util.List;

public class Podcast implements Content {

    private String title;
    private List<String> speakers;

    public Podcast(String title, List<String> speakers) {
        this.title = title;
        this.speakers = speakers;
    }

    @Override
    public boolean isPremiumContent() {
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

    public List<String> getSpeakers() {
        return speakers;
    }
}

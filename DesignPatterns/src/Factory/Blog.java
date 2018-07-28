package Factory;

import Factory.Pages.AboutPage;
import Factory.Pages.CommentPage;
import Factory.Pages.ContactPage;

public class Blog extends Website {

    @Override
    public void createWebsite() {
        pages.add(new AboutPage());
        pages.add(new ContactPage());
        pages.add(new CommentPage());
    }

}

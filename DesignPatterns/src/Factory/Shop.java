package Factory;

import Factory.Pages.AboutPage;
import Factory.Pages.CartPage;
import Factory.Pages.ContactPage;
import Factory.Pages.ItemPage;

public class Shop extends Website {

    @Override
    public void createWebsite() {
        pages.add(new AboutPage());
        pages.add(new ContactPage());
        pages.add(new CartPage());
        pages.add(new ItemPage());
    }

}

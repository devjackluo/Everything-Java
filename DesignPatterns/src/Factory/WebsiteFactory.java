package Factory;

public class WebsiteFactory {

    public static Website getWebsite(WebsiteTypeEnum siteType){
        switch (siteType){
            case BLOG:{
                return new Blog();
            }
            case SHOP:{
                return new Shop();
            }
            default:{
                return null;
            }
        }
    }



}

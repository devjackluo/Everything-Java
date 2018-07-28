package Factory;

public class FactoryDemo {

    public static void main(String[] args){

        Website site = WebsiteFactory.getWebsite(WebsiteTypeEnum.BLOG);
        System.out.println(WebsiteTypeEnum.BLOG.toString());
        System.out.println(site.getPages());

        site = WebsiteFactory.getWebsite(WebsiteTypeEnum.SHOP);
        System.out.println(WebsiteTypeEnum.SHOP.toString());
        System.out.println(site.getPages());


    }


}

package Factory;

public class FactoryDemo {

    public static void main(String[] args){

        //Factory is used when you have multiple chooses for something
        //but you want the ability to create each one using a 'factory' passing in enums/strings
        //^ switching between which to create
        Website site = WebsiteFactory.getWebsite(WebsiteTypeEnum.BLOG);
        System.out.println(WebsiteTypeEnum.BLOG.toString());
        System.out.println(site.getPages());

        site = WebsiteFactory.getWebsite(WebsiteTypeEnum.SHOP);
        System.out.println(WebsiteTypeEnum.SHOP.toString());
        System.out.println(site.getPages());


    }


}

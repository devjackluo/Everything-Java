package AbstractFactory;

public class AbstractFactoryDemo {

    public static void main(String[] args){

        //Abstract factory returns you a factory that fits your needs based on the inputted information
        //therefore you don't have to manually tell which card to get but let abstract factory do the work
        //hides everything from user (they dont know how it is doing it)


        //create creditcardfactory which takes care of creating a credit card to match score
        CreditCardFactory abstractFactory = CreditCardFactory.getCreditCardFactory(670);
        //tell factory to get credit card of type
        CreditCard card = abstractFactory.getCreditCard(CardType.PLAT);
        System.out.println(card.getClass());

        abstractFactory = CreditCardFactory.getCreditCardFactory(500);
        CreditCard card2 = abstractFactory.getCreditCard(CardType.GOLD);
        System.out.println(card2.getClass());

    }

}

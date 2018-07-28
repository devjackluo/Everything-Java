package AbstractFactory;

public class AbstractFactoryDemo {

    public static void main(String[] args){

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

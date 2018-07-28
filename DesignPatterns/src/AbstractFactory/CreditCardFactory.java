package AbstractFactory;

import AbstractFactory.AmEx.AmExFactory;
import AbstractFactory.Visa.VisaFactory;

public abstract class CreditCardFactory {

    public static CreditCardFactory getCreditCardFactory(int creditScore){
        if(creditScore > 650){
            return new AmExFactory();
        }else{
            return new VisaFactory();
        }
    }

    public abstract CreditCard getCreditCard(CardType cardType);
    public abstract Validator getValidator(CardType cardType);

}

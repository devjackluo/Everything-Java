package AbstractFactory.Visa;

import AbstractFactory.CardType;
import AbstractFactory.CreditCard;
import AbstractFactory.CreditCardFactory;
import AbstractFactory.Validator;

public class VisaFactory extends CreditCardFactory {
    @Override
    public CreditCard getCreditCard(CardType cardType) {
        switch (cardType){
            case GOLD:{
                return new VisaGoldCreditCard();
            }
            case PLAT:{
                return new VisaPlatinumCreditCard();
            }
            default:
                return null;
        }
    }

    @Override
    public Validator getValidator(CardType cardType) {
        switch (cardType){
            case GOLD:{
                return new VisaGoldValidator();
            }
            case PLAT:{
                return new VisaPlatinumValidator();
            }
            default:
                return null;
        }
    }
}

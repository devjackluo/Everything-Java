package AbstractFactory.AmEx;

import AbstractFactory.CardType;
import AbstractFactory.CreditCard;
import AbstractFactory.CreditCardFactory;
import AbstractFactory.Validator;

public class AmExFactory extends CreditCardFactory {
    @Override
    public CreditCard getCreditCard(CardType cardType) {

        switch (cardType){
            case GOLD:{
                return new AmExGoldCreditCard();
            }
            case PLAT:{
                return new AmExPlatinumCreditCard();
            }
            default:
                return null;
        }

    }

    @Override
    public Validator getValidator(CardType cardType) {
        switch (cardType){
            case GOLD:{
                return new AmExGoldValidator();
            }
            case PLAT:{
                return new AmExPlatinumValidator();
            }
            default:
                return null;
        }
    }
}

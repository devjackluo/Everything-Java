package AbstractFactory.AmEx;

import AbstractFactory.CreditCard;
import AbstractFactory.Validator;

public class AmExGoldValidator implements Validator {
    @Override
    public boolean isValid(CreditCard creditCard) {
        return false;
    }
}

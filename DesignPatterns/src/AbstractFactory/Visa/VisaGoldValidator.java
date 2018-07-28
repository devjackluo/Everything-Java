package AbstractFactory.Visa;

import AbstractFactory.CreditCard;
import AbstractFactory.Validator;

public class VisaGoldValidator implements Validator {
    @Override
    public boolean isValid(CreditCard creditCard) {
        return false;
    }
}

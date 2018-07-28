package AbstractFactory.Visa;

import AbstractFactory.CreditCard;
import AbstractFactory.Validator;

public class VisaPlatinumValidator implements Validator {

    @Override
    public boolean isValid(CreditCard creditCard) {
        return false;
    }

}

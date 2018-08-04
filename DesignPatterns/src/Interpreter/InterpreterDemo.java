package Interpreter;

public class InterpreterDemo {

    static Expression buildInterpreterTree(){

        //Expression terminal1 = null;
        Expression terminal1 = new TerminalExpression("Me");
        Expression terminal2 = new TerminalExpression("You");
        Expression terminal3 = new TerminalExpression("Us");
        Expression terminal4 = new TerminalExpression("Love");

        //Me and Us
        Expression alt1 = new AndExpression( terminal1, terminal3);
        //You or Love
        Expression alt2 = new OrExpression( terminal2, terminal4);

        //(Me and Us) and (You or Love)
        return new AndExpression(alt1, alt2);
    }

    public static void main(String[] args){

        //Recursive search interpreters to see if it matches logic

        //String context = "Lions are Me but You and I love them. Also Us .";
        String context = "( Me and Us ) and ( You or Love )";
        //String context = "( Me and Me ) and ( You or Love )";


        Expression define = buildInterpreterTree();

        System.out.println(context + " is " + define.interpret(context));
    }

}

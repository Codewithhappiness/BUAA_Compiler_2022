package Frontend.Parser.expr.types;

import Frontend.Lexer.Token;

import java.util.ArrayList;

public class RelExp {
    // RelExp → AddExp {('<' | '>' | '<=' | '>=') AddExp}
    private final AddExp firstExp;
    private final ArrayList<AddExp> exps;
    private final ArrayList<Token> seps;

    public RelExp(AddExp firstExp, ArrayList<AddExp> exps, ArrayList<Token> seps) {
        this.firstExp = firstExp;
        this.exps = exps;
        this.seps = seps;
    }

    public AddExp getFirstExp() {
        return firstExp;
    }

    public ArrayList<AddExp> getExps() {
        return exps;
    }

    public ArrayList<Token> getSeps() {
        return seps;
    }

    public int getLine() {
        if (exps.size() != 0) {
            return this.exps.get(exps.size() - 1).getLine();
        } else {
            return this.firstExp.getLine();
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(firstExp).append("<RelExp>\n");  // correctly print BNF
        for (int i = 0; i < exps.size(); i++) {
            stringBuilder.append(seps.get(i)).append(exps.get(i)).append("<RelExp>\n");  // correctly print BNF
        }
        return stringBuilder.toString();
    }
}

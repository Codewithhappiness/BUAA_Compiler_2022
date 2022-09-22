package Parser.expr.types;

import Config.IO;
import Lexer.Token;

public class Number implements PrimaryExpInterface{
    private final Token number;

    public Number(Token token) {
        this.number = token;
    }

    @Override
    public void output() {
        IO.print(number.toString());
        IO.print("<Number>");
    }
}
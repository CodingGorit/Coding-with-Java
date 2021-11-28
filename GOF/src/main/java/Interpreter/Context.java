package Interpreter;

import java.util.StringTokenizer;

/**
 * @Author Gorit
 * @Date 2021/11/29
 **/
public class Context {
    private StringTokenizer tokenizer;
    private String currentToken;

    public Context(String text) {
        this.tokenizer = new StringTokenizer(text);
        nextToken();
    }
    // 获取下一个标记（前进至下一个标记）
    public String nextToken() {
        if (tokenizer.hasMoreTokens()) {
            currentToken = tokenizer.nextToken();
        } else {
            currentToken = null;
        }
        return currentToken;
    }
    // 获取当前标记
    public String currentToken() {
        return currentToken;
    }
    // 先检查标记，在获取下一个标记
    public void skipToken(String token) throws ParseException {
        if (!token.equals(currentToken)) {
            throw new ParseException("Waring: " + token + " is expected, but " + currentToken + " is found");
        }
        nextToken();
    }
    // 获取当前标记对应的数值
    public int getCurrentNumber() throws ParseException {
        int number = 0;
        try {
            number = Integer.parseInt(currentToken);
        } catch (NumberFormatException e) {
            throw new ParseException("Waring " + e);
        }
        return number;
    }
}

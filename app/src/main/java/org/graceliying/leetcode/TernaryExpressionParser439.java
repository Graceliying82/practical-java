package org.graceliying.leetcode;

/**
 * Given a string expression representing arbitrarily nested ternary expressions, evaluate the expression, and return the result of it.
 *
 * You can always assume that the given expression is valid and only contains digits, '?', ':', 'T', and 'F' where 'T' is true and 'F' is false. All the numbers in the expression are one-digit numbers (i.e., in the range [0, 9]).
 *
 * The conditional expressions group right-to-left (as usual in most languages), and the result of the expression will always evaluate to either a digit, 'T' or 'F'.
 */
public class TernaryExpressionParser439 {
    public String evaluate(String expression) {
        StringBuilder exp = new StringBuilder(expression);

        while (exp.length() != 1) {
            Character falseChar = exp.charAt(exp.length() - 1);
            // remove colon
            exp.delete(exp.length() - 2, exp.length());

            // find "?"
            int indexOfQuestionMark = exp.length() - 1;
            while (exp.charAt(indexOfQuestionMark) != '?') {
                indexOfQuestionMark--;
            }
            StringBuilder trueExpression = new StringBuilder(exp.substring(indexOfQuestionMark + 1, exp.length()));
            Character booleanChar = exp.charAt(indexOfQuestionMark - 1);

            exp.delete(indexOfQuestionMark - 1, exp.length());

            if (booleanChar == 'T') {
                exp.append(trueExpression);
            } else {
                exp.append(falseChar);
            }
        }

        return exp.toString();
    }
}

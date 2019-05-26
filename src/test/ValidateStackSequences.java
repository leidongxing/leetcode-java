package test;

import java.util.Stack;

public class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int i = 0, currentIndex = 0;
        while (i < pushed.length) {
            if (pushed[i] == popped[0]) {
                i = currentIndex;
                break;
            }
            i++;
        }
        for (int j = currentIndex + 1; j < pushed.length; j++) {

        }


        Stack<Integer> s = new Stack<Integer>();

        for (int j = 0; j < popped.length; j++) {
            if (popped[j] == s.peek()) {
                s.pop();
            }
        }
        return s.isEmpty();
    }

    public static void main(String[] args) {
        ValidateStackSequences vs = new ValidateStackSequences();
        System.out.println(vs.validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}));
    }
}

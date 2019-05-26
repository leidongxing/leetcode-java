package test;


import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
//	private final static Map<Character, char[]> map = new HashMap<Character, char[]>();
//	static {
//		map.put('0', new char[] {});
//		map.put('1', new char[] {});
//		map.put('2', new char[] { 'a', 'b', 'c' });
//		map.put('3', new char[] { 'd', 'e', 'f' });
//		map.put('4', new char[] { 'g', 'h', 'i' });
//		map.put('5', new char[] { 'j', 'k', 'l' });
//		map.put('6', new char[] { 'm', 'n', 'o' });
//		map.put('7', new char[] { 'p', 'q', 'r', 's' });
//		map.put('8', new char[] { 't', 'u', 'v' });
//		map.put('9', new char[] { 'w', 'x', 'y', 'z' });
//	}

//	public List<String> letterCombinations(String digits) {
//		LinkedList<String> list = new LinkedList<String>();
//		if(digits.isEmpty()) {
//			return list;  
//		}
//		String[] mapping= new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
//		list.add("");
//		for(int i=0;i<digits.length();i++) {
//			int x =Character.getNumericValue(digits.charAt(i));
//			while(list.peek().length()==i) {
//				String t =list.remove();
//				System.out.println(t);
//				for(char s:mapping[x].toCharArray()) {
//					list.add(t+s);
//				}
//			}
//		}
//		return list;  
//	}

    String[] dict = {" ", "*", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        dfs(res, digits, "");
        return res;
    }

    private void dfs(List<String> res, String digits, String str) {
        if (str.length() == digits.length()) {
            res.add(str);
            return;
        }
        int index = digits.charAt(str.length()) - '0';
        for (char c : dict[index].toCharArray()) {
            dfs(res, digits, str + c);
        }
    }


    public static void main(String[] args) {
        List<String> list1 = new LetterCombinationsOfAPhoneNumber().letterCombinations("23");
        System.out.println(list1);
        System.out.println(list1.size());
    }
}

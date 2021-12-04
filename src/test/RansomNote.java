package test;

/**
 * @author LeiDongxing
 * created on 2021/12/4
 */
public class RansomNote {
    /**
     * @param ransomNote 赎金信
     * @param magazine   杂志 magazine中的每个字符只能在ransomNote中使用一次
     * @return ransomNote能不能由magazines 里面的字符构成
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] nums = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            nums[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            int tmp = ransomNote.charAt(i) - 'a';
            nums[tmp]--;
            if (nums[tmp] < 0) {
                return false;
            }
        }
        return true;
    }
}

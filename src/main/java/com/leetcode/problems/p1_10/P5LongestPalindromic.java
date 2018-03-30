package com.leetcode.problems.p1_10;

/**
 * @author yongxing.chen
 * @create 2018-03-27 下午4:40
 */
public class P5LongestPalindromic {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) {
            return "";
        }
        String lpd = s.substring(0, 1);
        int left = -1, index = 0, right = 1;
        for(int i = 0; i < s.length() - 1; i++) {
            index = i;
            if(s.charAt(i) == s.charAt(i + 1)) {
                for(int j = i + 1; j < s.length(); j++) {
                    if(s.charAt(i) != s.charAt(j)) {
                        break;
                    }
                    index = j;
                    lpd = lpd.length() < j - i + 1 ? s.substring(i, j + 1) : lpd;
                }
            }
            left = i - 1;
            right = index + 1;
            i = index;
            while (left > -1 && right < s.length()) {
                if(s.charAt(left) == s.charAt(right)) {
                    lpd = lpd.length() < right - left + 1 ? s.substring(left, right + 1) : lpd;
                    left--;
                    right++;
                    continue;
                }
                break;
            }
        }
        return lpd;
    }

    public String reversString(String s) {
        char[] reversS2C = new char[s.length()];
        for(int i = s.length(); i > 0; i--) {
            reversS2C[s.length() - i] = s.charAt(i - 1);
        }
        return new String(reversS2C);
    }

    public static void main(String[] args) {
        new P5LongestPalindromic().longestPalindrome("rgczcpratwyqxaszbuwwcadruayhasynuxnakpmsyhxzlnxmdtsqqlmwnbxvmgvllafrpmlfuqpbhjddmhmbcgmlyeypkfpreddyencsdmgxysctpubvgeedhurvizgqxclhpfrvxggrowaynrtuwvvvwnqlowdihtrdzjffrgoeqivnprdnpvfjuhycpfydjcpfcnkpyujljiesmuxhtizzvwhvpqylvcirwqsmpptyhcqybstsfgjadicwzycswwmpluvzqdvnhkcofptqrzgjqtbvbdxylrylinspncrkxclykccbwridpqckstxdjawvziucrswpsfmisqiozworibeycuarcidbljslwbalcemgymnsxfziattdylrulwrybzztoxhevsdnvvljfzzrgcmagshucoalfiuapgzpqgjjgqsmcvtdsvehewrvtkeqwgmatqdpwlayjcxcavjmgpdyklrjcqvxjqbjucfubgmgpkfdxznkhcejscymuildfnuxwmuklntnyycdcscioimenaeohgpbcpogyifcsatfxeslstkjclauqmywacizyapxlgtcchlxkvygzeucwalhvhbwkvbceqajstxzzppcxoanhyfkgwaelsfdeeviqogjpresnoacegfeejyychabkhszcokdxpaqrprwfdahjqkfptwpeykgumyemgkccynxuvbdpjlrbgqtcqulxodurugofuwzudnhgxdrbbxtrvdnlodyhsifvyspejenpdckevzqrexplpcqtwtxlimfrsjumiygqeemhihcxyngsemcolrnlyhqlbqbcestadoxtrdvcgucntjnfavylip");
    }
}

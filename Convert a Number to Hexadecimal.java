class Solution {
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        String hex = "";
        while (num != 0) {
            int digit = num & 15;
            hex += digit < 10 ? (char) ('0' + digit) : (char) ('a' + digit - 10);
            num >>>= 4;
        }
        return new StringBuilder(hex).reverse().toString();
    }
}
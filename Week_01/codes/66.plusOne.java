class Solution {
    public int[] plusOne(int[] digits) {
        digits[digits.length - 1] += 1;

        for (int j = digits.length - 1; j > 0; j--) {
            if (digits[j] > 9) {
                digits[j] %= 10;
                digits[j - 1] += 1;
            }
        }

        if (digits[0] == 10) {
            int[] new_digits = new int[digits.length + 1];
            new_digits[0] = 1;
            return new_digits;
        }

        return digits;
    }
}
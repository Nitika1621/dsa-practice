
class Solution {
    public String convert(String s, int numRows) {

        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        List<StringBuilder> rows = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }

        int currentRow = 0;
        boolean goingDown = false;

        for (int i = 0; i < s.length(); i++) {

            rows.get(currentRow).append(s.charAt(i));

            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }

            if (goingDown) {
                currentRow++;
            } else {
                currentRow--;
            }
        }

        StringBuilder ans = new StringBuilder();

        for (StringBuilder row : rows) {
            ans.append(row);
        }

        return ans.toString();
    }
}

class Solution {
    public String[] findWords(String[] words) {
        Set<Character> row1 = new HashSet<>(Arrays.asList('q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'));
        Set<Character> row2 = new HashSet<>(Arrays.asList('a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'));
        Set<Character> row3 = new HashSet<>(Arrays.asList('z', 'x', 'c', 'v', 'b', 'n', 'm'));
        List<String> res = new ArrayList<>();

        for (String word : words) {
            int one = 0, two = 0, three = 0;
            for (char c : word.toLowerCase().toCharArray()) {
                if (row1.contains(c)) one = 1;
                if (row2.contains(c)) two = 1;
                if (row3.contains(c)) three = 1;
                if (one + two + three > 1) break;
            }
            if (one + two + three == 1) res.add(word);
        }

        return res.toArray(new String[0]);
    }
}


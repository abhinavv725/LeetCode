class Solution {
    // Map to store variable replacements
    HashMap<String, String> map;

    public String applySubstitutions(List<List<String>> replacements, String text) {
        map = new HashMap<>();

        // Build the map from the list of replacements
        for (List<String> r : replacements) {
            map.put(r.get(0), r.get(1));
        }

        // Recursively resolve the input text
        return dfs(text);
    }

    // Recursively resolves a string by replacing all %x% placeholders
    private String dfs(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0, n = s.length();

        while (i < n) {
            if (s.charAt(i) != '%') {
                // Regular character, just append
                sb.append(s.charAt(i));
                i++;
            } else {
                // Found a placeholder: format is always %x%
                int j = i + 2; // j points to the second '%'
                String key = String.valueOf(s.charAt(i + 1)); // extract single-char key
                String replacement = map.get(key); // get mapped value

                // Recursively resolve this replacement in case it has placeholders
                sb.append(dfs(replacement));

                i = j + 1; // move past the closing '%'
            }
        }

        return sb.toString();
    }
}

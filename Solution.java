//Justin Butler
// 11/21/2021
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        //Quick look up of our banned words by adding them to a hash set
        HashSet<String> bannedWords = new HashSet<>();
        for(String i : banned)
        {
            bannedWords.add(i);
        }
        //Parse our paragraph for words.
        String[] words = paragraph.replaceAll("[^a-zA-Z ]", " ").toLowerCase().split("\\s+");
        HashMap<String, Integer> common = new HashMap<>();
        String max = "";
        for(String i : words)
        {
            if(!bannedWords.contains(i))
            {
                if(common.containsKey(i))
                {
                    common.put(i, common.get(i)+1);
                }
                else
                {
                    common.put(i, 1);
                }
                // set our new max string.
                max = common.get(i)>common.getOrDefault(max, 0) ? i : max;
            }
        }
        return max;
    }
}

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> all = new ArrayList<List<String>>();

        Map<String, List<String>> map = new HashMap<String, List<String>>();

        for (int i = 0; i < strs.length; i++) {
            char[] ar = strs[i].toCharArray();
            Arrays.sort(ar);
            String key = String.valueOf(ar);
            List<String> list = new ArrayList<String>();
            if (map.containsKey(key)) {
                list = map.get(key);

            }
            list.add(strs[i]);
            map.put(key, list);
        }

        for (String key : map.keySet()) {
            List<String> list = map.get(key);
            all.add(list);
        }

        return all;
    }
}
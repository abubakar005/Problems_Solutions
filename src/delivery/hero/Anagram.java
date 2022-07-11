package delivery.hero;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagram {

    public static void main(String[] args) {
        //System.out.println(isAnagram("eat", "tea"));

        String[] Input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(Input));
    }

    public static boolean isAnagram(String base, String str) {

        if(base.length() != str.length())
            return false;

        StringBuilder sb = new StringBuilder(str);

        for(int i=0; i<str.length(); i++) {

            if(sb.toString().equals(base))
                return true;
            else {
                char temp = sb.charAt(0);
                StringBuilder tempSb = sb.deleteCharAt(0);
                tempSb.append(temp);
                sb = tempSb;
            }
        }

        return false;
    }

    public boolean isAnagramLeetCode(String s, String t) {

        if(s.length() != t.length())
            return false;

        if(s.equals(t))
            return true;

        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            sMap.merge(s.charAt(i), 1, Integer::sum);
            tMap.merge(t.charAt(i), 1, Integer::sum);
        }

        for(Character c : sMap.keySet()) {
            if(!sMap.get(c).equals(tMap.get(c))) return false;
        }

        return true;
    }

    public static List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> res = new ArrayList<>();

        if(strs.length==0)
            return res;

        HashMap<String, List<String>> map = new HashMap();

        for(String s: strs){
            char[] hash = new char[26];

            for(char c: s.toCharArray()){
                hash[c-'a']++;
            }

            String str=new String(hash);
            if(map.get(str)==null){
                map.put(str, new ArrayList<>());
            }
            map.get(str).add(s);
        }
        res.addAll(map.values());
        return res;
    }
}

import java.util.HashMap;

public class EncodeAndDecodeTinyURL {

    public static void main(String args[]){

        System.out.println(new EncodeAndDecodeTinyURL().encode("www.google.com.pk"));
    }

    HashMap<String, String> map = new HashMap<String, String>();
    String characters = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    int count = 2;

    public String getKey() {
        String key = "";
        while(count > 0) {
            count--;
            key += characters.charAt(count);
            count /= characters.length();
        }

        return key;
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String key = getKey();
        map.put(key, longUrl);
        count++;

        return "http://tinyurl.com/" + key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl.replace("http://tinyurl.com/", ""));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));

import java.util.HashMap;

/**
 * @author Almas Baimagambetov
 */
public class Solutions implements Codefest {
    @Override
    public int challenge1(String s) {
        s = s.trim();

        HashMap<Character, Integer> romanNumerals = new HashMap<Character, Integer>();
        romanNumerals.put('I', 1);
        romanNumerals.put('V', 5);
        romanNumerals.put('L', 10);
        romanNumerals.put('X', 10);
        romanNumerals.put('C', 100);
        romanNumerals.put('M', 1000);

        int sLen = s.length();

        int highestValue = romanNumerals.get(s.charAt(sLen - 1));
        int result = highestValue;

        for (int i = s.length() - 2; i >= 0; i--) {
            int currentVal = romanNumerals.get(s.charAt(i));

            if (currentVal >= highestValue) {
                result += currentVal;
                highestValue = currentVal;
            } else {
                result -= currentVal;
            }
        }

        return result;
    }

    @Override
    public boolean challenge2(String a, String b) {
        if (a.length() != b.length()){
            return false;
        }

        a = a.toUpperCase();
        b = b.toUpperCase();

        HashMap<Character, Integer> aCounter = new HashMap<>();
        HashMap<Character, Integer> bCounter = new HashMap<>();

        for (int i = 0; i < a.length(); i++) {

            Character aKey = a.charAt(i);

            if (aCounter.containsKey(aKey)) {
                aCounter.put(aKey, aCounter.get(aKey) + 1);
            } else {
                aCounter.put(aKey, 1);
            }

            Character bKey = b.charAt(i);

            if (bCounter.containsKey(bKey)) {
                bCounter.put(bKey, bCounter.get(bKey) + 1);
            } else {
                bCounter.put(bKey, 1);
            }
        }

        for (Character key : aCounter.keySet()) {
            if (bCounter.containsKey(key)) {
                if (aCounter.get(key) != bCounter.get(key)){
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public int[] challenge3(int[] a, int b) {
        
        HashMap<Integer, Integer> valIndexMap = new HashMap<>();

        for (int i = 0; i < a.length; i++) {
            int target = b - a[i];
            if (valIndexMap.containsKey(target)) {
                return new int[] {valIndexMap.get(target), i};
            } else {
                valIndexMap.put(a[i], i);
            }
        }

        return null;
        
    }

    @Override
    public int challenge4(int a) {
        int result = 0;
        boolean negative = false;

        String aStr = Integer.toString(a);
        char first;
        if (aStr.charAt(0) == '-') {
            negative = true;
            first = aStr.charAt(1);
        } else {
            first = aStr.charAt(0);
        }

        char mid = aStr.charAt((int) aStr.length()/2);
        char last = aStr.charAt(aStr.length() - 1);

        if (negative) {
            result -= Character.getNumericValue(first) * 100;
            result -= Character.getNumericValue(mid) * 10;
            result -= Character.getNumericValue(last);
        } else {
            result += Character.getNumericValue(first) * 100;
            result += Character.getNumericValue(mid) * 10;
            result += Character.getNumericValue(last);
        }

        return result;
    }

    @Override
    public String challenge5(String s) {
        String result = "";

        for (int i = 0; i < s.length(); i += 2) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(i + 1);
            char c3 = (char) ((c1 - '0') + (c2 - '0'));

            result += c3;
        }

        return result;
    }
}
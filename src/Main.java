import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("1) "+solutions(1, 2, 1));
        System.out.println("2) "+findZip("1zip2zip3zip4zip"));
        System.out.println("3) "+checkPerfect(496));
        System.out.println("4) "+flipEndChars("Ab"));
        System.out.println("5) "+isValidHexCode("#0FA12D"));
        String[] a = new String[] {"1", "3", "4", "4", "4"};
        String[] b = new String[] {"2", "5", "7"};
        System.out.println("6) "+same(a, b));
        System.out.println("7) "+isKaprekar(297));
        System.out.println("8) "+longestZero("1111111111"));
        System.out.println("9) "+nextPrime(24));
        System.out.println("10) "+rightTriangle(3,4,5));
    }

    public static Integer solutions(int a, int b, int c){
        int d = b*b - 4*a*c;
        if (d > 0) {
            return 2;
        }else if (d == 0){
            return 1;
        }else {
            return 0;
        }
    }

    public static Integer findZip(String s) {
        String[] words = s.split("zip");
        if (words.length == 1) {
            return -1;
        } else if (words.length > 2) {
            return 3 + words[0].length() + words[1].length();
        } else if (s.endsWith("zip")) {
            return s.length() - 3;
        }else{
            return -1;
        }
    }

    public static Boolean checkPerfect(int n){
        int s = 0;
        if (n < 6){
            return false;
        }else{
            for (int i = 1; i < n; i++){
                if (n % i == 0){
                    s += i;
                }
            }
            if (s == n){
                return true;
            }else{
                return false;
            }
        }
    }

    public static String flipEndChars(String s){
        if (s.length() < 2){
            return "Incompatible.";
        }else if (s.substring(0,1).equals(s.substring(s.length()-1))){
            return "Two's a pair.";
        }else{
            return s.substring(s.length()-1)+s.substring(1,s.length()-1)+s.substring(0,1);
        }
    }

    public static Boolean isValidHexCode(String s){
        for (int i = 1; i < s.length(); i++) {
            if ((47 < (int) s.charAt(i) & (int) s.charAt(i) < 58) | (64 < (int) s.charAt(i) & (int) s.charAt(i) < 71)) {
                continue;
            }else{
                return false;
            }
        }
        return (s.substring(0,1).equals("#") & (s.length() == 7));
    }

    public static Boolean same(String[] a, String[] b){
        Set<String> a1 = Arrays.stream(a).collect(Collectors.toSet());
        Set<String> b1 = Arrays.stream(b).collect(Collectors.toSet());
        return a1.size() == b1.size();
    }

    public static Boolean isKaprekar(int n){
        String s = String.valueOf(n*n);
        if (n < 4){
            if (n == 1){
                return true;
            }else{
                return false;
            }
        }else if (s.length() % 2 == 0){
            return Integer.parseInt(s.substring(0,s.length()/2)) + Integer.parseInt(s.substring(s.length()/2)) == n;
        }else{
            return Integer.parseInt(s.substring(0,s.length()/2)) + Integer.parseInt(s.substring(s.length()/2)) == n;
        }
    }

    public static String longestZero(String s){
        String k = "0";
        for (int i = 0; i < s.length();i++){
            if (s.indexOf(k) == -1){
                return k.substring(0, k.length()-1);
            }else{
                k += "0";
            }
        }
        return "";
    }

    public static Integer nextPrime(int n){
        if (isPrime(n)){
            return n;
        }else{
            while (isPrime(n) != true){
                n += 1;
            }
            return n;
        }
    }

    public static Boolean isPrime(int n){
        if (n < 2){
            return false;
        }else if (n == 2){
            return true;
        }else{
            for (int i = 2; i < Math.sqrt(n)+1; i++){
                if (n % i == 0){
                    return false;
                }
            }
            return true;
        }
    }

    public static Boolean rightTriangle(int x, int y, int z){
        int a = Math.min(x,Math.min(y, z));
        int c = Math.max(x,Math.max(y, z));
        int b = x + y + z - a -c;
        return ((a*a + b*b) == c*c);
    }
}

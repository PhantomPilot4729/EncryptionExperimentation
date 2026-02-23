public class Decryptor {
    private String key;
    private String message;
    private char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ ".toCharArray();
    private int shiftKey;
    private String decryptedMessage = "";

    private long factorial(int n) {
        if(n == 0) {
            return 1;
        }
        long result = 1;
        for(int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public String decryptBasic(String key, String message) {
        this.key = key;
        this.message = message;

        for(int i = 0; i < key.length();i++) {
            for(int j = 0; j < alphabet.length; j++) {
                if(Character.toUpperCase(key.charAt(i)) == alphabet[j]) {
                    shiftKey += j;
                    break;
                }
            }
        }

        for(int i = 0; i < message.length(); i++) {
            for(int j = 0; j < alphabet.length; j++) {
                if(Character.toUpperCase(message.charAt(i)) == alphabet[j]) {
                    decryptedMessage += alphabet[(j - shiftKey + alphabet.length) % alphabet.length];
                    shiftKey += j;
                    break;
                }
            }
        }
        return decryptedMessage;
    }

    public String decryptGrid(String key, String message) {
        this.key = key;
        this.message = message;
        char[][] grid = new char[5][5];

        for(int i = 0; i < alphabet.length; i++) {
            grid[i/5][i%5] = alphabet[i];
        }

        for(int i = 0; i < key.length();i++) {
            for(int j = 0; j < alphabet.length; j++) {
                if(Character.toUpperCase(key.charAt(i)) == alphabet[j]) {
                    shiftKey += j;
                    break;
                }
            }
        }
        for(int i = 0; i < message.length(); i++) {
            for(int j = 0; j < alphabet.length; j++) {
                if(Character.toUpperCase(message.charAt(i)) == alphabet[j]) {
                    decryptedMessage += grid[(j-shiftKey/5+5)%5][(j-shiftKey%5+5)%5];
                    shiftKey += j;
                    break;
                }
            }
        }
        return decryptedMessage;
    }

    public String decryptMacSeries(String key, String message) {
        this.key = key;
        this.message = message;
        char[] upperMessage = message.toUpperCase().toCharArray();
        double n;
        double summation;

        for(int i = 0; i < key.length();i++) {
            for(int j = 0; j < alphabet.length; j++) {
                if(Character.toUpperCase(key.charAt(i)) == alphabet[j]) {
                    shiftKey += j;
                    break;
                }
            }
        }

        for(int i = 0; i < upperMessage.length; i++) {
            for(int j = 0; j < alphabet.length; j++) {
                if(upperMessage[i] == alphabet[j]) {
                    n = (shiftKey + j) % alphabet.length;
                    summation = 0;
                    for(int k = 0; k <= n; k++){
                        summation += Math.pow(shiftKey, k)/factorial(k);
                    }
                    decryptedMessage += alphabet[(int)(j - summation + alphabet.length) % alphabet.length];
                    shiftKey += j;
                    break;
                }
            }
        }
        return decryptedMessage;
    }
}
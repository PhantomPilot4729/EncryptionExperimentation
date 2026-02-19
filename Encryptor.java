public class Encryptor {
    private String key;
    private String message;
    private char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ ".toCharArray();
    private int shiftKey;
    private String encryptedMessage = "";

    public String encryptBasic(String key, String message) {
        this.key = key;
        this.message = message;

        for(int i = 0; i < key.length();i++) {
            for(int j = 0; j < alphabet.length; j++) {
                if(key.charAt(i) == alphabet[j]) {
                    shiftKey += j;
                    break;
                }
            }
        }
        for(int i = 0; i < message.length(); i++) {
            for(int j = 0; j < alphabet.length; j++) {
                if(Character.toUpperCase(message.charAt(i)) == alphabet[j]) {
                    encryptedMessage += alphabet[(j + shiftKey) % alphabet.length];
                    shiftKey += j;
                    break;
                }
            }
        }
        return encryptedMessage;
    }

    public String encryptGrid(String key, String message) {
        this.key = key;
        this.message = message;
        char[][] grid = new char[5][5];

        for(int i = 0; i < alphabet.length; i++) {
            grid[i/5][i%5] = alphabet[i];
        }

        for(int i = 0; i < key.length();i++) {
            for(int j = 0; j < alphabet.length; j++) {
                if(key.charAt(i) == alphabet[j]) {
                    shiftKey += j;
                    break;
                }
            }
        }
        for(int i = 0; i < message.length(); i++) {
            for(int j = 0; j < alphabet.length; j++) {
                if(Character.toUpperCase(message.charAt(i)) == alphabet[j]) {
                    encryptedMessage += grid[j+shiftKey/5][(j+shiftKey)%5];
                    shiftKey += j;
                    break;
                }
            }
        }
        return encryptedMessage;
    }

    private long factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public String encryptMacSeries(String key, String message) {
        this.key = key;
        this.message = message;
        double e = Math.E;
        int n;
        double eReturn;
        long summation = 0;

        for(int i = 0; i < key.length();i++) {
            for(int j = 0; j < alphabet.length; j++) {
                if(key.charAt(i) == alphabet[j]) {
                    shiftKey += j;
                    break;
                }
            }
        }
        String upperMessage = message.toUpperCase();
        for(int i = 0; i < upperMessage.length(); i++) {
            for(int j = 0; j < alphabet.length; j++) {
                if(upperMessage.charAt(i) == alphabet[j]) {
                    n = (shiftKey + j) % alphabet.length;
                    summation = 0;
                    for(int k = 0; k <= n; k++){
                        summation += Math.pow(shiftKey, k) / factorial(k);
                    }
                    eReturn = summation;
                    encryptedMessage += eReturn;
                    shiftKey += j;
                    break;
                }
            }
        }
        return encryptedMessage;
    }
}
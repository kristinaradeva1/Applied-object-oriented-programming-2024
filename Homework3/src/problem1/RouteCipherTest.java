package problem1;

public class RouteCipherTest {
    public static void main(String[] args) {
        // Test with positive cipher key
        RouteCipher test1 = new RouteCipher(5);
        String plaintext1 = "ABORT THE MISSION, YOU HAVE BEEN SPOTTED";

        // Encrypt the plaintext
        String encrypted1 = test1.encrypt(plaintext1);
        System.out.println("Encrypted: " + encrypted1);

        // Decrypt the ciphertext
        String decrypted1 = test1.decrypt(encrypted1);
        System.out.println("Decrypted: " + decrypted1);

        // Test with negative cipher key
        RouteCipher test2 = new RouteCipher(-5);
        String plaintext2 = "WORLD";

        // Encrypt the plaintext
        String encrypted2 = test2.encrypt(plaintext2);
        System.out.println("Encrypted: " + encrypted2);

        // Decrypt the ciphertext
        String decrypted2 = test2.decrypt(encrypted2);
        System.out.println("Decrypted: " + decrypted2);
    }
}

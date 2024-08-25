package problem1;

public class RouteCipher {
    private int key;

    public RouteCipher(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {

        if (key != 0) {
            this.key = key;
        }
    }

    @Override
    public String toString() {
        return "RouteCipher{" +
                "key=" + key +
                '}';
    }

    public String encrypt(String plaintext) {
// Намираме броя на колоните в блока
        int numColumns = Math.abs(key);

        // Намираме броя на редовете в блока
        int numRows = (int) Math.ceil((double) plaintext.length() / numColumns);

        // Инициализираме двумерен масив за съхранение на символите
        char[][] grid = new char[numRows][numColumns];

        // Инициализираме индекси за ред и колона
        int row = 0;
        int col = 0;

        // Пълним масива със символите от plaintext
        for (int i = 0; i < plaintext.length(); i++) {
            grid[row][col] = plaintext.charAt(i);
            col++;
            // Ако стигнем края на реда, преминаваме на следващия ред
            if (col == numColumns) {
                col = 0;
                row++;
            }
        }

        // Инициализираме променлива за криптотекста
        StringBuilder ciphertext = new StringBuilder();

        // Конструираме криптотекста, следвайки рутата
        if (key < 0) {
            // Ако ключът е отрицателен, рутата започва от долния десен ъгъл
            for (int i = numColumns - 1; i >= 0; i--) {
                for (int j = numRows - 1; j >= 0; j--) {
                    ciphertext.append(grid[j][i]);
                }
            }
        } else {
            // Ако ключът е положителен, рутата започва от горния ляв ъгъл
            for (int i = 0; i < numColumns; i++) {
                for (int j = 0; j < numRows; j++) {
                    ciphertext.append(grid[j][i]);
                }
            }
        }

        return ciphertext.toString();
    }


    public String decrypt(String ciphertext) {
        // Намираме размера на блока, като броим символите преди първия 'X'
        int blockSize = ciphertext.indexOf('X');

        // Инициализираме празен двумерен масив за съхранение на символите
        char[][] grid = new char[Math.abs(ciphertext.length() / blockSize)][Math.abs(blockSize)];

        // Инициализираме индекси за ред и колона
        int row = 0;
        int col = 0;

        // Пълним масива със символите от криптотекста
        for (int i = 0; i < ciphertext.length(); i++) {
            // Ако текущия символ е 'X', пропускаме го
            if (ciphertext.charAt(i) != 'X') {
                grid[row][col] = ciphertext.charAt(i);
                col++;
                // Ако стигнем края на реда, преминаваме на следващия ред
                if (col == blockSize) {
                    col = 0;
                    row++;
                }
            }
        }

        // Инициализираме променлива за декриптиран текст
        StringBuilder plaintext = new StringBuilder();

        // Декриптираме текста, следвайки рутата
        boolean upwards = true;
        for (int i = 0; i < blockSize; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (upwards) {
                    plaintext.append(grid[j][i]);
                } else {
                    plaintext.append(grid[grid.length - j - 1][i]);
                }
            }
            upwards = !upwards;
        }

        return plaintext.toString();
}


}

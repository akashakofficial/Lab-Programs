import java.util.Scanner;

public class PlayfairCipher {
    private static char[][] table = new char[5][5];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter key: ");
        String key = sc.nextLine().toUpperCase().replaceAll("[^A-Z]", "").replace("J", "I");
        System.out.print("Enter plaintext: ");
        String text = formatText(sc.nextLine().toUpperCase().replaceAll("[^A-Z]", "").replace("J", "I"));

        buildTable(key);
        String encrypted = processText(text, true);
        String decrypted = processText(encrypted, false);

        System.out.println("Encrypted: " + encrypted);
        System.out.println("Decrypted: " + decrypted);
        sc.close();
    }

    private static void buildTable(String key) {
        boolean[] used = new boolean[26];
        int x = 0, y = 0;
        for (char c : (key + "ABCDEFGHIKLMNOPQRSTUVWXYZ").toCharArray()) {
            if (!used[c - 'A']) {
                table[x][y++] = c;
                used[c - 'A'] = true;
                if (y == 5) { y = 0; x++; }
            }
        }
    }

    private static String formatText(String text) {
        StringBuilder sb = new StringBuilder(text);
        for (int i = 0; i < sb.length(); i += 2) {
            if (i + 1 == sb.length() || sb.charAt(i) == sb.charAt(i + 1)) sb.insert(i + 1, 'X');
        }
        return sb.toString();
    }

    private static String processText(String text, boolean encrypt) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i += 2) {
            char a = text.charAt(i), b = text.charAt(i + 1);
            int[] p1 = findPos(a), p2 = findPos(b);
            if (p1[0] == p2[0]) {
                result.append(table[p1[0]][(p1[1] + (encrypt ? 1 : 4)) % 5]);
                result.append(table[p2[0]][(p2[1] + (encrypt ? 1 : 4)) % 5]);
            } else if (p1[1] == p2[1]) {
                result.append(table[(p1[0] + (encrypt ? 1 : 4)) % 5][p1[1]]);
                result.append(table[(p2[0] + (encrypt ? 1 : 4)) % 5][p2[1]]);
            } else {
                result.append(table[p1[0]][p2[1]]);
                result.append(table[p2[0]][p1[1]]);
            }
        }
        return result.toString();
    }

    private static int[] findPos(char c) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (table[i][j] == c) return new int[]{i, j};
            }
        }
        return null;
    }
}

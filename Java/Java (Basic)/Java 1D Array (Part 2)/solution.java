import java.util.*;

public class Solution {

    static boolean move(int i, int leap, int[] game) {
        if ((i < 0) || (game[i] == 1)) {
            return false;
        }
        if ((i == game.length - 1) || (i + leap > game.length - 1)) {
            return true;
        }
            
        game[i] = 1;
        
        return move(i - 1, leap, game) ||
                move(i + 1, leap, game) ||
                move(i + leap, leap, game);    
    }
    
    public static boolean canWin(int leap, int[] game) {
        return move(0, leap, game);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();
            
            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }
}

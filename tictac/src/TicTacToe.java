import java.util.Scanner;

public class TicTacToe {
    Scanner sc = new Scanner(System.in);

    String winner;

    public static String baseboard = "---\n---\n---";
    void startgame(){
        System.out.println(baseboard);
        p1turn();
    }
    void p1turn(){
        System.out.print("Player 1 turn: ");
        int r= sc.nextInt();
        char [] ar = baseboard.toCharArray();
        if(r>0&&r<=3 && ar[r-1]=='-'){
            ar[r-1] = 'X';
        } else if(r>3&&r<=6 && ar[r]=='-'){
            ar[r]='X';
        } else if (r>6&&r<=9 && ar[r+1]=='-') {
           ar[r+1]='X';
        }else {
            System.out.println("Invalid, try again");
            p1turn();
            return;
        }
        baseboard = new String(ar);
        System.out.println(baseboard);

        if(isWin()){
            System.out.println("Player 1 has won the game");
            return;
        }
        if(!baseboard.contains("-")){
            System.out.println("Stalemate");
            return;
        }
        p2turn();
    }
    void p2turn(){
        System.out.print("Player 2 turn: ");
        int r= sc.nextInt();
        char [] ar = baseboard.toCharArray();
        if(r>0&&r<=3&& ar[r-1]=='-'){
            ar[r-1] = '0';
        }
        else if(r>3&&r<=6&& ar[r]=='-'){
            ar[r]='0';
        } else if (r>6&&r<=9&& ar[r+1]=='-') {
            ar[r+1]='0';
        }
        else{
            System.out.println("Invalid, try again");
            p2turn();
            return;
        }
        baseboard = new String(ar);
        System.out.println(baseboard);
        if(isWin()){
            System.out.println("Player 2 has won the game!");
            return;
        }
        if(!baseboard.contains("-")){
            System.out.println("Stalemate");
            return;
        }

        p1turn();
    }
    boolean isWin(){
        char [] b = baseboard.toCharArray();

        //HORIZONTAL
        if (baseboard.contains("000")){
            return true;
        }else if(baseboard.contains("XXX")){
            winner = "Player 1";
            return true;
        }


        // VERTICAL
        else if ((b[0] == 'X' && b[4] == 'X' && b[8] == 'X')||(b[0] == '0' && b[4] == '0' && b[8] == '0')||(b[1] == 'X' && b[5] == 'X' && b[9] == 'X')||(b[1] == '0' && b[5] == '0' && b[9] == '0')||(b[2] == 'X' && b[6] == 'X' && b[10] == 'X')||(b[2] == '0' && b[6] == '0' && b[10] == '0')) {
            return true;
        }
        //DIAGONAL
        else if ((b[0] == 'X' && b[5] == 'X' && b[10] == 'X')||(b[2] == 'X' && b[5] == 'X' && b[8] == 'X')||(b[0] == '0' && b[5] == '0' && b[10] == '0')||(b[2] == '0' && b[5] == '0' && b[8] == '0')) {
            return true;
        }
        return false;
    }
}

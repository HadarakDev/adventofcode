public class Board {
    int[][] board;
    int winingNumber;
    int score;

    public void displayBoard(){
        for (int y =0; y < 5;y++)
        {
            for (int x =0; x < 5;x++) {
                System.out.print(board[y][x]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public Boolean checkValueBoard(int value)
    {
        for (int y =0; y < 5;y++)
        {
            for (int x =0; x < 5;x++) {
                if (board[y][x] == value) {
                    board[y][x] = -1;
                    return true;
                }
            }
        }
        return false;
    }
    public Boolean checkRowWin()
    {
        for (int y = 0; y < 5;y++)
        {
            int count = 0;
            for (int x =0; x < 5;x++) {
                count += board[y][x];
            }
            if (count == -5)
                return true;
        }
        return false;
    }

    public Boolean checkColWin()
    {
        for (int x = 0; x < 5;x++)
        {
            int count = 0;
            for (int y =0; y < 5;y++) {
                count += board[y][x];
            }
            if (count == -5)
                return true;
        }
        return false;
    }

    public int CalculateScore()
    {
        int count = 0;
        for (int x = 0; x < 5;x++)
        {
            for (int y =0; y < 5;y++) {
                if (board[y][x] != -1) {
                    count += board[y][x];
                }
            }
        }
        return count;
    }

    public Board()
    {
        board = new int[5][5];
    }
}

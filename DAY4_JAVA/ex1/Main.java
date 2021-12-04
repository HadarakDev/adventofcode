import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; // Import the Scanner class to read text files

public class Main {
    public static String[] parseInput() {
//        List input = new ArrayList();
        File myObj = new File("src/input.txt");
        String[] input = new String[0];
        try {
            Scanner myReader = new Scanner(myObj);
            String data = myReader.nextLine();
            input = data.split(",");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return input;
    }

    public static void displayBoards(ArrayList <Board> boards)
    {
        for (int i = 0;i < boards.size();i++){
            System.out.println("Board" + i);
            boards.get(i).displayBoard();
        }
    }

    public static ArrayList <Board> parseBoards() {
        ArrayList <Board> boards = new ArrayList<>();
        File myObj = new File("src/basic_boards.txt");

        try {
            int board_nb = 0;
            int line_nb = 0;
            boards.add(new Board());
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                if (data.length() == 0)
                {
                    boards.add(new Board());
                    board_nb += 1;
                    line_nb = 0;
                    continue;
                }
                data = data.replace("  ", " ");
                if (data.charAt(0) == ' ')
                {
                    data = data.substring(1);
                }
                String [] input = data.split(" ");

                for (int i = 0; i < input.length; i++) {
                    boards.get(board_nb).board[line_nb][i] = Integer.parseInt(input[i]);
                }

                line_nb += 1;
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return boards;
    }

    public static void checkNumbersInBoard(ArrayList <Board> boards, int number) {
        for (int i = 0;i < boards.size();i++){
            if (boards.get(i).checkValueBoard(number) == true)
            {
                boards.get(i).displayBoard();
            }
        }
    }
    public static int checkWin(ArrayList <Board> boards)
    {
        for (int i = 0;i  < boards.size();i++) {
            if ( boards.get(i).checkRowWin() == true || boards.get(i).checkColWin() == true) {
                return boards.get(i).CalculateScore();
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        String[] input = parseInput();
        ArrayList <Board> boards = parseBoards();
        ArrayList <Integer> numbers = new ArrayList<>();

        for (int i = 0; i < input.length; i++) {
            numbers.add(Integer.parseInt(input[i]));
        }

        for (int i = 0; i < numbers.size(); i++) {
            checkNumbersInBoard(boards, numbers.get(i));
            int score = checkWin(boards);
            if (score != -1)
            {
                System.out.println(score * numbers.get(i));
                return;
            }
        }
    }
}

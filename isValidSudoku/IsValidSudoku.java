public class IsValidSudoku{
    public static void main(String[] args) {
        
    }
    public boolean isValidSudoku(char[][] board) {
        return checkColumn(board) && checkRow(board) && checkBox(board, 0, 0) && checkBox(board, 0, 3) && checkBox(board, 0, 6) && checkBox(board, 3, 0) && checkBox(board, 3, 3) && checkBox(board, 3, 6) && checkBox(board, 6, 0) && checkBox(board, 6, 3) && checkBox(board, 6, 6);

    }
    public boolean checkRow(char[][] board){
        for(int i=0; i<9; i++){
            HashMap<Character,Character> row = new HashMap<>();
            for(int j=0; j<9; j++){
                if (board[i][j] != '.'){
                    if(!row.containsKey(board[i][j])){
                        row.put(board[i][j],board[i][j]);
                    }
                    else {
                        System.out.println("false");
                        return false;
                    }
                }
            }
        }
        System.out.println("true");
        return true;
    }
    
    public boolean checkColumn(char[][] board){
        for(int i=0; i<9; i++){
            HashMap<Character,Character> row = new HashMap<>();
            for(int j=0; j<9; j++){
                if (board[j][i] != '.'){
                    if(!row.containsKey(board[j][i])){
                        row.put(board[j][i],board[j][i]);
                    }
                    else {
                        System.out.println("false");
                        return false;
                    }
                }
            }
        }
        System.out.println("true");
        return true;
    }
    
    public boolean checkBox(char[][] board, int i, int j){
        HashMap<Character,Character> row = new HashMap<>();
        for(int x=i; x<i+3; x++){
            for(int y=j; y<j+3; y++){
                if (board[x][y] != '.'){
                    if(!row.containsKey(board[x][y])){
                        row.put(board[x][y],board[x][y]);
                    }
                    else {
                        System.out.println("false");
                        return false;
                    }
                }
            }
        }
        System.out.println("true");
        return true;
    }
}

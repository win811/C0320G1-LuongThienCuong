package Array.baitap;

//import Array.MultiArray;

public class MineSweeperMap {
    public static void main(String[] args) {
        String[][] map = {
                {"*", ".", "*", ".", "."},
                {".", "*", ".", ".", "."},
                {".", "*", ".", ".", "."}
        };
        final int MAP_ROW = map.length;
        final int MAP_COL = map[0].length;
        int count;
        String temp;
        for (int i = 0 ; i < MAP_ROW; i++) {
            for (int j = 0; j < MAP_COL; j++) {
                count = 0;
                if (map[i][j].equals("*")) {
                    continue;
                }
                //Trái
                if ((j - 1) >= 0 && map[i][j-1].equals("*")) {
                    count+=1;
                }
                //Phải
                if ((j + 1) < MAP_COL && map[i][j+1].equals("*")) {
                    count+=1;
                }
                //Trên
                if ((i-1) >= 0 && map[i-1][j].equals("*")) {
                    count +=1;
                }
                //Dưới
                if ((i+1) < MAP_ROW && map[i+1][j].equals("*")) {
                    count +=1;
                }
                //Tréo Trái Trên
                if ((i-1) >= 0 && (j-1) >= 0 && map[i-1][j-1].equals("*")) {
                    count +=1;
                }
                //Tréo Phải Trên
                if ((i-1) >= 0 && (j+1) < MAP_COL && map[i-1][j+1].equals("*")) {
                    count +=1;
                }
                //Tréo Trái Dưới
                if ((i+1) < MAP_ROW && (j-1) >= 0 && map[i+1][j-1].equals("*")) {
                    count +=1;
                }
                //Tréo Phải Dưới
                if ((i+1) < MAP_ROW && (j+1) < MAP_COL && map[i+1][j+1].equals("*")) {
                    count +=1;
                }
                temp = Integer.toString(count);
                map[i][j] = temp;
            }
        }

        System.out.println("-Processed Map-");
        for (String[] row : map) {
            for (String div : row) {
                System.out.print(div + "  ");
            }
            System.out.println();
        }
    }
}

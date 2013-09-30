package com.euler;

/**
 * Created with IntelliJ IDEA.
 * User: dgoldfarb
 * Date: 9/26/13
 * Time: 9:10 AM
 * To change this template use File | Settings | File Templates.
 */
public class problem28 {
    public static void main(String[] args) {
        new problem28();

    }

    public problem28() {
        int[][] mat = build_matrix(1001);
        int result;
        result = sum_diagonals(mat);
        System.out.println(result);
    }

    public int sum_diagonals(int[][] mat){
        int i;
        int sum = 0;
        for(i = 0; i < mat.length; i++) {
            sum = sum + mat[i][i] + mat[(mat.length-1)-i][i];
        }
        return sum - mat[(mat.length-1)/2][(mat.length-1)/2];
    }

    public int[][] build_matrix(int side){
        if (side % 2 == 0) {System.out.println("Side should be odd");}
        int x_coord;
        int y_coord;
        int state = 0;
        int[][] matrix = new int[side][side];
        // initialize
        for(x_coord = 0; x_coord < side; x_coord++) {
            for(y_coord = 0; y_coord < side; y_coord++){
                matrix[x_coord][y_coord] = 0;
            }
        }
        int counter = 1;
        x_coord =(side-1)/2;
        y_coord =(side-1)/2;
        for (counter = 0; counter < side*side-1; counter++){
            matrix[x_coord][y_coord] = counter+1;
            //System.out.println("x: " + x_coord + " y: " + y_coord);
            switch(state) {
                case 0: { // up
                    y_coord++;
                    if (matrix[x_coord-1][y_coord] == 0)
                        state = 1;
                    break;
                }
                case 1: { // left
                    x_coord--;
                    if (matrix[x_coord][y_coord-1] == 0)
                        state = 2;
                    break;
                }
                case 2: { // down
                    y_coord--;
                    if (matrix[x_coord+1][y_coord] == 0)
                        state = 3;
                    break;
                }
                case 3: { // right
                    x_coord++;
                    if (matrix[x_coord][y_coord+1] == 0)
                        state = 0;
                    break;
                }
            }
        }
        matrix[x_coord][y_coord] = counter+1;
        /*for(x_coord = 0; x_coord < side; x_coord++) {
            System.out.print("\n");
            for(y_coord = 0; y_coord < side; y_coord++){
                System.out.print("\t" + matrix[x_coord][y_coord]);
            }
        }*/
        return matrix;
    }
}

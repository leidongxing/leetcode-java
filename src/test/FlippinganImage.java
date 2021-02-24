package test;

/**
 * 翻转图像
 */
public class FlippinganImage {
    public int[][] flipAndInvertImage(int[][] A) {
//        for(int i=0;i<A.length;i++) {
//        	for(int j=0;j<A[i].length/2;j++) {  
//        		int temp = A[i][j];  		
//        		A[i][j] = A[i][A.length-1-j];
//        		A[i][A.length-1-j] = temp;      		
//        	}  	
//        }
//        for(int i=0;i<A.length;i++) {
//        	for (int j=0;j<A[i].length;j++) {
//        		if(A[i][j]==0) {
//        			A[i][j]=1;
//        		}else {
//        			A[i][j]=0;
//        		}
//        	}
//        } 
//        return A;

        int c = A[0].length;
        for (int[] row : A) {
            for (int i = 0; i < (c + 1) / 2; i++) {
                int tmp = row[i] ^ 1;
                row[i] = row[c - 1 - i] ^ 1;
                row[c - 1 - i] = tmp;
            }
        }
        return A;


    }

    public static void main(String[] args) {
        FlippinganImage flippinganImage = new FlippinganImage();
        int[][] A = new int[][]{{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
        A = new int[][]{{1, 1, 0, 0}, {1, 0, 0, 1}, {0, 1, 1, 1}, {1, 0, 1, 0}};
        A = new int[][]{{1}};
        A = new int[][]{{0, 1, 1, 1, 1}, {0, 1, 1, 0, 0}, {0, 1, 1, 1, 1}, {1, 0, 0, 1, 0}, {0, 0, 0, 0, 1}};
        flippinganImage.flipAndInvertImage(A);

    }
}

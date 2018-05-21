public class Test2DArray {
    public static void main(String args[]) {
//         int[] arr = new int[10];
//         arr[0] = 1;
//         // 0 1 2 3 4 5 6 7 8 9
//         // 1 0 0 0 0 0 0 0 0 0
//         arr[5] = 4;
//         // 0 1 2 3 4 5 6 7 8 9
//         // 1 0 0 0 0 4 0 0 0 0 
//         System.out.println(arr[5]);
//         for(int i = 0; i < arr.length; i++) {
//             System.out.print(" ");
//             if (arr[i] == 4) continue;
//             System.out.print(arr[i]);   
//         }   
//         System.out.println();
//         
//         // construct a new spreadsheet
//         int[][] arr2d = new int[20][12];
//         
//         // assign a value to a chell
//         arr2d[0][0] = 1;
//         
//         // getRows()
//         int r = arr2d.length;
//         
//         // getCols()
//         int c = arr2d[0].length;
//         
//         // get Cell(1, 2)
//         // return arr2d[0][1];
//         
//         for(int i = 0; i < arr2d.length; i++) {
//             for(int j = 0; j < arr2d[0].length; j++) {
//                 System.out.print(arr2d[i][j]);
//             }
//             System.out.println();
//         }   
//         
//         String str = "Apple banana orange";
//         String[] strarr = str.split(" ");
//         System.out.println(strarr[2]);
//         String a = "a";
//         String b = "b";
//         System.out.println(a + b);
//         // ab
//         // cd
//         System.out.println(a + "\n" + b);
        
        
        // print first line to indicate col
        String sheet = "   ";
        for (int i = 0; i < 12; i++) {
            sheet += "|";
            sheet += (char) ('A' + i);
            sheet += "         ";
        }
        sheet += "|";
        
        // print each row
        for (int i = 0; i < 20; i++) {
            // print 1 2 3 
            sheet += System.lineSeparator();
            sheet += i + 1;
            if (i >= 9) {
                sheet += " ";
            } else {
                sheet += "  ";            
            }
            
            // print cells
            for (int j = 0; j < 12; j++) {
                // if empty cell
                sheet += "|          ";
                // if not
                // print something
            }
            sheet += "|";
        }
        System.out.print(sheet);
        //System.out.println();
        //System.out.println(sheet.substring(9));
    }
}
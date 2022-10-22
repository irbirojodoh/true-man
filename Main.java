import java.util.*;

public class Main {
    public static void main(String[] args) {
        int difficulty = 0, filled = 0, filledIndex, answer;
        Random gacha = new Random();
        System.out.print("Masukan jumlah urinoir:");
        Scanner input = new Scanner(System.in);
        int jumlahUrinoir = input.nextInt();

        urinoir[] bathroom = new urinoir[jumlahUrinoir];

        System.out.print("Masukan urinoir terpakai: ");
        do{
            difficulty = input.nextInt();
            if (difficulty<=0 || difficulty>=jumlahUrinoir){
                System.out.print("Input salah, masukan kembali: ");
            }
        }while(difficulty<=0 || difficulty>=jumlahUrinoir);
        //System.out.println(difficulty);
        generateUrinoir(bathroom, difficulty);
        printUrinoir(bathroom);
        findBuffer(bathroom);
        calculateHeatmap(bathroom);

       System.out.println("Pilih urinoirmu: ");
       answer = input.nextInt();

        System.out.println(checkAnswer(bathroom, answer-1));



    }
    public static void generateUrinoir(urinoir[] bathroom, int difficulty) {
        Random gacha = new Random();
        int total = 0;

        for(int i = 0; i < bathroom.length; i++) {
            bathroom[i] = new urinoir();
        }
        while (total < difficulty) {
            for (int i = 0; i < bathroom.length; i++) {
                if(!bathroom[i].getFilled()) {
                    if (total < difficulty) {
                        bathroom[i].setFilled(gacha.nextBoolean());
                        if (bathroom[i].getFilled())
                            total++;
                    }
                }
            }
        }
    }

    public static void emptyBathroom(urinoir[] bathroom) {
        for (int i = 0; i < bathroom.length; i++) {
            bathroom[i].setFilled(false);
        }
    }

    public static void calculateHeatmap(urinoir[] bathroom) {
        int localBufferL, localBufferR, i, j;
        for (i = 0; i < bathroom.length; i++){
            if (bathroom[i].getBufferL() >= 2)
                localBufferL = 2;
            else
                localBufferL = bathroom[i].getBufferL();
            if(bathroom[i].getFilled() == true){
                bathroom[i].setHeatmap(1000);
            }


            for (j = 0; j <= localBufferL; j++) {
//                if (bathroom[i - j].getFilled() == true) {
//                    bathroom[i].setHeatmap(bathroom[i].getHeatmap() + (3 - j));
//                }
                if (bathroom[i + j].getFilled() == true) {
                    bathroom[i].setHeatmap(bathroom[i].getHeatmap() + (3 - j));
                }
            }

            if (bathroom[i].getBufferR() >= 2)
                localBufferR = 2;
            else
                localBufferR = bathroom[i].getBufferR();
            if(bathroom[i].getFilled() == true){
                bathroom[i].setHeatmap(1000);
            }


            for (j = 0; j <= localBufferR; j++) {
                if (bathroom[i - j].getFilled() == true) {
                    bathroom[i].setHeatmap(bathroom[i].getHeatmap() + (3 - j));
                }
//                if (bathroom[i + j].getFilled() == true) {
//                    bathroom[i].setHeatmap(bathroom[i].getHeatmap() + (3 - j));
//                }
            }
           // System.out.print(bathroom[i].getHeatmap() + " ");

        }
    }

    public static void findBuffer(urinoir[] bathroom) {
        int i, j;
        for (j = 0; j< bathroom.length; j++) {
            for (i = 0; j-i >= 0 ; i++) {
                // do nothing
            }
            bathroom[j].setBufferR(i-1);

            for (i = 0;j+i<= bathroom.length-1 ; i++) {
                // do nothing
            }
            bathroom[j].setBufferL(i-1);
            //System.out.print(bathroom[j].getBuffer() + " ");
        }



    }

    public static void printUrinoir(urinoir[] bathroom) {
        for (int i = 0; i < bathroom.length; i++) {
            if(i+1 < 10)
                System.out.printf("%4s%d", "", i+1);
            else
                System.out.printf("%3s%d", "", i+1);
        }
        System.out.println("");
        for (int i = 0; i < bathroom.length; i++) {
            if(bathroom[i].getFilled())
                System.out.printf("%4sX", "");
            else
                System.out.printf("%4sO", "");
        }
        System.out.println("");
    }

    public static String checkAnswer(urinoir[] bathroom, int answer) {
        if (bathroom[answer].getHeatmap() >= 1000) {
            return "Dah ada orang goblog";
        }
        double min = bathroom[0].getHeatmap();
        int index;

        for(int i = 0; i< bathroom.length; i++){
            if (min > bathroom[i].getHeatmap())
                min = bathroom[i].getHeatmap();
        }
        if (bathroom[answer].getHeatmap() <= min)
            return "Lelaki sejati";

        return "Banci";



    }

}

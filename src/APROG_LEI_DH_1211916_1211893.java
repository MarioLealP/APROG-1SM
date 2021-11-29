import java.util.Scanner;

public class APROG_LEI_DH_1211916_1211893 {
    static Scanner ler = new Scanner(System.in);

    public static void DAreaSubmersa(int largura, int comprimento, int[][] terreno) {
        double areaTotal = largura * comprimento;
        double areaSubmersa = 0;
        for (int c = 0; c < terreno.length; c++) {
            for (int l = 0; l < terreno[c].length; l++) {
                if (terreno[c][l] < 0) {
                    areaSubmersa++;
                }
            }
        }
        double percentagemAreaSubmersa = areaSubmersa/areaTotal*100;
        System.out.printf("area submersa: %.2f", percentagemAreaSubmersa);
        System.out.println("%");
    }

    public static void BPrintMatriz(int[][] terreno) {

        for(int c = 0; c < terreno.length; c++) {
            for (int l = 0; l < terreno[c].length; l++) {

                System.out.printf("%d ", terreno[c][l]);

            }

            System.out.println();
        }
    }

    public static void altTerreno(int[][] altterreno){
        System.out.println("Alteração do nivel medio da agua em metros");

        int alt = ler.nextInt();

        for(int c = 0; c < altterreno.length; c++){
            for(int l = 0; l < altterreno[c].length; l++ ){

                altterreno[c][l] = altterreno[c][l] + alt;

            }
        }

        BPrintMatriz(altterreno);

    }

    public static void GsubidaInun(int[][] terreno) {

        int altMax = 0;

        for(int c = 0; c < terreno.length; c++){
            for(int l = 0; l < terreno[c].length; l++ ){

                if(altMax < terreno[c][l]){
                    altMax = terreno[c][l];
                }

            }
        }

        if(altMax >= 0){
            altMax++;
            System.out.println("para inundacao total, subir :" + altMax + "m");
        }

        else{
            System.out.println("O terreno ja se encontra inundado");
        }
    }

    public static void ICubo(int[][] terreno) {

        int terraMovida = 100000000;
        int menorC = -1;
        int menorL = -1;

        for (int c = 0; c < terreno.length; c++) {
            for (int l = 0; l < terreno[c].length; l++) {
                int terraMovida2 = (terreno[c][l] * -1) - 3;

                if (terraMovida2 < terraMovida){

                    terraMovida = terraMovida2;
                    menorC = c;
                    menorL = l;

                }
            }
        }
        System.out.printf("coordenadas do cubo: (%d,%d), terra a mobilizar: %d m2", menorC, menorL, terraMovida);
        System.out.println();
    }

    public static void main(String[] args) {
        int largura;
        int comprimento;
        String nome;

        System.out.println("Introduza o nome do Terreno");
        nome = ler.nextLine();

        System.out.println("Introduza a largura do terreno");
        largura = ler.nextInt();

        System.out.println("Introduza a comprimento do terreno");
        comprimento = ler.nextInt();

        int[][] terreno = new int[largura][comprimento];

        for(int c = 0; c < terreno.length; c++){
            for(int l = 0; l < terreno[c].length; l++ ) {
                System.out.printf("Introduza o nível médio de água na cota %d, %d", c, l);
                System.out.println();
                terreno[c][l] = ler.nextInt();
            }
        }

        System.out.println("B)");
        BPrintMatriz(terreno);

        System.out.println("C)");
        altTerreno(terreno);

        System.out.println("D)");
        DAreaSubmersa(largura, comprimento, terreno);

        System.out.println("E)");

        System.out.println("F");

        System.out.println("G)");
        GsubidaInun(terreno);

        System.out.println("H)");


        System.out.println("I)");
        ICubo(terreno);

    }
}
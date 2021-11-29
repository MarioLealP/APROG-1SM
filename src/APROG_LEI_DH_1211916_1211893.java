import java.util.Scanner;

public class APROG_LEI_DH_1211916_1211893 {
    static Scanner ler = new Scanner(System.in);

    public static void BPrintMatriz(int[][] terreno) {
        for(int c = 0; c < terreno.length; c++) {
            for (int l = 0; l < terreno[c].length; l++) {
                System.out.printf("%d ", terreno[c][l]);
            }
            System.out.println();
        }
    }

    public static void altTerreno(int[][] terreno) {
        System.out.println("Alteração do nivel medio da agua em metros");
        int alt = ler.nextInt();
        for(int c = 0; c < terreno.length; c++){
            for(int l = 0; l < terreno[c].length; l++ ){
                terreno[c][l] = terreno[c][l] + alt;
            }
        }
        BPrintMatriz(terreno);
    }

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

        System.out.println("B");
        BPrintMatriz(terreno);

        System.out.println("C");
        altTerreno(terreno);

        System.out.println("D");
        DAreaSubmersa(largura, comprimento, terreno);
    }
}
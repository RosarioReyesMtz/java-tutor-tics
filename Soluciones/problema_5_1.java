import java.util.ArrayList;
import java.util.List;

public class problema_5_1 {

    // Lógica separada
    public int[][] sumar(List<MatrizElemento> A1, List<MatrizElemento> B1, int M, int N) {
        int[][] C = new int[M][N]; // Inicializada en 0 por defecto
        int i = 0, j = 0;

        while (i < A1.size() && j < B1.size()) {
            MatrizElemento elA = A1.get(i);
            MatrizElemento elB = B1.get(j);

            if (elA.ren < elB.ren) {
                C[elA.ren][elA.col] = elA.val;
                i++;
            } else if (elB.ren < elA.ren) {
                C[elB.ren][elB.col] = elB.val;
                j++;
            } else { // Renglones iguales
                if (elA.col < elB.col) {
                    C[elA.ren][elA.col] = elA.val;
                    i++;
                } else if (elB.col < elA.col) {
                    C[elB.ren][elB.col] = elB.val;
                    j++;
                } else { // Misma posición
                    C[elA.ren][elA.col] = elA.val + elB.val;
                    i++;
                    j++;
                }
            }
        }
        
        while (i < A1.size()) { C[A1.get(i).ren][A1.get(i).col] = A1.get(i).val; i++; }
        while (j < B1.size()) { C[B1.get(j).ren][B1.get(j).col] = B1.get(j).val; j++; }
        
        return C;
    }

    // El main solo maneja I/O (simulado)
    public static void main(String[] args) {
        problema_5_1 s = new problema_5_1();
        int M = 3, N = 4;
        
        List<MatrizElemento> A1 = new ArrayList<>();
        A1.add(new MatrizElemento(0, 0, 5));
        A1.add(new MatrizElemento(1, 2, 7));
        
        List<MatrizElemento> B1 = new ArrayList<>();
        B1.add(new MatrizElemento(0, 0, 10)); // Suma
        B1.add(new MatrizElemento(2, 2, 9)); // Nuevo
        
        int[][] C = s.sumar(A1, B1, M, N);

        System.out.println("--- Matriz Resultante C (A + B) ---");
        for (int r = 0; r < M; r++) {
            System.out.println(java.util.Arrays.toString(C[r]));
        }
    }
}

// Clase para simular el REGISTRO del libro
public class MatrizElemento {
    int ren, col, val;
    
    MatrizElemento(int ren, int col, int val) {
        // Usamos índices base 0 para Java
        this.ren = ren; 
        this.col = col; 
        this.val = val;
    }
}
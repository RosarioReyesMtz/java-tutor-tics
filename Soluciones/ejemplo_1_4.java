public class ejemplo_1_4 {

    // Lógica separada
    
    // a) NO(15 >= 7**2) O (43 - 8 * 2 div 4 <> 3 * 2 div 2)
    public boolean evaluarCasoA() {
        // 'div' es división entera (Java lo hace automático con ints)
        return !(15 >= Math.pow(7, 2)) || (43 - (8 * 2 / 4) != (3 * 2 / 2));
    }

    // b) (15 >= 7*3**2 Y 8 > 3 Y 15 > 6) O NO(7*3 < 5 + 12*2 div 3**2)
    public boolean evaluarCasoB() {
        boolean parteB1 = (15 >= (7 * Math.pow(3, 2))) && (8 > 3) && (15 > 6);
        // (12*2 div 3**2) = (24 div 9) = 2 (división entera)
        boolean parteB2 = !( (7 * 3) < (5 + (12 * 2 / (int)Math.pow(3, 2))) );
        return parteB1 || parteB2;
    }
    
    // c) Caso C es un error de tipos (boolean = int), no se puede ejecutar.

    // El main solo llama a la lógica
    public static void main(String[] args) {
        ejemplo_1_4 ee = new ejemplo_1_4();
        
        System.out.println("--- Evaluación de Expresiones Lógicas (Ejemplo 1.4) ---");
        System.out.println("Caso a) Resultado: " + ee.evaluarCasoA());
        System.out.println("Caso b) Resultado: " + ee.evaluarCasoB());
        System.out.println("Caso c) Produce un error de tipos, como se indica en el libro.");
    }
}
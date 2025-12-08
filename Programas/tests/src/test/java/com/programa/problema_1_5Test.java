package com.programa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class problema_1_5Test {

    private problema_1_5 cilindro;

    @BeforeEach
    void setUp() {
        cilindro = new problema_1_5();
    }

    @Test
    void testVolumenValoresNormales() {
        double volEsperado = Math.PI * Math.pow(10, 2) * 5;  // Fórmula exacta
        assertEquals(volEsperado, cilindro.calcularVolumen(10, 5), 0.0001);
    }

    @Test
    void testAreaValoresNormales() {
        double areaEsperada = 2 * Math.PI * 10 * 5; // Área lateral
        assertEquals(areaEsperada, cilindro.calcularArea(10, 5), 0.0001);
    }

    @Test
    void testValoresCero() {
        assertEquals(0, cilindro.calcularVolumen(0, 10), 0.0001);
        assertEquals(0, cilindro.calcularArea(10, 0), 0.0001);
        assertEquals(0, cilindro.calcularVolumen(0, 0), 0.0001);
        assertEquals(0, cilindro.calcularArea(0, 0), 0.0001);
    }

    @Test
    void testValoresNegativos() {
        assertEquals(0, cilindro.calcularVolumen(-5, 10), 0.0001);
        assertEquals(0, cilindro.calcularVolumen(5, -10), 0.0001);
        assertEquals(0, cilindro.calcularArea(-5, 10), 0.0001);
        assertEquals(0, cilindro.calcularArea(5, -10), 0.0001);
    }

    @Test
    void testValoresGrandes() {
        double radio = 1_000_000;
        double altura = 500_000;

        double volEsperado = Math.PI * Math.pow(radio, 2) * altura;
        double areaEsperada = 2 * Math.PI * radio * altura;

        assertEquals(volEsperado, cilindro.calcularVolumen(radio, altura), 0.0001);
        assertEquals(areaEsperada, cilindro.calcularArea(radio, altura), 0.0001);
    }
}

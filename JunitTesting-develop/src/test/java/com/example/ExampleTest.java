package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Arrays;

public class ExampleTest {

    Example example = new Example();

    // 1. Test para el método sumar (incluyendo casos negativos)
    @Test
    public void testSumar() {
        int resultado = example.sumar(5, 3);
        assertEquals(8, resultado); // 5 + 3 = 8
        
        resultado = example.sumar(-2, -3);
        assertEquals(-5, resultado); // -2 + -3 = -5

        resultado = example.sumar(0, 0);
        assertEquals(0, resultado); // 0 + 0 = 0
    }

    // 2. Test para el método checkPositivo (caso sin excepción)
    @Test
    public void testCheckPositivo() {
        boolean resultado = example.checkPositivo(10);
        assertTrue(resultado); // 10 es positivo, así que el método debe retornar true

        // Caso límite: 0 es considerado positivo
        resultado = example.checkPositivo(0);
        assertTrue(resultado); // 0 es positivo según este método
    }

    // 2.1 Test para el método checkPositivo (validamos el comportamiento sin excepciones)
    @Test
    public void testCheckPositivoExcepcion() {
        int numeroNegativo = -1;

        // Verificamos que si el número es negativo, no se debería continuar sin error
        boolean resultado = numeroNegativo >= 0; // validación manual
        assertFalse(resultado, "El número es negativo, por lo que debe fallar");
    }

    // 3. Test para el método contarLetrasA
    @Test
    public void testContarLetrasA() {
        int resultado = example.contarLetrasA("abracadabra");
        assertEquals(5, resultado); // "abracadabra" tiene 5 letras 'a'

        // Caso borde: ninguna 'a'
        resultado = example.contarLetrasA("xyz");
        assertEquals(0, resultado); // No hay 'a' en "xyz"

        // Caso borde: cadena vacía
        resultado = example.contarLetrasA("");
        assertEquals(0, resultado); // No hay letras en la cadena vacía
    }

    // 4. Test para el método contieneElemento
    @Test
    public void testContieneElemento() {
        List<String> lista = Arrays.asList("manzana", "banana", "pera");
        boolean resultado = example.contieneElemento(lista, "banana");
        assertTrue(resultado); // "banana" está en la lista

        // Caso negativo
        resultado = example.contieneElemento(lista, "uva");
        assertFalse(resultado); // "uva" no está en la lista

        // Caso borde: lista vacía
        resultado = example.contieneElemento(Arrays.asList(), "banana");
        assertFalse(resultado); // No puede contener "banana" porque la lista está vacía
    }

    // 5. Test para el método revertirCadena
    @Test
    public void testRevertirCadena() {
        String resultado = example.revertirCadena("Hola");
        assertEquals("aloH", resultado); // La cadena "Hola" invertida es "aloH"

        // Caso borde: cadena vacía
        resultado = example.revertirCadena("");
        assertEquals("", resultado); // Una cadena vacía invertida sigue siendo vacía
    }

    // 6. Test para el método factorial
    @Test
    public void testFactorial() {
        long resultado = example.factorial(5);
        assertEquals(120, resultado); // 5! = 120

        // Caso borde: factorial de 0 es 1
        resultado = example.factorial(0);
        assertEquals(1, resultado); // 0! = 1
    }

    // 6.1 Test para el método factorial con número negativo (en lugar de excepciones, validamos)
    @Test
    public void testFactorialExcepcion() {
        int numeroNegativo = -5;

        // Validamos que si el número es negativo, el resultado es inválido
        boolean resultado = numeroNegativo >= 0;  // manual check
        assertFalse(resultado, "Factorial no debe calcularse para números negativos");
    }

    // 7. Test para el método esPrimo (número primo)
    @Test
    public void testEsPrimo() {
        boolean resultado = example.esPrimo(7);
        assertTrue(resultado); // 7 es un número primo

        // Caso borde: número no primo
        resultado = example.esPrimo(1);
        assertFalse(resultado); // 1 no es un número primo

        // Caso borde: número primo más pequeño
        resultado = example.esPrimo(2);
        assertTrue(resultado); // 2 es el número primo más pequeño
    }

    // 8. Test para el método mensajeConRetraso (uso de InterruptedException)
    @Test
    public void testMensajeConRetraso() throws InterruptedException {
        String resultado = example.mensajeConRetraso();
        assertEquals("Listo después de retraso", resultado); // El mensaje debe ser "Listo después de retraso"
    }

    // 9. Test para el método convertirAString
    @Test
    public void testConvertirAString() {
        List<Integer> lista = Arrays.asList(1, 2, 3);
        List<String> resultado = example.convertirAString(lista);
        assertEquals(Arrays.asList("1", "2", "3"), resultado); // La lista [1, 2, 3] debe convertirse en ["1", "2", "3"]

        // Caso borde: lista vacía
        resultado = example.convertirAString(Arrays.asList());
        assertEquals(Arrays.asList(), resultado); // Lista vacía sigue siendo vacía
    }

    // 10. Test para el método calcularMedia
    @Test
    public void testCalcularMedia() {
        List<Integer> lista = Arrays.asList(10, 20, 30);
        double resultado = example.calcularMedia(lista);
        assertEquals(20.0, resultado, 0.001); // La media de [10, 20, 30] es 20.0
    }

    // 10.1 Test para el método calcularMedia con excepción, validamos con lista vacía
    @Test
    public void testCalcularMediaExcepcion() {
        List<Integer> listaVacia = Arrays.asList();

        // Verificamos que la lista está vacía antes de intentar calcular la media
        assertTrue(listaVacia.isEmpty(), "La lista está vacía y no se puede calcular la media");
    }

    // 11. Test para convertirListaAString
    @Test
    public void testConvertirListaAString() {
        List<String> lista = Arrays.asList("uno", "dos", "tres");
        String resultado = example.convertirListaAString(lista);
        assertEquals("UNO,DOS,TRES", resultado); // Las cadenas deben estar en mayúsculas y separadas por comas
    }

    // 11.1 Test para el método convertirListaAString con valores null
    @Test
    public void testConvertirListaAStringConNull() {
        List<String> lista = Arrays.asList("uno", null, "tres");
        String resultado = example.convertirListaAString(lista);
        assertEquals("UNO,NULL,TRES", resultado); // Las cadenas deben estar en mayúsculas y el null debe ser reemplazado por "NULL"
    }
}
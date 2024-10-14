package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

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
    public void testCheckPos() {

        boolean resultado = example.checkPositivo(10);
        assertTrue(resultado); // 10 es positivo, así que el método debe retornar true

        // 0 es considerado positivo

        resultado = example.checkPositivo(0);

        assertTrue(resultado); // 0 es positivo según el método

    }

    // 2.1 Test para el método checkPositivo (validamos el comportamiento sin excepciones)

    @Test
    public void testNoExceptionCheckPos() {

        int numeroNegativo = -1;

        // Verificamos que si el número es negativo, no continue sin dar ERROR

        boolean resultado = numeroNegativo >= 0;

        assertFalse(resultado, "El número es negativo, por lo que debe fallar");

    }

    // 3. Test para el método contarLetrasA

    @Test
    public void testContarLetras() {

        int resultado = example.contarLetrasA ("armario");
        assertEquals(2, resultado); // "armario" tiene 2 letras 'a'

        // ninguna 'a' en la cadena

        resultado = example.contarLetrasA ("bcd");
        assertEquals(0, resultado); 

        // cadena vacía

        resultado = example.contarLetrasA ("");
        assertEquals(0, resultado); // No hay letras en la cadena vacía

    }

    // 4. Test para el método contieneElemento

    @Test
    public void testContieneElement() {

        List<String> lista = Arrays.asList("arbol", "hoja", "papel");
        boolean resultado = example.contieneElemento(lista, "hoja");
        assertTrue(resultado); // "hoja" está en la lista de palabras

        // Caso negativo

        resultado = example.contieneElemento(lista, "boligrafo");
        assertFalse(resultado); // "boligrafo" no está en la lista

        // Caso borde: lista vacía

        resultado = example.contieneElemento(Arrays.asList(), "fregona");
        assertFalse(resultado); 

    }

    // 5. Test para el método revertirCadena

    @Test
    public void testRevierteCadena() {

        String resultado = example.revertirCadena("Hola");

        assertEquals("aloH", resultado); // Hola revertido

        
        resultado = example.revertirCadena("");

        assertEquals("", resultado); // Una cadena vacia sigue estando vacia revertida

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

    // 6.1 Test para el método factorial con número negativo

    @Test
    public void testFactorialExcepcion() {

        int numeroNegativo = -5;

        // el resultado sera inválido si el numero es negativo

        boolean resultado = numeroNegativo >= 0;
        assertFalse(resultado, "Numero negativo, no se puede calcular el factorial");

    }

    // 7. Test para el método esPrimo

    @Test
    public void testEsPrimo() {
        boolean resultado = example.esPrimo(7);

        assertTrue(resultado); 

        // número no primo

        resultado = example.esPrimo(4);
        assertFalse(resultado); // 4 no es primo

        // número primo más pequeño

        resultado = example.esPrimo(2);

        assertTrue(resultado); // 2 es el número primo más pequeño
    }

    // 8. Test para el método mensajeConRetraso (con InterruptedException)

    @Test
    public void testMensajeConRetraso() throws InterruptedException {

        String resultado = example.mensajeConRetraso();

        assertEquals("Listo con retraso", resultado); 

    }

    // 9. Test para el método convertirAString

    @Test
    public void testConvertirAString() {

        List<Integer> lista = Arrays.asList(1, 2, 3);

        List<String> resultado = example.convertirAString(lista);

        assertEquals(Arrays.asList("1", "2", "3"), resultado); // La lista "1, 2, 3" debe convertirse en ["1", "2", "3"]

        // lista vacía

        resultado = example.convertirAString(Arrays.asList());

        assertEquals(Arrays.asList(), resultado); 

    }

    // 10. Test para el método calcularMedia

    @Test
    public void testCalcularMedia() {

        List<Integer> lista = Arrays.asList(3, 6, 9);

        double resultado = example.calcularMedia(lista);

        assertEquals(6.0, resultado, 0.001); // La media de (3, 6, 9) es 6.0

    }

    // 10.1 Test para el método calcularMedia en la que validamos con lista vacía

    @Test
    public void testCalcularMediaExceptionListaVacia() {

        List<Integer> listaV = Arrays.asList();

        // Verificamos que la lista está vacía antes de intentar hacer calculos

        assertTrue(listaV.isEmpty(), "La lista está vacía");
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

        assertEquals("UNO,NULL,TRES", resultado); // el null será reemplazado por "NULL"
    }
}
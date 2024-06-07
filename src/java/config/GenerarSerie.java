
package config;

/**
 *
 * @author MarioST
 */
public class GenerarSerie {
    int dato;
    String numero;
    
    public String NumeroSerie(int dato) {
        this.dato = dato + 1;
        System.out.println(dato);
        numero = String.format("%04d", this.dato);
        return numero;
    }
}

// Clase principal para ejecutar el programa
public class Main {
    public static void main(String[] args) {
        Buffer buffer = new Buffer(5); // Buffer con capacidad de 5 elementos

        Productor productor = new Productor(buffer); // Crear productor
        Consumidor consumidor = new Consumidor(buffer); // Crear consumidor

        productor.start(); // Iniciar hilo del productor
        consumidor.start(); // Iniciar hilo del consumidor
    }
}
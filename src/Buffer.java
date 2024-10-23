import java.util.LinkedList;
import java.util.Queue;

class Buffer {
    private final int capacidad;
    private final Queue<Integer> cola;

    public Buffer(int capacidad) {
        this.capacidad = capacidad;
        this.cola = new LinkedList<>();
    }

    // Método para agregar un producto al buffer (solo llamado por el productor)
    public synchronized void producir(int producto) throws InterruptedException {
        // Si el buffer está lleno, el productor debe esperar
        while (cola.size() == capacidad) {
            System.out.println("Buffer lleno. Productor espera...");
            wait(); // Espera hasta que haya espacio en el buffer
        }

        cola.add(producto); // Agrega el producto al buffer
        System.out.println("Productor produjo: " + producto + " | Tamaño del buffer: " + cola.size() + "/" + capacidad);

        // Notifica al consumidor que puede consumir
        notifyAll();
    }

    // Método para consumir un producto del buffer (solo llamado por el consumidor)
    public synchronized int consumir() throws InterruptedException {
        // Si el buffer está vacío, el consumidor debe esperar
        while (cola.isEmpty()) {
            System.out.println("Buffer vacío. Consumidor espera...");
            wait(); // Espera hasta que haya un producto en el buffer
        }

        int producto = cola.poll(); // Consume el primer producto del buffer
        System.out.println("Consumidor consumió: " + producto + " | Tamaño del buffer: " + cola.size() + "/" + capacidad);

        // Notifica al productor que puede producir
        notifyAll();
        return producto;
    }
}
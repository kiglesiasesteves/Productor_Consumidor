// Clase Productor que produce productos
class Productor extends Thread {
    private final Buffer buffer;

    public Productor(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        int producto = 0;
        try {
            while (true) {
                buffer.producir(producto++); // Producir productos secuenciales
                sleep((long) (Math.random() * 1000)); // Simular tiempo de producción
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
public class Semaforo {
    public Semaforo() {
    }
        public synchronized void blocca() throws InterruptedException {
            wait();
        }
        public synchronized void avvia() {
            notifyAll();
    }
}

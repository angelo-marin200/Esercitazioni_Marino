import java.util.ArrayList;
import java.util.Scanner;

public class PingMain {
    private static ArrayList<Thread> threads;
    private static ArrayList<Ping> pings;
    private static Semaforo semaforo;
}
    public static void main(String[] args) {
    public static void fermaTutti(){
        for(Ping p:pings) {
            p.ferma();
        }
    }
    public static void avviatutti(){
        semaforo.avvia();
        }


        String input;
        Scanner sc = new Scanner(System.in);
        semaforo = new Semaforo();
        threads = new ArrayList<Thread>();
        pings = new ArrayList<Ping>();
        do {
            fermaTutti();
            System.out.println("Inserisci l'indirizzo IP da testare");
            input = sc.nextLine();
            Ping ping = new Ping(input,semaforo);
            Thread pingThread = new Thread(Ping);
            System.out.println("Ping avviato, premi Enter per cambiare IP, inserisci Q e premi Enter per uscire");
            pingThread.start();
            avviatutti();
            threads.add(pingThread);
            pings.add(ping);
            input = sc.nextLine();
        } while (!input.equals("Q"));
        for(Thread t:threads){
            t.interrupt();
            try {
                t.join();
            } catch (InterruptedException e) {
                System.out.println("Thread interrotto in modo errato");
            }
        }
        sc.close();
        System.out.println("Processo terminato");
        }



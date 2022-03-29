package Exercise2_1;

import java.util.concurrent.ThreadLocalRandom;

public class Main3 {

    private static void nap(int millisecs) {
        try {
            Thread.sleep(millisecs);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void addProc(HighLevelDisplay d) {
        // Add a sequence of addRow operations with short random naps.
                for (int i = 0; i < 10; i++) {
                    d.addRow("Los Angelas  " + i);
                    int time = ThreadLocalRandom.current().nextInt(1000,5000);
                    nap(time);
        }
    }

    private static void deleteProc(HighLevelDisplay d){
        // Add a sequence of deletions of row 0 with short random naps.
            for (int i = 0; i < 10; i++) {
                d.deleteRow(0);
                int time = ThreadLocalRandom.current().nextInt(1000,5000);
                nap(time);
            }
    }

    public static void main(String[] args) throws InterruptedException {
        final HighLevelDisplay d = new JDisplay2();
        if (Thread.interrupted())
            throw new InterruptedException();
        new Thread(() -> addProc(d)).start();
        new Thread(() -> deleteProc(d)).start();
    }
}
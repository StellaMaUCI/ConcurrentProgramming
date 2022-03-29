package Exercise2_2;

public class TrafficController {
    private boolean onBridge = false; //whether a car on bridge

    public synchronized void enterLeft() { //synchronized hold lock
        while(onBridge){
                try{
//calling thread release lock until awakened by notify or interrupt
                    this.wait();
                } catch (InterruptedException e){
                    Thread.currentThread().interrupt();  // set interrupt flag
                    System.out.println("Car is on bridge from left");
                }
            } onBridge = true;
        }

    public synchronized void enterRight() {
        while(onBridge){
                try{
                    this.wait();
                } catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                    System.out.println("Car is on bridge from right");
                }
            }onBridge = true;
        }

    public  synchronized void leaveLeft() {
        onBridge = false;
           notifyAll();
       }

    public  synchronized void leaveRight() {
        onBridge = false;
            notifyAll();
        }
    }


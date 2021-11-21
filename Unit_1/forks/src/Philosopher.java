import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

public class Philosopher implements Runnable{
    private String name;
    private int saturation;

    private Fork forks = new Fork();
    private Semaphore semaphore;

    Philosopher(String name, int saturation, Semaphore semaphore){
        this.name = name;
        this.saturation = saturation;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        int pause;
        try{
                while(saturation > 0){
                    semaphore.acquire();
                    pause = ThreadLocalRandom.current().nextInt(1,5);

                    System.out.println(name + " берет вилку;");
                    Thread.currentThread().sleep(pause);
                    if (saturation - pause <= 0){
                        saturation = 0;
                        System.out.println(name + " кладет вилку; насыщение полное");
                        semaphore.release();
                        break;
                    }
                    saturation -= pause;
                    System.out.println(name + " кладет вилку; насыщение = " + saturation);
                    semaphore.release();
                }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
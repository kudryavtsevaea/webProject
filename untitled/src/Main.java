public class Main {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Test("курица"));
        Thread thread2 = new Thread(new Test("€йцо"));

        thread1.start();
        thread2.start();
    }

}

class Test implements Runnable{
    private String word;

    public Test(String word) {
        this.word = word;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++){
            System.out.println(word);
        }
    }
}

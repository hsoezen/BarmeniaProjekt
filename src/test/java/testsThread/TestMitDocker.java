package testsThread;

public class TestMitDocker {
    public static void main(String[] args) {
        System.out.println("Hallo Docker");
        int count = 0;

        try {
            while (true){
                Thread.sleep(2000);
                System.out.println("Ich arbeite bei Barmenia! Wiederholung " +count++);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

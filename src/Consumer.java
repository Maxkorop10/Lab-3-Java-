public class Consumer implements Runnable {
    private final int itemNumbers;
    private final Manager manager;
    private final int consumer_num;

    public Consumer(int consumer_num, int itemNumbers, Manager manager) {
        this.consumer_num = consumer_num;
        this.itemNumbers = itemNumbers;
        this.manager = manager;

        new Thread(this).start();
    }

    @Override
    public void run() {
        for (int i = 0; i < itemNumbers; i++) {
            String item;
            try {
                manager.empty.acquire();
                Thread.sleep(1000);
                manager.access.acquire();

                item = manager.storage.get(0);
                manager.storage.remove(0);
                System.out.println("Consumer " + consumer_num + " took item: " + item);

                manager.access.release();
                manager.full.release();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
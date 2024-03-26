public class Producer implements Runnable {
    private final int itemNumbers;
    private final Manager manager;
    private final int producer_num;

    public Producer(int producer_num, int itemNumbers, Manager manager) {
        this.producer_num = producer_num;
        this.itemNumbers = itemNumbers;
        this.manager = manager;

        new Thread(this).start();
    }

    @Override
    public void run() {
        for (int i = 0; i < itemNumbers; i++) {
            try {
                manager.full.acquire();
                manager.access.acquire();

                manager.storage.add("item " + i);
                System.out.println("Producer " + producer_num + " added item: " + (i + 1));

                manager.access.release();
                manager.empty.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
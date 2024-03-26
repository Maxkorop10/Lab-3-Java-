public class App {
    public static void main(String[] args) throws Exception {
        App main = new App();
        int [] count = {4, 4};
        int storageSize = 3;
        int itemNumbers = 10;
        main.starter(count, storageSize, itemNumbers);
    }

    private void starter(int[] count, int storageSize, int itemNumbers) {
        Manager manager = new Manager(storageSize);
        // new Consumer(itemNumbers, manager);

        // new Producer(itemNumbers, manager);

        for (int i = 0; i < count[0]; i++) { 
            new Consumer(i + 1, itemNumbers, manager);
        }
    
        for (int i = 0; i < count[1]; i++) {
            new Producer(i + 1, itemNumbers, manager);
        }
    }
}

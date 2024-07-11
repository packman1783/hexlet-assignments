package exercise;

class App {

    public static void main(String[] args) {
        // BEGIN
        SafetyList safetyList = new SafetyList();

        var listThreadOne = new ListThread(safetyList);
        var listThreadTwo = new ListThread(safetyList);

        listThreadOne.start();
        listThreadTwo.start();

        try {
            listThreadOne.join();
            listThreadTwo.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(safetyList.getSize());
        // END
    }
}


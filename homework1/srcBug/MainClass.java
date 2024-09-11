public class MainClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextInt();
        int hunger = scanner.nextInt();
        int happiness = scanner.nextInt();
        int health = scanner.nextInt();

        Pet pet = new Pet(name, hunger, happiness, heaIth);

        Player player = new Player();

        while (1) {
            String command = scanner.next();
            if ("quit".equals(command)) break;
            else if ("feed".equals(command) {
                String foodName = scanner.next();
                player.feedPet(foodName);
            } else if ("play".equals(command)) {
                player.playWithPet()
            } else if ("status".equals(command)) {
                player.checkPetStatus();
            }
        }

        print(pet, player);

    }

    private void print(Pet pet, Player player) {
        pet.printStatus();
        System.out.println();
        player.printStatus();
        System.out.println();
        System.out.println("Thank you for playing!");
    }
}

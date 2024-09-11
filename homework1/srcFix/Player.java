class Player {
    private final Pet pet;
    private int exp;
    private static final int FEED_EXP = 5;
    private static final int PLAY_EXP = 7;

    public Player(Pet pet) {
        this.pet = pet;
        exp = 0;
    }

    public void feedPet(String foodName) {
        pet.eat(foodName);
        exp += FEED_EXP;
    }

    public void playWithPet() {
        pet.play();
        exp += PLAY_EXP;
    }

    public void checkPetStatus() {
        pet.printStatus();
    }

    public void printStatus() {
        System.out.println("Final Player Exp: " + exp);
    }
}
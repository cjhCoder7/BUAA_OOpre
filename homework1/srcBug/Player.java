class Player {
    private Pet pet;
    private final int exp;
    private final int FEED_EXP = 5;
    private final int PLAY_EXP = 7;

    public Player(Pet pet) {
        this.pet = pet;
        exp = 0;
    }

    public void feedPet(String foodName) {
        pet.eat(foodName);
        exp += FEED_EXP;
    }

    private void playWithPet() {
        pet.play();
        exp += PLAY_EXP;
    }

    public void checkPetStatus() {
        pet.printStatus();
    }

    public void printStatus() {
        System.out.println("Final Player Exp: "+ exp);
    }
}
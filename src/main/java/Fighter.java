public class Fighter {
    // ANSI renk kodları
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";

    String name,text;
    int damage, health, weight, dodge;

    Fighter(String name, int damage, int health, int weight, int dodge){
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.weight = weight;
        if(dodge >= 0 && dodge <= 100){
            this.dodge = dodge;
        } else {
            this.dodge = 0;
        }
    }
    int hit(Fighter foe){
        text = this.name + " => " + foe.name + "'e " + this.damage + " hasar vurdu.";
        fontColor(text, "red");
        if(foe.isDodge()){
            text = foe.name + " gelen hasari blokladi!";
            fontColor(text, "yellow");
            return foe.health;
        }
        if(foe.health - this.damage < 0) return 0;

        return foe.health - this.damage;
    }
    boolean isDodge(){
        double randomNumber = Math.random() * 100;
        return randomNumber <= this.dodge;
    }
    public static void fontColor(String text, String color){
        String renkKodu = RESET;

        switch (color.toLowerCase()) {
            case "red":
                renkKodu = RED;
                break;
            case "green":
                renkKodu = GREEN;
                break;
            case "yellow":
                renkKodu = YELLOW;
                break;
            case "blue":
                renkKodu = BLUE;
                break;
            default:
                break;
        }

            System.out.println(renkKodu + text + RESET);
    }
}

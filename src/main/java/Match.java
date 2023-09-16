

public class Match {

    Fighter f1, f2;
    int minWeight, maxWeight, round = 0;
    String text;

    Match(Fighter f1, Fighter f2, int minWeight, int maxWeight){
        this.f1 = f1;
        this.f2 = f2;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
    }
    public void run(){
        if(isCheck()){
            while (this.f1.health > 0 && this.f2.health > 0){
                text = "==== ROUND " + this.round + " ====";
                Fighter.fontColor(text,"blue");

                int randomNumber = (int)(Math.random() * 2);
                if(randomNumber == 0){
                    this.f2.health = this.f1.hit(this.f2);
                    if(isWin()) break;
                } else{
                    this.f1.health = this.f2.hit(this.f1);
                    if(isWin()) break;
                }

                System.out.println(this.f1.name + "in cani = " + this.f1.health);
                System.out.println(this.f2.name + "in cani = " + this.f2.health);
                this.round++;
            }
        } else {
            Fighter.fontColor("Sporcularin agirliklari uymuyor.", "red");
        }
    }

    boolean isCheck(){
        return (this.f1.weight >= minWeight && this.f1.weight <= maxWeight) && (this.f2.weight >= minWeight && this.f2.weight <= maxWeight);
    }
    boolean isWin(){
        if(this.f1.health == 0){
            text =this.f2.name + " kazandi!";
            Fighter.fontColor(text,"green");
            return true;
        }
        if(this.f2.health == 0) {
            text =this.f1.name + " kazandi!";
            Fighter.fontColor(text,"green");
            return true;
        }
        return false;
    }
}

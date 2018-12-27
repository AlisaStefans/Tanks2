public class RuTanks {

    private int health = 0;
    public int getHealth (){
        System.out.println("Вызван метод родителя!!!!");
        return health; }
    public void setHealth(int health) {
        System.out.println("Вызван метод родителя!!!!");
        this.health = health;}
    public int getDamage(){
        System.out.println("Вызван метод родителя!!!!");
        return 5; }
    public int getTimeShot(){
        System.out.println("Вызван метод родителя!!!!");
        return 5; }
    public int getTimeForTurn(){
        System.out.println("Вызван метод родителя!!!!");
        return 5; }

}

     class RuLightTank extends RuTanks implements LightTank {

         RuLightTank () {
             this.health = 10;
         }
         private int health;
         public int getHealth (){ return health; }
         public void setHealth(int health) {this.health = health;}
         public int getDamage(){ return 5; }
         public int getTimeShot(){ return 5; }
         public int getTimeForTurn(){ return 5; }

    }
    class RuMediumTank extends RuTanks implements MediumTank {
        RuMediumTank () {
            this.health = 20;
        }
        private int health;
        public int getHealth (){ return health; }
        public void setHealth(int health) {this.health = health;}
        public int getDamage(){ return 10; }
        public int getTimeShot(){ return 10; }
        public int getTimeForTurn(){ return 10; }

    }

    class RuHeavyTank  extends RuTanks implements HeavyTank {

        RuHeavyTank () {
            this.health = 40;
        }
        private int health;
        public int getHealth (){ return health; }
        public void setHealth(int health) {this.health = health;}
        public int getDamage(){ return 20; }
        public int getTimeShot(){ return 20; }
        public int getTimeForTurn(){ return 20; }

    }

     class RuTanksAbsFactory implements TanksAbsFactory {

        public LightTank getLightTank() {
            return new RuLightTank();
        }

        public MediumTank getMediumTank() {
           return new RuMediumTank();
       }

        public HeavyTank getHeavyTank() {
            return new RuHeavyTank();
        }

    }





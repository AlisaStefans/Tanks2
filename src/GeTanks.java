public class GeTanks {
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
    class GeLightTank extends GeTanks implements LightTank {

        GeLightTank () {
        this.health = 10;
        }
        private int health;
       public int getHealth (){ return health; }
       public void setHealth(int health) {this.health = health;}
       public int getDamage(){ return 5; }
       public int getTimeShot(){ return 5; }
       public int getTimeForTurn(){ return 5; }

    }
    class GeMediumTank extends GeTanks implements MediumTank {

        GeMediumTank() {
        this.health = 20;
        }

        private int health;
        public int getHealth (){ return health; }
        public void setHealth(int health) {this.health = health;}
        public int getDamage(){ return 10; }
        public int getTimeShot(){ return 10; }
        public int getTimeForTurn(){ return 10; }

    }

    class GeHeavyTank extends GeTanks implements HeavyTank {

        GeHeavyTank() {
        this.health = 40;
        }
        private int health;
        public int getHealth (){ return health; }
        public void setHealth(int health) {this.health = health;}
        public int getDamage(){ return 20; }
        public int getTimeShot(){ return 20; }
        public int getTimeForTurn(){ return 20; }

    }

    class GeTanksAbsFactory implements TanksAbsFactory {

        public LightTank getLightTank() {
            return new GeLightTank();
        }

        public MediumTank getMediumTank() {
            return new GeMediumTank();
        }

        public HeavyTank getHeavyTank() {
            return new GeHeavyTank();
        }

    }



import com.sun.jdi.ClassType;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        TanksAbsFactory switchFactory = null;
        String country = "Ru";

            if (country.equals("Ge")) {
                switchFactory = new GeTanksAbsFactory();
            } else if (country.equals("Ru")) {
                switchFactory = new RuTanksAbsFactory();
            }

        ArrayList ruTanks = new ArrayList();

        // создаем русских танков и кладем их в массив ruTanks
        for (int i = 0; i < 5; i++)  ruTanks.add(switchFactory.getLightTank());

       for (int i = 0; i < 3; i++) ruTanks.add(switchFactory.getMediumTank());
       ruTanks.add(switchFactory.getHeavyTank());

        switchFactory = new GeTanksAbsFactory();


        ArrayList geTanks = new ArrayList();

        // создаем немецких танков
        for (int i = 0; i < 5; i++) geTanks.add(switchFactory.getLightTank());
        for (int i = 0; i < 3; i++) geTanks.add(switchFactory.getMediumTank());
        geTanks.add(switchFactory.getHeavyTank());

        battle(ruTanks, geTanks);
    }

    public static void battle (ArrayList ruTanks, ArrayList geTanks) {

        int countFight = 0;

        while ((ruTanks.size() != 0) && (geTanks.size() != 0)) {

            countFight++;
            int numForRu = (int) (Math.random() * ruTanks.size());
            int numForGe = (int) (Math.random() * geTanks.size());

            System.out.println(countFight + "-ый бой!");

            RuTanks ruTankForFight = (RuTanks) (ruTanks.get(numForRu));

            int ruHealth = ruTankForFight.getHealth();
            int ruDamage = ruTankForFight.getDamage();
            int ruTimeShot = ruTankForFight.getTimeShot();
            int ruTimeForTurn = ruTankForFight.getTimeForTurn();

            int ruPosition = (int) (Math.random() * 3);
            if (ruPosition == 0)
                System.out.println("Русский танк лицом к противнику!  Его уровень жизни "+ ruHealth + "!");
            else if (ruPosition == 1)
                System.out.println("Русский танк боком к противнику! Его уровень жизни " + ruHealth + "!");
            else System.out.println("Русский танк спиной к противнику! Его уровень жизни " + ruHealth + "!");

            GeTanks geTankForFight = (GeTanks) (geTanks.get(numForGe));

            int geHealth = geTankForFight.getHealth();
            int geDamage = geTankForFight.getDamage();
            int geTimeShot = geTankForFight.getTimeShot();
            int geTimeForTurn = geTankForFight.getTimeForTurn();

            int gePosition = (int) (Math.random() * 3);
            if (gePosition == 0)
                System.out.println("Немецкий танк лицом к противнику!  Его уровень жизни " + geHealth + "!");
            else if (gePosition == 1)
                System.out.println("Немецкий танк боком к противнику! Его уровень жизни  " + geHealth + "!");
            else System.out.println("Немецкий танк спиной к противнику! Его уровень жизни  " + geHealth + "!");



            int ruTimeForKill = timeForKill(ruDamage, ruTimeShot, ruTimeForTurn, geHealth, ruPosition);
            int geTimeForKill = timeForKill(geDamage, geTimeShot, geTimeForTurn, ruHealth, gePosition);

            if (ruTimeForKill < geTimeForKill) {
                System.out.println("Русский танк выиграл этот бой!");
                geTanks.remove(numForGe);
                ruHealth = ruHealth - (damageTaken(ruTimeForKill, geTimeShot, geTimeForTurn, gePosition, geDamage));
                ruTankForFight.setHealth(ruHealth);

            } else if (ruTimeForKill > geTimeForKill) {
                System.out.println("Немецкий танк выиграл этот бой!");
                ruTanks.remove(numForRu);
                geHealth = geHealth - (damageTaken(geTimeForKill, ruTimeShot, ruTimeForTurn, ruPosition, ruDamage));
                geTankForFight.setHealth(geHealth);

            } else {
                System.out.println("Оба погибли");
                geTanks.remove(numForGe);
                ruTanks.remove(numForRu);
            }

        }

        if (ruTanks.size() == 0) System.out.println("Немцы победили!");
        else System.out.println("Русские победили!");

    }

    static int damageTaken(int timeForKillWinner, int timeShot, int timeForTurn, int position, int damage ){
        double dT = (timeShot*(timeForKillWinner - (timeForTurn * position))/damage);
        int newdT;
        if (dT%damage != 0) {
            newdT = (int)(dT/damage) * damage;
        } else return (int) dT;

        return newdT;

    }

    static int timeForKill( int damage, int timeShot, int timeForTurn, int healthApp, int position) {

    return ((healthApp/damage) * timeShot + (timeForTurn * position));
    }
}


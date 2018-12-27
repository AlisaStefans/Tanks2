 interface LightTank {

    int getHealth ();
    int getDamage();
    int getTimeShot();
    int getTimeForTurn();
}

 interface MediumTank {
    int getHealth ();
    int getDamage();
    int getTimeShot();
    int getTimeForTurn();
}

 interface HeavyTank {
    int getHealth ();
    int getDamage();
    int getTimeShot();
    int getTimeForTurn();

}

 interface TanksAbsFactory {
    LightTank getLightTank();
    MediumTank getMediumTank();
    HeavyTank getHeavyTank();
}

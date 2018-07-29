package Component;

public class ComponentDemo {

    public static void main(String[] args){

        //Using the same interface/class for objects for them to be treated as equal
        //tree structure

        Menu mainMenu = new Menu("Main", "/main");

        MenuItem safetyMenuItem = new MenuItem("Safety", "/safety");

        mainMenu.add(safetyMenuItem);

        Menu claimSubMenu = new Menu("Claims", "/claims");

        mainMenu.add(claimSubMenu);

        MenuItem personalClaimsMenu = new MenuItem("Personal Claims", "/personalClaims");

        claimSubMenu.add(personalClaimsMenu);

        System.out.println(mainMenu.toString());

        claimSubMenu.remove(personalClaimsMenu);

        System.out.println(mainMenu.toString());

    }


}

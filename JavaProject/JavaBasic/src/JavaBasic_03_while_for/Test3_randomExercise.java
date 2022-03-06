package JavaBasic_03_while_for;

/**
 * User crow7
 * Date 2021/8/29.
 */
public class Test3_randomExercise {
    public static void main(String[] args) {
        /*
         * 模拟回合制打怪游戏
         * */
        int playerHp = 315;
        int monster = 500;
        while (true) {
            int playerAttack = (int) Math.random() * 4 + 5;
            monster -= playerAttack;
            System.out.println("玩家攻击怪物，怪物掉了" + playerAttack + "点血，还剩下" + monster + "点血");
            if (monster < 0) {
                System.out.println("玩家死亡，游戏结束");
                break;
            }
            int monsterAttack = (int) Math.random() * 3 + 3;
            playerHp -= monsterAttack;
            System.out.println("怪物攻击玩家，玩家掉了" + monsterAttack + "点血，还剩下" + playerHp + "点血");
            if (playerHp < 0) {
                System.out.println("玩家死亡，游戏结束");
                break;
            }

        }
    }
}

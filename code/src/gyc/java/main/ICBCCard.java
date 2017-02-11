package gyc.java.main;

/**
 * @author guoyc on 2016/4/10.
 */
public class ICBCCard implements Card {

    public ICBCCard() {}

    @Override
    public void cost(Integer money) {
        System.out.println("ICBCCard cost");
    }
}

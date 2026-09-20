public class BirthdayBakeryFactory implements BakeryFactory{

    @Override
    public BakeryCake createCake(){
        return new BirthdayCake();
    }

    @Override
    public BakeryDecoration createDecoration(){
        return new BirthdayDecoration();
    }
}

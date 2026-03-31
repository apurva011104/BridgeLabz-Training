public class DeprecatedExample {
    public static void main(String[] args) {
        LegacyAPI legacyAPI = new LegacyAPI();
        legacyAPI.oldFeature();
        legacyAPI.newFeature();
    }
}

class LegacyAPI{

    @Deprecated
    public void oldFeature(){
        System.out.println("This is an old feature");
    }

    public void newFeature(){
        System.out.println("This is a new feature");
    }
}
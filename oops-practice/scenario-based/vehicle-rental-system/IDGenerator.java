public class IDGenerator {
    
    protected static String idGenerator(String prefix){
        StringBuilder id = new StringBuilder();
        for(int i=0;i<12;i++){
            int charType=(int)(Math.random()*3);

            switch (charType){
                case 0 -> id.append((char)((int)(Math.random()*26)+'a'));
                case 1 -> id.append((char)((int)(Math.random()*26)+'A'));
                case 2 -> id.append((char)((int)(Math.random()*10)+'0'));
            }
        }
        return prefix+id.toString();   
    }
}

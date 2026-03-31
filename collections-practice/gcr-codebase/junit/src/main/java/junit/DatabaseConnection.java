package junit;

public class DatabaseConnection {
    
    private boolean isConnected;

    public void connect(){
        this.isConnected=true;
        System.out.println("Database connected successfully");
    }

    public void disconnect(){
        this.isConnected=false;
        System.out.println("Database disconnected successfully");
    }

    public boolean getConnectionStatus(){
        return this.isConnected;
    }
}

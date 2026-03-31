public class Agent {

    private final String agentId;
    private final String agentName;
    private double agentLocationInKilometers;
    private boolean isAvailable;

    public Agent(String agentId, String agentName, double agentLocationInKilometers) {
        this.agentId = agentId;
        this.agentName = agentName;
        this.agentLocationInKilometers = agentLocationInKilometers;
        this.isAvailable = true;
    }

    public String getAgentId() {
        return agentId;
    }

    public String getAgentName() {
        return agentName;
    }

    public double getAgentLocation() {
        return agentLocationInKilometers;
    }

    public void setAgentLocation(double agentLocationInKilometers) {
        this.agentLocationInKilometers = agentLocationInKilometers;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setavailability(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    @Override
    public String toString() {
        return String.format("[Agent ID: %s, Name: %s  Current location: %.2f kms]", agentId, agentName, agentLocationInKilometers);
    }    
    
}

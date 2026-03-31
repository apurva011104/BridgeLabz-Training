import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class DeliveryService {
    
    private final Queue<Order> ordersRecord;
    private final List<Agent> agentsRecord;
    private final Set<String> allUniqueIds;
    private final Map<Order, Agent> assignedOrders;
    

    public DeliveryService() {
        this.ordersRecord = new LinkedList<>();
        this.agentsRecord = new ArrayList<>();
        this.allUniqueIds = new HashSet<>();
        this.assignedOrders = new HashMap<>();
    }

    private String generateId(String idType){
        String generatedId;

        do { 
            StringBuilder id = new StringBuilder();

            for (int i=0; i<12; i++) {
                id.append((int)(Math.random()*10));
            }

            generatedId = idType + id.toString();
        } while (allUniqueIds.contains(generatedId));

        return generatedId;

    }

    public void addAgent(String agentName, double currentLocationInKilometers){
        if(agentName==null || agentName.isEmpty() || currentLocationInKilometers<0){
            throw new IllegalArgumentException("Invalid agent data");
        }
        String id = generateId("AGN");
        Agent agent = new Agent(id, agentName, currentLocationInKilometers);
        agentsRecord.add(agent);
        System.out.println("Agent added successfully.");

    }

    public Order placeOrder(String customerName, double customerLocationInKilometers){
        if(customerName == null || customerName.isEmpty() || customerLocationInKilometers<0){
            System.out.println("Invalid customer data");
        }
        String id = generateId("ORD");
        Order order = new Order(id, customerName, customerLocationInKilometers);
        ordersRecord.add(order);
        System.out.println("Order placed successfully.");
        return order;
    }

    public void cancelOrder(Order order){
        if(!ordersRecord.contains(order) && !assignedOrders.containsKey(order)){
            throw new IllegalArgumentException("Order not found in the record");
        }
        order.setDeliveryStatus(DeliveryStatus.CANCELLED);
        if(assignedOrders.containsKey(order)){
            assignedOrders.get(order).setavailability(true);
            assignedOrders.remove(order);
        }
        System.out.println("Order cancelled successfully.");
    }

    public void displayActiveDeliveries(){
        if(assignedOrders.isEmpty()){
            System.out.println("No active deliveries");
            return;
        }
        System.out.println("Active deliveries: ");
        for(Map.Entry<Order, Agent> entry: assignedOrders.entrySet()){
            System.out.println("Order: "+entry.getKey()+", Assigned agent: "+entry.getValue());
        }
    }

    public void assignOrders() throws NoAgentAvailableException{
        int numberOfOrders = ordersRecord.size();
        for(int i=0 ; i<numberOfOrders; i++){
            Order order = ordersRecord.peek();
            if(!order.getDeliveryStatus().equals(DeliveryStatus.PENDING)){
                ordersRecord.remove();
                continue;
            }
            Agent availableAgent = findNearestAgent(order);
            if(availableAgent==null){
                throw new NoAgentAvailableException("No agent is available to take pending orders");
            }
            order.setDeliveryStatus(DeliveryStatus.ASSIGNED);
            assignedOrders.put(order, availableAgent);
            availableAgent.setavailability(false);
            ordersRecord.remove();
            System.out.println("Agent: "+availableAgent.getAgentName()+" has been assigned for order: "+order);

        }

    }

    private Agent findNearestAgent(Order order){
        Agent foundAgent = null;
        for(Agent agent: agentsRecord){
            if(foundAgent==null){
                if(agent.isAvailable()){
                    foundAgent = agent;
                }
            }
            else{
                if(agent.isAvailable()){
                    double distance1 = Math.abs(agent.getAgentLocation() - order.getCustomerLocation());
                    double distance2 = Math.abs(foundAgent.getAgentLocation() - order.getCustomerLocation());

                    if(distance2<distance1){
                        foundAgent=agent;
                    }
                }
            }
        }
        return foundAgent;
    }
    
}

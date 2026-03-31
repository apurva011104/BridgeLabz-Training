import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PolicyManager {
    
    private final HashMap<String, Policy> policiesRecord;
    private final TreeMap<LocalDate, List<Policy>> policies;

    public PolicyManager(){
        this.policiesRecord = new LinkedHashMap<>();
        this.policies = new TreeMap<>();
    }

    private static boolean isExpired(LocalDate expiryDate){
        return expiryDate.isBefore(LocalDate.now());
    }

    public void addPolicy(Policy policy){
        if(policiesRecord.containsKey(policy.getPolicyNumber())){
            System.out.println("Policy with this number already exists in the record.");
            return;
        }
        policiesRecord.put(policy.getPolicyNumber(), policy);
        policies.putIfAbsent(policy.getExpiryDate(),new ArrayList<>());
        policies.get(policy.getExpiryDate()).add(policy);
        System.out.println("Policy added to record successfully");
    }

    public void searchPolicy(String policyNumber){
        if(!policiesRecord.containsKey(policyNumber)){
            System.out.println("No policy with this policy number found in the record");
            return;
        }
        System.out.println(policiesRecord.get(policyNumber));
    }

    public void listAllPolicies(){
        for(Map.Entry<String, Policy> entry: policiesRecord.entrySet()){
            if(!isExpired(entry.getValue().getExpiryDate())){
                System.out.println(entry.getValue());
            }
        }
    }

    public void listPoliciesExpiringWithinThirtyDays(){
        System.out.println("*****************************************");
        System.out.println("Expiring policies within the 30 days: ");
        for(Map.Entry<LocalDate, List<Policy>> entry: policies.entrySet()){
            if(!isExpired(entry.getKey()) && ChronoUnit.DAYS.between(LocalDate.now(),entry.getKey())<=30){
                for(Policy policy: entry.getValue()){
                    System.out.println(policy);
                }
            }
        }
        System.out.println("*********************************************");
    }

    public void listPoliciesForPolicyHolder(String policyHolder){
        System.out.println("********************************");
        boolean havePolicy = false;
        for(Map.Entry<String, Policy> entry: policiesRecord.entrySet()){
            Policy policy = entry.getValue();
            if(!isExpired(policy.getExpiryDate()) && policyHolder.equalsIgnoreCase(policy.getPolicyHolder())){
                havePolicy = true;
                System.out.println(policy);
            }
        }
        if(!havePolicy){
            System.out.println("No policy found for the "+policyHolder);
        }
        System.out.println("***********************************");
    }

    public void removeExpiredPolicies(){
        List<Policy> policiesToRemove = new ArrayList<>();
        for(Map.Entry<LocalDate, List<Policy>> entry: policies.entrySet()){
            if(isExpired(entry.getKey())){
                for(Policy policy: entry.getValue()){
                    policiesToRemove.add(policy);
                }
            }
        }

        if(policiesToRemove.isEmpty()){
            System.out.println("No expired policy found");
        }
        else{
            for(Policy policy: policiesToRemove){
                removePolicy(policy);
            }
            System.out.println("All expired policy removed successfully");
        }
    }

    private void removePolicy(Policy policy){
        policiesRecord.remove(policy.getPolicyNumber());
        policies.get(policy.getExpiryDate()).remove(policy);
    }
}

public class InsurancePolicyManagementSystem {
    public static void main(String[] args) {

        Policy policy1 = new Policy("P1234","Ava","03-03-2026");
        Policy policy2 = new Policy("P2546", "Jane", "20-02-2026");
        Policy policy3 = new Policy("P5775","Alice","01-01-2026");
        Policy policy4 = new Policy("P1526","Ava","24-04-2026");
        Policy policy5 = new Policy("P1258","Ava","01-02-2026");
        PolicyManager policyManager = new PolicyManager();

        policyManager.addPolicy(policy1);
        policyManager.addPolicy(policy2);
        policyManager.addPolicy(policy3);
        policyManager.addPolicy(policy4);
        policyManager.addPolicy(policy5);
        
        policyManager.listAllPolicies();
        System.out.println();

        policyManager.searchPolicy("P1258");
        policyManager.listPoliciesExpiringWithinThirtyDays();
        policyManager.listPoliciesForPolicyHolder("Ava");

        policyManager.removeExpiredPolicies();

        policyManager.listAllPolicies();

    }
}

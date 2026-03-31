public class RobotHazardAuditor {

    private enum MachineryState{
        Worn(1.3),
        Faulty(2.0),
        Critical(3.0);

        private final double factor;

        private MachineryState(double factor) {
            this.factor = factor;
        }

        public double getFactor(){
            return factor;
        }
        
    }

    public double calculateHazardRisk(double armPrecision, int workerDensity, String machineryState) throws RobotSafetyException{
        if(armPrecision<0 || armPrecision>1){
            throw new RobotSafetyException("Error: Arm precision must be 0.0-1.0");
        }
        if(workerDensity<1 || workerDensity>20){
            throw new RobotSafetyException("Error: Worker density must be 1-20");
        }
        double machineRiskFactor = -1;
        for(MachineryState state: MachineryState.values()){
            if(state.toString().equals(machineryState)){
                machineRiskFactor = state.getFactor();
            }
        }
        if(machineRiskFactor == -1){
            throw new RobotSafetyException("Error: Unsupported machinery state");
        }

        double hazardRisk = ((1.0 - armPrecision) * 15.0) + (workerDensity * machineRiskFactor);
        return hazardRisk;
    }

}

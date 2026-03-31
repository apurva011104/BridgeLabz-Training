import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

public class Policy {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-uuuu").withResolverStyle(ResolverStyle.STRICT);
    private final String policyNumber;
    private final String policyHolder;
    private final LocalDate expiryDate;

    public Policy(String policyNumber, String policyHolder, String expiryDate) throws DateTimeParseException{
        this.policyNumber = policyNumber;
        this.policyHolder = policyHolder;
        this.expiryDate = LocalDate.parse(expiryDate, FORMATTER);
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public String getPolicyHolder() {
        return policyHolder;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    @Override
    public String toString(){
        return "Policy Number: "+policyNumber+", Policy holder: "+policyHolder+", Expiry Date: "+expiryDate;
    }
}

import java.util.ArrayList;
import java.util.List;

public class AuditorDashboard 
{
    private int dashboardId;
    private String name;

    private final List<Transaction> flaggedTransactions = new ArrayList<>();  // 0..* Review

    public AuditorDashboard(int dashboardId, String name)
    {
        this.dashboardId = dashboardId;
        this.name = name;
    }

    public void viewDashboard() 
    {
        System.out.println("=== Auditor Dashboard ===");
        if (flaggedTransactions.isEmpty()) 
        {
            System.out.println("No flagged transactions.");
            return;
        }
        for (Transaction t : flaggedTransactions) 
        {
            System.out.println(t.getFlaggedTransactions());
        }
    }
    
}

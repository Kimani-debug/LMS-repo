import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.management.relation.Role;

import static org.junit.jupiter.api.Assertions.*;

class MarkReviewTest {

    private Transaction transaction;
    private Review review;
    private Auditor auditor;
    private AuditorServices auditorServices;

    @BeforeEach
    void setUp() {
        // A fresh, flagged transaction with one open review before every test
        transaction = new Transaction(101, "Event catering", LocalDate.of(2026, 10, 1), 1250.00, true);
        AuditorDashboard dashboard = new AuditorDashboard();

        List<Auditor> auditorAccounts = new ArrayList<>();

        Auditor auditor1 = new Auditor(3684, "Jane Doe", "jane@example.org");
        Auditor auditor2 = new Auditor(3857, "Jaime Tomas", "jaime@example.org");
        Auditor auditor3 = new Auditor(3749, "Mike Doe", "mike@example.org");

        auditorServices = new AuditorServices(auditor1); // Assuming we want to test with the first auditor
        auditorServices = new AuditorServices(auditor2); // Assuming we want to test with the second auditor
        auditorServices = new AuditorServices(auditor3); // Assuming we want to test with the third auditor


    }

    @Test
    @DisplayName("TC1 (P1, B1): TREASURER role is denied")
    void auditorIsAccepted() {
        assertEquals("SUCCESS - access granted", auditorServices.requestDashboard(3749, Enumerators.Role.AUDITOR));
    }
    void auditorUserNotFound() {
        assertEquals("FAILURE - user not found", auditorServices.requestDashboard(3997, Enumerators.Role.AUDITOR));
    }
    void treasurerIsDenied() {
        assertEquals("FAILURE - access denied", auditorServices.requestDashboard(2939, Enumerators.Role.TREASURER));
    }
    void memberIsDenied() {
        assertEquals("FAILURE - access denied", auditorServices.requestDashboard(1434, Enumerators.Role.MEMBER));
    }

    void sysadminIsAccepted() {
        assertEquals("SUCCESS - access granted", auditorServices.requestDashboard(8473, Enumerators.Role.SYSADMIN));
    }

    @Test
    @DisplayName("TC1 (P1, B1): CLEARED is accepted”)
    void clearedIsAccepted() {
        assertEquals("CLEARED", review.markReview("CLEARED"));
    }
    @Test
    @DisplayName("TC2 (P2, B2): CORRECTED is accepted”)
    void correctedIsAccepted() {
        assertEquals("CORRECTED", review.markReview("CORRECTED"));
    }
    @Test
    @DisplayName("TC3 (P3, B3): ESCALATED is accepted”)
    void escalatedIsAccepted() {
        assertEquals("ESCALATED", review.markReview("ESCALATED"));
    }
    @Test
    @DisplayName("TC4 (P4, B4): NONE is accepted”)
    void noneIsAccepted() {
        assertEquals("NONE", review.markReview("NONE"));
    }

}

}

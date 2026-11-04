::: mermaid
flowchart TD;
    N1(["N1: AuditorServices.requestDashboard(int userId, Role userRole)"]) --> N2{"N2: userRole == AUDITOR"};  
    
    N2 --> |T| N3{"N3: Auditor.accountExists(userId)?"};

    N3 --> |T| N4["N4: SUCCESS - access granted"];
    N3 --> |F| N5["N5: FAILURE - user not found"];

    N2 --> |F| N6{"N6: userRole == Role.ADMIN?"};
    
    N6 --> |T| N7["N7: SUCCESS - access granted"];
    N6 --> |F| N8{"N8: userRole == Role.TREASURER?"};

    N8 --> |T| N9["N9: UNAUTHORIZED - access denied"];
    N8 --> |F| N10{"N10: userRole == MEMBER"};

    N10 --> |T| N11["N11: UNAUTHORIZED - access denied"];
    N10 --> |F| N12["N12: INVALID USER"]

    N4 --> N13(["N13:result/exit"]);

    N5 --> N13;
    N7 --> N13;
    N9 --> N13;
    N11 --> N13;
    N12 --> N13;
:::
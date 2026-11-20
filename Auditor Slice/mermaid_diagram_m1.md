::: mermaid
flowchart TD;
    N1(["N1: markReview"]) --> N2{"N2: label==CORRECTED?"}; 
    N2 --> |T| N3["N3: enum_CORRECTED"];
    N2 -->|F| N4{"N4: label==CLEARED?"};
    N4 --> |T| N5["N5: enum_CLEARED"];
    N4 --> |F| N6{"N6: label==ESCALATED?"};
    N6 --> |T| N7["N7: enum_ESCALATED"];
    N6 --> |F| N8{"N8: Invalid"};
    
    N3 --> N9(["N9:result/exit"]);
    N5 --> N9;
    N7 --> N9;
    N8 --> N9;
    
:::
public class Auditor 
{
    private int auditorId;
    private String name;
    private String email;;

    public Auditor(int auditorId, String name, String email)
    {
        this.auditorId = auditorId;
        this.name = name;
        this.email = email;
        
    }

    public int getAuditorId() { return auditorId; }
    public String getName() { return name; }
    public String getEmail() { return email; }

    @Override
    public String toString() {
        return "Auditor{id=" + auditorId + ", name='" + name + "', email='" + email + "'}";
    }

}

package Adapter;

public class EmployeeLdap {

    private String cn;
    private String surname;
    private String givenName;
    private String mail;

    public EmployeeLdap(String cn, String sn, String gn, String mail){
        this.cn = cn;
        this.surname = sn;
        this.givenName = gn;
        this.mail = mail;
    }


    public String getCn() {
        return cn;
    }

    public String getSurname() {
        return surname;
    }

    public String getGivenName() {
        return givenName;
    }

    public String getMail() {
        return mail;
    }


}

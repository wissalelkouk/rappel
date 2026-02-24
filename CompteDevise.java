public class CompteDevise extends Compte {
    private String devise;

    public CompteDevise(int id, String proprietaire, double solde, String devise) {
        super(id, proprietaire, solde);
        this.devise = devise;
    }

    public String getDevise() { return devise; }
    public void setDevise(String devise) { this.devise = devise; }

    @Override
    public String toString() {
        return "CompteDevise{id=" + getId() + ", proprietaire='" + getProprietaire() +
               "', solde=" + getSolde() + " " + devise + "}";
    }
}
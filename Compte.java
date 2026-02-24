public class Compte {
    private int id;
    private String proprietaire;
    private double solde;

    public Compte(int id, String proprietaire, double solde) {
        this.id = id;
        this.proprietaire = proprietaire;
        this.solde = solde;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getProprietaire() { return proprietaire; }
    public void setProprietaire(String proprietaire) { this.proprietaire = proprietaire; }

    public double getSolde() { return solde; }
    public void setSolde(double solde) { this.solde = solde; }

    public void deposer(double montant) throws MontantNonValideException {
        if (montant <= 0) throw new MontantNonValideException("Le montant à déposer doit être positif.");
        solde += montant;
    }

    public void retirer(double montant) throws MontantNonValideException {
        if (montant <= 0) throw new MontantNonValideException("Le montant à retirer doit être positif.");
        if (montant > solde) throw new MontantNonValideException("Solde insuffisant.");
        solde -= montant;
    }

    @Override
    public String toString() {
        return "Compte{id=" + id + ", proprietaire='" + proprietaire + "', solde=" + solde + "}";
    }
}
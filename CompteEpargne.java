public class CompteEpargne extends Compte {
    private double tauxInteret;

    public CompteEpargne(int id, String proprietaire, double solde, double tauxInteret) {
        super(id, proprietaire, solde);
        this.tauxInteret = tauxInteret;
    }

    public double getTauxInteret() { return tauxInteret; }
    public void setTauxInteret(double tauxInteret) { this.tauxInteret = tauxInteret; }

    public double calculerInterets() {
        return getSolde() * tauxInteret / 100;
    }

    @Override
    public String toString() {
        return "CompteEpargne{id=" + getId() + ", proprietaire='" + getProprietaire() +
               "', solde=" + getSolde() + ", tauxInteret=" + tauxInteret +
               ", interets=" + calculerInterets() + "}";
    }
}
public class TestCompte {
    public static void main(String[] args) {
        try {
            // Test Compte
            Compte c = new Compte(1, "Alice", 1000.0);
            System.out.println(c);

            c.deposer(500.0);
            System.out.println("Après dépôt de 500 : " + c);

            c.retirer(200.0);
            System.out.println("Après retrait de 200 : " + c);

            // Test CompteEpargne
            CompteEpargne ce = new CompteEpargne(2, "Bob", 2000.0, 3.5);
            System.out.println(ce);
            System.out.println("Intérêts : " + ce.calculerInterets());

            // Test CompteDevise
            CompteDevise cd = new CompteDevise(3, "Carol", 500.0, "EUR");
            System.out.println(cd);

            // Test exception montant invalide
            c.retirer(-100);

        } catch (MontantNonValideException e) {
            System.out.println("Exception capturée : " + e.getMessage());
        }

        // Test connexion PostgreSQL
        CompteDAO dao = new CompteDAO();
        dao.afficherTousLesComptes();
    }
}
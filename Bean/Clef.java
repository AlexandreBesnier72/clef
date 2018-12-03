package clef.Bean;

public class Clef
{
    private String id;
    private String proprietaire;
    private String porte;
    private String marque;
    private char technologie;
    private String matiere;
    private boolean dispo = true;

    private String[] proprietaires = {
            "Alexandre",
            "Vincent",
            "Laurence",
            "Cindy",
            "Christophe",
            "Christine",
            "André",
            "Willy",
            "Pierre-maxence",
            "Cyril",
            "Melvin",
            "Alan",
            "Florent",
            "Dan",
            "Ludovic",
            "David",
            "Roger"
    };

    private String[] marques = {
            "Toto",
            "Lulu",
            "Vrooom",
            "Tata",
            "Tutu"
    };

    private char[] technologies = {
            'a',
            'e'
    };

    private String[] matieres = {
            "Plastique",
            "Acier",
            "Aluminium",
            "Titane",
            "Mithril",
            "Diamant"
    };

    // constructeurs
    public Clef()
    {
        setDispo( false );
    }

    public Clef(int number, String proprietaire, String porte, String marque, char technologie, String matiere, boolean dispo)
    {
        setProprietaire( proprietaire );
        setPorte( porte );
        setMarque( marque );
        setTechnologie( technologie );
        setMatiere( matiere );
        setDispo( dispo );
        setId( number );
    }

    // setters
    public void setId(int number)
    {
        String id;

        id = this.proprietaire.substring(0, 4).toUpperCase();
        id += String.format("%03d", number);
        id += this.marque.substring(0, 2).toUpperCase();
        this.id = id;
    }

    public void setProprietaire(String proprietaire)
    {
        this.proprietaire = proprietaire;
    }

    public void setPorte(String porte)
    {
        this.porte = porte;
    }

    public void setMarque(String marque)
    {
        this.marque = marque;
    }

    public void setTechnologie(char technologie)
    {
        this.technologie = technologie;
    }

    public void setMatiere(String matiere)
    {
        this.matiere = matiere;
    }

    public void setDispo(boolean dispo)
    {
        this.dispo = dispo;
    }

    //Getters
    public String getId()
    {
        return this.id;
    }

    public String getProprietaire()
    {
        return proprietaire;
    }

    public String getPorte()
    {
        return porte;
    }

    public String getMarque()
    {
        return marque;
    }

    public char getTechnologie()
    {
        return technologie;
    }

    public String getMatiere()
    {
        return matiere;
    }

    public boolean isDispo()
    {
        return dispo;
    }
}

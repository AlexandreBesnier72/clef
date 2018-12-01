package clef;

import java.util.ArrayList;
import java.util.Iterator;

public class Gestion_clefs
{
    // tableau avec les clefs
    private ArrayList<Clef> clefs = new ArrayList<>();

    public Gestion_clefs()
    {
    }

    /**
     * récupère la permière clé
     * @return l'id de la clé
     */
    public String getFirstClefs()
    {
        int i = 0;
        boolean trouver = false;
        while ( !trouver && clefs.size() != 0 )
        {
            trouver = true;
            i++;
        }

        if ( trouver )
        {
            return clefs.get(i - 1).getId();
        }
        else
        {
            return null;
        }
    }

    /**
     * vérifie si une clef existe
     * @param id de la clef
     * @return true si la clef existe
     */
    public boolean clefExist( String id )
    {
        boolean exist = false;
        int i = 0;

        do
        {
            if ( clefs.get(i) != null )
            {
                if ( clefs.get(i).getId().equals( id ) )
                {
                    exist = true;
                }
            }
            i++;
        } while( !exist );

        return exist;
    }

    /**
     * Ajoute une clef
     * @param newClef stock la nouvelle clef
     */
    public void add( Iterator newClef )
    {
        String proprietaire = newClef.next().toString();
        String porte = newClef.next().toString();
        String marque = newClef.next().toString();
        char technologie = newClef.next().toString().charAt(0);
        String matiere = newClef.next().toString();
        boolean dispo = Boolean.valueOf(newClef.next().toString());

        int number = this.nbFois( proprietaire ) + 1;;

        clefs.add( new Clef( number, proprietaire, porte, marque, technologie, matiere, dispo ) );
        System.out.println( "Clef ajoutée." );
        this.uneClef( clefs.get(clefs.size() - 1).getId() );
    }

    /**
     * Compte le nombre de paramètre et renvoie vers la bonne méthode "update"
     * @param updateClef stock l'id de la clef, le nom du paramêtre à changer et la nouvelle valeur à assigner
     */
    public void update( Iterator updateClef )
    {
        String id;
        String paramName;
        String value;
        char valueChar;

        id = updateClef.next().toString();
        paramName = updateClef.next().toString();

        // si il y a 3 arguments
        if ( updateClef.hasNext() )
        {
            value = updateClef.next().toString();
            // si le string à une longueur de 1 alors on le convertit en string
            if ( value.length() == 1 )
            {
                valueChar = value.charAt(0);
                this.update(id, paramName, valueChar);
            }
            else
            {
                this.update(id, paramName, value);
            }
        }

        // si il y a 2 arguments
        else
        {
            this.update(id, paramName);
        }
    }
    /**
     * Mets à jour une clef
     * @param id du tableau
     * @param paramName nom du paramêtre
     * @param value nouvelle valeur
     */
    private void update(String id, String paramName, String value)
    {
        if ( this.clefExist( id ) )
        {
            for (int i = 0; i < clefs.size(); i++)
            {
                if ( clefs.get(i) != null )
                {
                    if ( clefs.get(i).getId().equals( id ) )
                    {
                        switch (paramName)
                        {
                            case "propriétaire":
                                clefs.get(i).setProprietaire( value );
                                // mets à jour l'id
                                clefs.get(i).setId( this.nbFois( clefs.get(i).getProprietaire() ) );
                                System.out.println( "Le propriétaire a bien été mis à jour." );
                                break;

                            case "porte":
                                clefs.get(i).setPorte( value );
                                System.out.println( "La porte a bien été mis à jour." );
                                break;

                            case "marque":
                                clefs.get(i).setMarque( value );
                                // mets à jour l'id
                                clefs.get(i).setId( this.nbFois( clefs.get(i).getProprietaire() ) );
                                System.out.println( "La marque a bien été mis à jour." );
                                break;

                            case "matière":
                                clefs.get(i).setMatiere( value );
                                System.out.println( "La matière a bien été mis à jour." );
                                break;

                            default :
                                System.out.println( "La valeur saisie est incorrecte" );
                        }
                    }
                }
            }
        }
        else
        {
            System.out.println( "La clef n'existe pas." );
        }
    }
    private void update(String id, String paramName, char value)
    {
        if ( this.clefExist( id ) )
        {
            for (int i = 0; i < clefs.size(); i++)
            {
                if ( clefs.get(i) != null )
                {
                    if (clefs.get(i).getId().equals(id))
                    {
                        if (paramName.equals("technologie"))
                        {
                            clefs.get(i).setTechnologie(value);
                            System.out.println( "La valeur a bien été mise à jour" );
                        } else
                        {
                            System.out.println("La valeur saisie est incorrecte");
                        }
                    }
                }
            }
        }
        else
        {
            System.out.println( "La clef n'existe pas." );
        }

    }
    private void update(String id, String paramName)
    {
        boolean dispo = true;

        if ( this.clefExist( id ) )
        {
            for (int i = 0; i < clefs.size(); i++)
            {
                if ( clefs.get(i) != null )
                {
                    if (clefs.get(i).getId().equals(id))
                    {
                        if (paramName.equals("dispo"))
                        {
                            if (clefs.get(i).isDispo())
                            {
                                dispo = false;
                            }
                            clefs.get(i).setDispo(dispo);
                            System.out.println("La disponibilité a été mise à jour.");
                        } else
                        {
                            System.out.println("La valeur saisie est incorrecte");
                        }
                    }
                }
            }
        }
        else
        {
            System.out.println( "La clef n'existe pas." );
        }

    }

    /**
     * Détermine si la valeur est sois un character, sois un String ou sois un booléen
     * @param searchClef stock le type et la valeur de la recherche
     */
    public void search( Iterator searchClef )
    {
        String type = searchClef.next().toString();

        switch ( type )
        {
            case "char":
                this.search( searchClef.next().toString().charAt(0) );
                break;

            case "string":
                this.search( searchClef.next().toString() );
                break;

            case "boolean":
                this.search( Boolean.valueOf( searchClef.next().toString() ) );
                break;
        }
    }
    /**
     * Cherche les clefs qui correspondent à la valeur
     * @param value valeur de la recherche
     */
    public void search(String value)
    {
        System.out.println( "Le résultat de la recherche " + value + " est :" );
        for (int i = 0; i < clefs.size(); i++)
        {
            if ( clefs.get(i) != null )
            {
                if ( value.equals( clefs.get(i).getId() ) )
                {
                    afficherClef(i);
                }
                else if ( value.equals( clefs.get(i).getProprietaire() ) )
                {
                    afficherClef(i);
                }
                else if ( value.equals( clefs.get(i).getPorte() ) )
                {
                    afficherClef(i);
                }
                else if ( value.equals( clefs.get(i).getMarque() ) )
                {
                    afficherClef(i);
                }
                else if ( value.equals( clefs.get(i).getMatiere() ) )
                {
                    afficherClef(i);
                }
            }
        }
    }
    public void search(char value)
    {
        System.out.println( "Le résultat de la recherche " + value + " est :" );
        for (int i = 0; i < clefs.size(); i++)
        {
            if ( clefs.get(i) != null )
            {
                if ( value == clefs.get(i).getTechnologie() )
                {
                    afficherClef(i);
                }
            }
        }
    }
    /**
     * Affiche les clefs dispo ou indisponible
     * @param dispo true si c'est les clefs dispo, false si c'est les clefs indispo
     */
    public void search(boolean dispo)
    {
        if ( dispo )
        {
            System.out.println( "Liste des clefs dispo." );
            for (int i = 0; i < clefs.size(); i++)
            {
                if ( clefs.get(i) != null )
                {
                    if ( clefs.get(i).isDispo() )
                    {
                        afficherClef(i);
                    }
                }
            }
        }
        else
        {
            for (int i = 0; i < clefs.size(); i++)
            {
                if ( clefs.get(i) != null )
                {
                    if ( !clefs.get(i).isDispo() )
                    {
                        afficherClef(i);
                    }
                }
            }
            System.out.println( "Liste des clefs indisponible." );
        }

    }

    /**
     * Nombre de fois qu'on ajoute une clé à un propriétaire
     * @param proprietaire recherché
     * @return le nombre de clé déjà possédé par un propriétaire
     */
    public int nbFois( String proprietaire )
    {
        int compteur = 0;
        for (int i = 0; i < clefs.size(); i++)
        {
            if ( clefs.get(i) != null )
            {
                if ( proprietaire.equals( clefs.get(i).getProprietaire() ) )
                {
                    compteur++;
                }
            }
        }
        return compteur;
    }

    /**
     * Supprime une clef
     */
    public void remove(String id)
    {
        if (this.clefExist(id))
        {
            for (int i = 0; i < clefs.size(); i++)
            {
                if ( clefs.get(i) != null )
                {
                    if ( clefs.get(i).getId().equals( id ) )
                    {
                        clefs.remove(i);
                        System.out.println( "Clef supprimée." );
                    }
                }
            }
        }
        else
        {
            System.out.println( "La clef n'existe pas." );
        }
    }

    /**
     * affiche la liste des clefs
     */
    public void liste()
    {
        System.out.println( "Liste des clefs :" );
        for (int i = 0; i < clefs.size(); i++)
        {
            this.afficherClef(i);
        }
    }

    /**
     * Affiche une clé
     * @param id de la clé à afficher
     */
    public void uneClef( String id )
    {
        boolean trouver = false;
        int i = 0;
        do
        {
            if ( clefs.get(i).getId().equals( id ) )
            {
                this.afficherClef(i);
                trouver = true;
            }
            i++;
        } while( !trouver && i < clefs.size() );
    }

    /**
     * Permet d'afficher une clef précise
     * @param idArray de la clef à afficher
     */
    private void afficherClef(int idArray)
    {
        if ( clefs.get(idArray) != null )
        {
            System.out.println(
                    String.valueOf( "ID : " + clefs.get(idArray).getId()) + " | " +
                            "Propriétaire : " + clefs.get(idArray).getProprietaire() + " | " +
                            "Porte : " + clefs.get(idArray).getPorte() + " | " +
                            "Marque : " + clefs.get(idArray).getMarque() + " | " +
                            "Technologie : " + clefs.get(idArray).getTechnologie() + " | " +
                            "Matière : " + clefs.get(idArray).getMatiere() + " | " +
                            "Disponibilité : " + clefs.get(idArray).isDispo()
            );
        }
    }
}

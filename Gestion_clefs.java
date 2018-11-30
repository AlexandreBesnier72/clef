package clef;

import java.util.Iterator;

public class Gestion_clefs
{
    private int maxClefs;

    // tableau avec les clefs
    private Clef[] clefs;

    public Gestion_clefs( int maxClefs )
    {
        this.maxClefs = maxClefs;
        this.clefs  = new Clef[this.maxClefs];

        // initialisation du tableau
        for (int i = 0; i < maxClefs; i++)
        {
            clefs[i] = null;
        }
    }

    /**
     * récupère la permière clé
     * @return l'id de la clé
     */
    public String getFirstClefs()
    {
        if (clefs[0] != null)
        {
            return clefs[0].getId();
        }
        else
        {
            return "";
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
            if ( clefs[i] != null )
            {
                if ( clefs[i].getId().equals( id ) )
                {
                    exist = true;
                }
            }
            i++;
        } while( !exist && i < this.maxClefs );

        return exist;
    }

    /**
     * Vérifie si l'objet est complet
     * @return true si il y a de la place
     */
    private boolean isClefsComplet ()
    {
        boolean complet = true;
        int i = 0;

        do
        {
            if (clefs[i] == null)
            {
                complet = false;
            }
            i++;
        } while( complet && i < this.maxClefs);

        return complet;
    }

    /**
     * cherche une place libre dans l'objet clefs
     * @return l'id de la première place disponible
     */
    private int placeLibre()
    {
        boolean trouver = false;
        int i = 0;
        do
        {
            if (clefs[i] == null)
            {
                trouver = true;
            }
            i++;
        } while( !trouver );

        return --i;
    }

    /**
     * Ajoute une clef
     */
    public void add( Iterator newClef )
    {
        String proprietaire = newClef.next().toString();
        String porte = newClef.next().toString();
        String marque = newClef.next().toString();
        char technologie = newClef.next().toString().charAt(0);
        String matiere = newClef.next().toString();
        boolean dispo = Boolean.valueOf(newClef.next().toString());

        int number;
        int id;

        if ( !isClefsComplet() )
        {
            id = this.placeLibre();

            number = this.nbFois( proprietaire ) + 1;

            clefs[id] = new Clef( number, proprietaire, porte, marque, technologie, matiere, dispo );
            System.out.println( "Clef ajoutée." );
        }
        else
        {
            System.out.println( "On ne peut plus ajouter de clé, l'espace mémoire est pleins." );
        }
    }

    /**
     * Mets à jour une clef
     * @param id du tableau
     * @param paramName nom du paramêtre
     * @param value nouvelle valeur
     */
    public void update(String id, String paramName, String value)
    {
        for (int i = 0; i < maxClefs; i++)
        {
            if ( clefs[i] != null )
            {
                if ( clefs[i].getId().equals( id ) )
                {
                    switch (paramName)
                    {
                        case "propriétaire":
                            clefs[i].setProprietaire( value );
                            // mets à jour l'id
                            clefs[i].setId( this.nbFois( clefs[i].getProprietaire() ) );
                            System.out.println( "Le propriétaire a bien été mis à jour." );
                            break;

                        case "porte":
                            clefs[i].setPorte( value );
                            System.out.println( "La porte a bien été mis à jour." );
                            break;

                        case "marque":
                            clefs[i].setMarque( value );
                            // mets à jour l'id
                            clefs[i].setId( this.nbFois( clefs[i].getProprietaire() ) );
                            System.out.println( "La marque a bien été mis à jour." );
                            break;

                        case "matière":
                            clefs[i].setMatiere( value );
                            System.out.println( "La matière a bien été mis à jour." );
                            break;

                        default :
                            System.out.println( "La valeur saisie est incorrecte" );
                    }
                }
            }
        }
    }
    public void update(String id, String paramName, char value)
    {
        for (int i = 0; i < maxClefs; i++)
        {
            if ( clefs[i] != null )
            {
                if (clefs[i].getId().equals(id))
                {
                    if (paramName.equals("technologie"))
                    {
                        clefs[i].setTechnologie(value);
                        System.out.println( "La valeur a bien été mise à jour" );
                    } else
                    {
                        System.out.println("La valeur saisie est incorrecte");
                    }
                }
            }
        }
    }
    public void update(String id, String paramName)
    {
        boolean dispo = true;

        for (int i = 0; i < maxClefs; i++)
        {
            if ( clefs[i] != null )
            {
                if (clefs[i].getId().equals(id))
                {
                    if (paramName.equals("dispo"))
                    {
                        if (clefs[i].isDispo())
                        {
                            dispo = false;
                        }
                        clefs[i].setDispo(dispo);
                        System.out.println("La disponibilité a été mise à jour.");
                    } else
                    {
                        System.out.println("La valeur saisie est incorrecte");
                    }
                }
            }
        }
    }

    /**
     * Cherche les clefs qui correspondent à la valeur
     * @param value valeur de la recherche
     */
    public void search(String value)
    {
        System.out.println( "Le résultat de la recherche " + value + " est :" );
        for (int i = 0; i < maxClefs; i++)
        {
            if ( clefs[i] != null )
            {
                if ( value.equals( clefs[i].getId() ) )
                {
                    afficherClef(i);
                }
                else if ( value.equals( clefs[i].getProprietaire() ) )
                {
                    afficherClef(i);
                }
                else if ( value.equals( clefs[i].getPorte() ) )
                {
                    afficherClef(i);
                }
                else if ( value.equals( clefs[i].getMarque() ) )
                {
                    afficherClef(i);
                }
                else if ( value.equals( clefs[i].getMatiere() ) )
                {
                    afficherClef(i);
                }
            }
        }
    }
    public void search(char value)
    {
        System.out.println( "Le résultat de la recherche " + value + " est :" );
        for (int i = 0; i < maxClefs; i++)
        {
            if ( clefs[i] != null )
            {
                if ( value == clefs[i].getTechnologie() )
                {
                    afficherClef(i);
                }
            }
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
        for (int i = 0; i < maxClefs; i++)
        {
            if ( clefs[i] != null )
            {
                if ( proprietaire.equals( clefs[i].getProprietaire() ) )
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
            for (int i = 0; i < maxClefs; i++)
            {
                if ( clefs[i] != null )
                {
                    if ( clefs[i].getId().equals( id ) )
                    {
                        clefs[i] = null;
                        System.out.println( "Clef supprimée." );
                    }
                }
            }
        }
        else
        {
            System.out.println( "La clé n'existe pas." );
        }
    }

    /**
     * Affiche les clefs dispo ou indisponible
     * @param dispo true si c'est les clefs dispo, false si c'est les clefs indispo
     */
    public void clefsDispoIndispo( boolean dispo )
    {
        if ( dispo )
        {
            System.out.println( "Liste des clefs dispo." );
            for (int i = 0; i < maxClefs; i++)
            {
                if ( clefs[i] != null )
                {
                    if ( clefs[i].isDispo() )
                    {
                        afficherClef(i);
                    }
                }
            }
        }
        else
        {
            for (int i = 0; i < maxClefs; i++)
            {
                if ( clefs[i] != null )
                {
                    if ( !clefs[i].isDispo() )
                    {
                        afficherClef(i);
                    }
                }
            }
            System.out.println( "Liste des clefs indisponible." );
        }

    }

    /**
     * affiche la liste des clefs
     */
    public void liste()
    {
        System.out.println( "Liste des clefs :" );
        for (int i = 0; i < maxClefs; i++)
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
            if (clefs[i] != null)
            {
                if ( clefs[i].getId().equals( id ) )
                {
                    this.afficherClef(i);
                    trouver = true;
                }
            }
            i++;
        } while( !trouver || i >= maxClefs );
    }

    /**
     * Permet d'afficher une clef précise
     * @param idArray de la clef à afficher
     */
    private void afficherClef(int idArray)
    {
        if ( clefs[idArray] != null )
        {
            System.out.println(
                    String.valueOf( "ID : " + clefs[idArray].getId()) + " | " +
                            "Propriétaire : " + clefs[idArray].getProprietaire() + " | " +
                            "Porte : " + clefs[idArray].getPorte() + " | " +
                            "Marque : " + clefs[idArray].getMarque() + " | " +
                            "Technologie : " + clefs[idArray].getTechnologie() + " | " +
                            "Matière : " + clefs[idArray].getMatiere() + " | " +
                            "Disponibilité : " + clefs[idArray].isDispo()
            );
        }
    }
}

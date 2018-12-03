package clef.View;

import clef.Dao.Dao_clef;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class View_console
{
    private Scanner sc = new Scanner( System.in );
    private View_error viewError = new View_error();

    /**
     * Méthodes de saisie, contient le texte correspondant à l'entrée souhaiter + une saisie de l'utilisateur
     * @return la saisie
     */
    private int saisieMenu()
    {
        int saisie;

        saisie = sc.nextInt();
        sc.nextLine(); // debug

        return saisie;
    }
    private String saisieId()
    {
        String saisie;

        System.out.println( "Qu'elle est l'id de la clé ?" );
        saisie = sc.nextLine();

        return saisie;
    }
    private String saisiePropio()
    {
        String saisie;

        System.out.println( "Qu'elle est le nom du propriétaire ? ( min 4 caractères )" );
        saisie = sc.nextLine();

        return saisie;
    }
    private String saisiePorte()
    {
        String saisie;

        System.out.println( "Qu'elle est le nom de la porte ?" );
        saisie = sc.nextLine();

        return saisie;
    }
    private String saisieMarque()
    {
        String saisie;

        System.out.println( "Qu'elle est le nom de la marque ? ( min 2 caractères )" );
        saisie = sc.nextLine();

        return saisie;
    }
    private char saisieTechno()
    {
        char saisie;

        System.out.println( "Qu'elle technologie utilise la clef ? [A/E]");
        saisie = sc.next().toLowerCase().charAt(0);
        sc.nextLine(); // debug

        return saisie;
    }
    private String saisieMatiere()
    {
        String saisie;

        System.out.println( "De quelle matière est faite la clef ?" );
        saisie = sc.nextLine();

        return saisie;
    }
    private char saisieDispo()
    {
        char saisie;

        System.out.println( "La clé est-elle dispo ? [O/N]" );
        saisie = sc.next().toLowerCase().charAt(0);
        sc.nextLine(); // debug

        return saisie;
    }
    private String saisieValue()
    {
        String saisie;

        System.out.println( "Entrez la valeur :" );
        saisie = sc.nextLine();

        return saisie;
    }

    /**
     * Affiche le menu principale
     * @return l'entier saisie correspondant à l'action souhaitée
     */
    public int mainMenu()
    {
        // saisie
        int saisie;

        System.out.println( "Que voulez-vous faire ?" );
        System.out.println( "[1] ajouter une clé." );
        System.out.println( "[2] supprimer une clé." );
        System.out.println( "[3] mettre à jour une clé." );
        System.out.println( "[4] faire une recherche." );
        System.out.println( "[5] afficher la liste des clefs." );
        System.out.println( "[6] afficher une clefs précise." );
        System.out.println( "[7] sortir du programme." );

        saisie = this.saisieMenu();

        return saisie;
    }

    /**
     * Récupère les données dont le controller à besoin pour créer une nouvelle clef
     * @return les données de la nouvelle clef
     */
    public Iterator add()
    {
        // Objet de stockage des saisies
        ArrayList<Object> saisie = new ArrayList<>();

        // objet de retour
        Iterator newClef;

        // saisie d'attribut de clef
        String saisieProprio;
        String saisiePorte;
        String saisieMarque;
        char saisieTechno;
        String saisieMatiere;
        char saisieDispo;
        boolean dispo = false;

        // variable d'erreur
        boolean error;

        do
        {
            saisieProprio = this.saisiePropio();
            saisiePorte = this.saisiePorte();
            saisieMarque = this.saisieMarque();
            saisieTechno = this.saisieTechno();
            saisieMatiere = this.saisieMatiere();
            saisieDispo = this.saisieDispo();

            if ( saisieDispo == 'o')
            {
                dispo = true;
            }
            else if ( saisieDispo == 'n' )
            {
                dispo = false;
            }

            // vérif
            error = viewError.errorDispo(saisieDispo);
            if ( !error )
            {
                error = viewError.errorProprio(saisieProprio);
            }

            if ( !error )
            {
                error = viewError.errorMarque(saisieMarque);
            }

        } while(error);

        saisie.add( saisieProprio );
        saisie.add( saisiePorte );
        saisie.add( saisieMarque );
        saisie.add( saisieTechno );
        saisie.add( saisieMatiere );
        saisie.add( dispo );

        newClef = saisie.iterator();

        return newClef;
    }

    /**
     * Récupère l'id de la clef à supprimer
     * @return l'id de la clef à supprimer
     */
    public String remove()
    {
        String saisieId;

        saisieId = this.saisieId();

        return saisieId;
    }

    /**
     * Récupère l'id de la clef à modifier, ainsi que le nom du champs et la nouvelle valeur à assigner
     * @return l'id, le nom du champs et la nouvelle valeur
     */
    public Iterator update( Dao_clef gc )
    {
        // Objet de stockage des saisies
        ArrayList<Object> saisie = new ArrayList<>();

        // objet de retour
        Iterator updateClef;

        // variable d'erreur
        boolean error;

        int saisieMenu;
        String saisieId;
        String saisieProprio;
        String saisiePorte;
        String saisieMarque;
        char saisieTechno;
        String saisieMatiere;
        boolean saisieDispo = false;

        do
        {
            error = false;

            saisieId = this.saisieId();

            // vérifie si la clef existe
            if ( gc.clefExist( saisieId ) )
            {
                saisie.add(saisieId);
                gc.uneClef( saisieId );

                System.out.println( "Quelle est le nom du champs à modifier ?" );
                System.out.print( "[1] Propriétaire - " );
                System.out.print( "[2] Numéro de la porte - " );
                System.out.print( "[3] Marque - " );
                System.out.print( "[4] Technologie - " );
                System.out.print( "[5] Matière - " );
                System.out.println( "[6] La disponibilité" );

                saisieMenu = this.saisieMenu();

                switch ( saisieMenu )
                {
                    // proprio
                    case 1 :
                        do
                        {
                            saisieProprio = this.saisiePropio();
                        } while ( saisieProprio.length() < 4 );

                        saisie.add("propriétaire");
                        saisie.add(saisieProprio);
                        break;

                    // porte
                    case 2 :
                        saisie.add("porte");
                        saisie.add( this.saisiePorte() );
                        break;

                    // marque
                    case 3 :
                        do
                        {
                            saisieMarque = this.saisieMarque();
                        } while( saisieMarque.length() < 2 );

                        saisie.add("marque");
                        saisie.add(saisieMarque);
                        break;

                    // techno
                    case 4 :
                        do
                        {
                            saisieTechno = this.saisieTechno();
                        } while ( saisieTechno != 'a' && saisieTechno != 'e' );

                        saisie.add("technologie");
                        saisie.add(saisieTechno);
                        break;

                    // matière
                    case 5 :
                        saisie.add("matière");
                        saisie.add( this.saisieMatiere() );
                        break;

                    // disponibilité
                    case 6 :
                        saisie.add("dispo");
                        break;

                    default :
                        System.out.println( "Erreur de saisie" );
                }
            }
            else
            {
                System.out.println( "La clé n'existe pas" );
            }

        } while ( error );

        updateClef = saisie.iterator();

        return updateClef;
    }

    /**
     * Récupère le type de données sur laquelle va s'effectuer la recherche et la veleur à rechercher
     * @return le type de données et la recherche
     */
    public Iterator search()
    {
        ArrayList<Object> saisie = new ArrayList<>();
        Iterator searchClef;
        int saisieMenu;

        System.out.println( "[1] la recherche est un caractère." );
        System.out.println( "[2] la recherche est une chaine de caratères." );
        System.out.println( "[3] Afficher toutes les clefs disponible." );
        System.out.println( "[4] Afficher toutes les clefs indisponible." );
        saisieMenu = this.saisieMenu();

        switch (saisieMenu)
        {
            // char
            case 1 :
                saisie.add( "char" );
                saisie.add( this.saisieValue().charAt(0) );
                break;

            // string
            case 2 :
                saisie.add( "string" );
                saisie.add( this.saisieValue() );
                break;

            // dispo - true
            case 3 :
                saisie.add( "boolean" );
                saisie.add( true );
                break;

            // dispo - false
            case 4 :
                saisie.add( "boolean" );
                saisie.add( false );
                break;

            default:
                System.out.println( "La saisie est invalide." );
        }

        searchClef = saisie.iterator();

        return searchClef;
    }

    /**
     * Récupère l'id de la clef à afficher
     * @return l'id de la clef à afficher
     */
    public String listOneKey()
    {
        String saisieId;

        saisieId = this.saisieId();

        return saisieId;
    }
}

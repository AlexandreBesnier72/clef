package clef;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class View_clef
{
    private Scanner sc = new Scanner( System.in );

    private boolean errorProprio( String saisie )
    {
        boolean error = false;

        if ( saisie.length() < 4 )
        {
            error = true;
            System.out.println( "Le nom du propiétaire est trop court." );
        }

        return error;
    }

    private boolean errorMarque( String saisie )
    {
        boolean error = false;

        if ( saisie.length() < 2 )
        {
            error = true;
            System.out.println( "Le nom de la marque est trop court." );
        }

        return error;
    }
    private boolean errorDispo( char saisie )
    {
        boolean error = false;

        if ( saisie != 'o' && saisie != 'n' )
        {
            error = true;
            System.out.println( "La valeur saisie dans dispo doit sois être 'O'ui ou 'N'on." );
        }

        return error;
    }

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

        System.out.println( "Qu'elle est le nom de la marque ?" );
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
            error = this.errorDispo(saisieDispo);
            if ( !error )
            {
                error = this.errorProprio(saisieProprio);
            }

            if ( !error )
            {
                error = this.errorMarque(saisieMarque);
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

    public String remove()
    {
        String saisieId;

        saisieId = this.saisieId();

        return saisieId;
    }

    public Iterator update()
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
            saisie.add(saisieId);

            System.out.println( "Quelle est le nom du champs à modifier ?" );
            System.out.print( "[1] Propriétaire - " );
            System.out.print( "[2] Numéro de la porte - " );
            System.out.print( "[3] Marque - " );
            System.out.print( "[4] Technologie - " );
            System.out.println( "[5] La disponibilité" );

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

                // disponibilité
                case 5 :
                    saisie.add("dispo");
                    break;

                default :
                    System.out.println( "Erreur de saisie" );
            }
        } while ( error );

        updateClef = saisie.iterator();

        return updateClef;
    }

    public String listOneKey()
    {
        String saisieId;

        saisieId = this.saisieId();

        return saisieId;
    }
}

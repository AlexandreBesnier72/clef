package clef;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class View_clef
{
    private Scanner sc = new Scanner( System.in );

    public int mainMenu()
    {
        // saisie
        int saisie;

        // saisie d'attribut de clef
        String saisieId;
        String saisieProprio;
        String saisiePorte;
        String saisieMarque;
        char saisieTechno;
        String saisieMatiere;
        boolean saisieDispo = false;

        char saisieChar;
        String saisieValue;

        // variable d'erreur
        boolean error = false;

        System.out.println( "Que voulez-vous faire ?" );
        System.out.println( "[1] ajouter une clé." );
        System.out.println( "[2] supprimer une clé." );
        System.out.println( "[3] mettre à jour une clé." );
        System.out.println( "[4] faire une recherche." );
        System.out.println( "[5] afficher la liste des clefs." );
        System.out.println( "[6] afficher une clefs précise." );
        System.out.println( "[7] sortir du programme." );

        saisie = sc.nextInt();
        sc.nextLine(); // debug

        return saisie;
    }

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
            System.out.println( "Qu'elle est le nom du propriétaire ? ( min 4 caractères )" );
            saisieProprio = sc.nextLine();

            System.out.println( "Qu'elle est le nom de la porte ?" );
            saisiePorte = sc.nextLine();

            System.out.println( "Qu'elle est le nom de la marque ? ( min 2 caractères )" );
            saisieMarque = sc.nextLine();

            System.out.println( "Qu'elle technologie utilise la clef ? [A/E]");
            saisieTechno = sc.next().toLowerCase().charAt(0);
            sc.nextLine(); // debug

            System.out.println( "De quelle matière est faite la clef ?" );
            saisieMatiere = sc.nextLine();

            System.out.println( "La clé est-elle dispo ? [O/N]" );
            saisieDispo = sc.next().toLowerCase().charAt(0);
            sc.nextLine(); // debug

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

        System.out.println("Qu'elle est l'id de la clé à supprimer ?");
        saisieId = sc.next();

        return saisieId;
    }
}

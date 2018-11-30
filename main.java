package clef;

import java.util.Iterator;
import java.util.Scanner;

public class main
{
    public static void main( String[] args )
    {
        // view clef
        View_clef vc = new View_clef();

        // controller gestion_clefs
        Gestion_clefs gc = new Gestion_clefs( 3 );

        //objet scanner
        Scanner sc = new Scanner( System.in );

        // saisie
        int saisieMenu;
        Iterator newClef;

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

        // variable de sortie
        boolean exit = false;

        do
        {
            saisieMenu = vc.mainMenu();

            switch ( saisieMenu )
            {
                // Ajouter un clé
                case 1 :
                    newClef = vc.add();
                    gc.add( newClef );
                    break;

                // Supprimer une clé
                case 2 :
                    // si il existe au moins une clé
                    if ( !gc.getFirstClefs().equals( "" ) )
                    {
                        saisieId = vc.remove();
                        gc.remove(saisieId);
                    }
                    else
                    {
                        System.out.println( "Aucune clé existe." );
                    }
                    break;

                // modifier une clé
                case 3 :
//                    // si il existe au moins une clé
//                    if ( gc.getFirstClefs() != null )
//                    {
//                        do
//                        {
//                            error = false;
//
//                            System.out.println( "Qu'elle est l'id de la clé à changer ?" );
//                            saisieId = sc.next();
//
//                            if ( gc.clefExist( saisieId ) )
//                            {
//                                gc.uneClef( saisieId );
//
//                                System.out.println( "Quelle est le nom du champs à modifier ?" );
//                                System.out.print( "[1] Propriétaire - " );
//                                System.out.print( "[2] Numéro de la porte - " );
//                                System.out.print( "[3] Marque - " );
//                                System.out.print( "[4] Technologie - " );
//                                System.out.println( "[5] La disponibilité" );
//                                saisie = sc.nextInt();
//                                switch ( saisie )
//                                {
//                                    // proprio
//                                    case 1 :
//                                        do
//                                        {
//                                            System.out.println( "Qu'elle est la valeur ? ( min 4 caractères )" );
//                                            saisieValue = sc.next();
//                                        } while ( saisieValue.length() < 4 );
//
//                                        gc.update(saisieId, "propriétaire", saisieValue);
//                                        break;
//
//                                    // porte
//                                    case 2 :
//                                        System.out.println( "Qu'elle est la valeur ?" );
//                                        saisieValue = sc.next();
//
//                                        gc.update(saisieId, "porte", saisieValue);
//                                        break;
//
//                                    // marque
//                                    case 3 :
//                                        do
//                                        {
//                                            System.out.println( "Qu'elle est la valeur ? ( min 2 caractères )" );
//                                            saisieValue = sc.next();
//                                        } while( saisieValue.length() < 2 );
//
//                                        gc.update(saisieId, "marque", saisieValue);
//                                        break;
//
//                                    // techno
//                                    case 4 :
//                                        do
//                                        {
//                                            System.out.println( "Qu'elle est la valeur ? [A/E]" );
//                                            saisieChar = sc.next().toLowerCase().charAt(0);
//                                        } while ( saisieChar != 'a' && saisieChar != 'e' );
//
//                                        gc.update(saisieId, "technologie", saisieChar);
//                                        break;
//
//                                    // disponibilité
//                                    case 5 :
//                                        gc.update(saisieId, "dispo");
//                                        break;
//
//                                    default :
//                                        System.out.println( "Erreur de saisie" );
//
//                                }
//                            }
//                            else
//                            {
//                                error = true;
//                            }
//                        } while ( error );
//                    }
//                    else
//                    {
//                        System.out.println( "Aucune clé existe." );
//                    }
                    break;

                // recherche
                case 4 :
//                    System.out.println( "[1] la recherche est un caractère." );
//                    System.out.println( "[2] la recherche est une chaine de caratères." );
//                    System.out.println( "[3] Afficher toutes les clefs disponible." );
//                    System.out.println( "[4] Afficher toutes les clefs indisponible." );
//                    saisie = sc.nextInt();
//
//                    switch (saisie)
//                    {
//                        case 1 :
//                            System.out.println( "Entrez la valeur :" );
//                            saisieValue = sc.next();
//                            saisieChar = saisieValue.charAt(0);
//                            gc.search( saisieChar );
//                            break;
//
//                        case 2 :
//                            System.out.println( "Entrez la valeur :" );
//                            saisieValue = sc.next();
//                            gc.search( saisieValue );
//                            break;
//
//                        case 3 :
//                            gc.clefsDispoIndispo( true );
//                            break;
//
//                        case 4 :
//                            gc.clefsDispoIndispo( false );
//                            break;
//
//                        default:
//                            System.out.println( "La saisie est invalide." );
//                    }
                    break;

                // liste complète
                case 5 :
                    // si il existe au moins une clé
                    if ( gc.getFirstClefs() != null )
                    {
                        gc.liste();
                    }
                    else
                    {
                        System.out.println( "Aucune clé existe." );
                    }
                    break;

                // afficher une clé
                case 6 :
                    // si il existe au moins une clé
                    if ( gc.getFirstClefs() != null )
                    {
                        do
                        {
                            if ( error )
                            {
                                System.out.println( "Le numéro de clef saisie est incorrecte." );
                            }
                            System.out.println( "Qu'elle est l'ID de la clef ?" );
                            saisieId = sc.next();

                            error = true;
                        } while ( !gc.clefExist( saisieId ) );
                        error = false;
                        gc.uneClef(saisieId);
                    }
                    else
                    {
                        System.out.println( "Aucune clé existe." );
                    }
                    break;

                // sortie
                case 7 :
                    exit = true;
                    break;

                // erreur
                default:
                    System.out.println( "La saisie est invalide." );
            }
        } while ( !exit );
    }
}

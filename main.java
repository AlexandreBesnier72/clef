package clef;

import java.util.Scanner;

public class main
{
    public static void main( String[] args )
    {
        // objet gestion_clefs
        Gestion_clefs gc = new Gestion_clefs( 3 );

        //objet scanner
        Scanner sc = new Scanner( System.in );

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

        // variable de sortie
        boolean exit = false;

        do
        {
            System.out.println( "Que voulez-vous faire ?" );
            System.out.println( "[1] ajouter une clé." );
            System.out.println( "[2] supprimer une clé." );
            System.out.println( "[3] mettre à jour une clé." );
            System.out.println( "[4] faire une recherche." );
            System.out.println( "[5] afficher la liste des clefs." );
            System.out.println( "[6] afficher une clefs précise." );
            System.out.println( "[7] sortir du programme." );

            saisie = sc.nextInt();

            switch ( saisie )
            {
                // Ajouter un clé
                case 1 :
                    do
                    {
                        System.out.println( "Qu'elle est le nom du propriétaire ? ( min 4 caractères )" );
                        saisieProprio = sc.next();

                        System.out.println( "Qu'elle est le nom de la porte ?" );
                        saisiePorte = sc.next();

                        System.out.println( "Qu'elle est le nom de la marque ? ( min 2 caractères )" );
                        saisieMarque = sc.next();

                        System.out.println( "Qu'elle technologie utilise la clef ? [A/E]");
                        saisieTechno = sc.next().toLowerCase().charAt(0);

                        System.out.println( "De quelle matière est faite la clef ?" );
                        saisieMatiere = sc.next();

                        System.out.println( "La clé est-elle dispo ? [O/N]" );
                        saisieChar = sc.next().toLowerCase().charAt(0);
                        if ( saisieChar == 'o')
                        {
                            saisieDispo = true;
                        }
                        else if ( saisieChar == 'n' )
                        {
                            saisieDispo = false;
                        }

                        // vérif
                        if ( saisieChar != 'o' && saisieChar != 'n' )
                        {
                            error = true;
                            System.out.println( "La valeur saisie dans dispo doit sois être 'O'ui ou 'N'on." );
                        }
                        else if ( saisieProprio.length() < 4 )
                        {
                            error = true;
                            System.out.println( "Le nom du propiétarie est trop court." );
                        }
                        else if ( saisieMarque.length() < 2 )
                        {
                            error = true;
                            System.out.println( "Le nom de la marque est trop court." );
                        }
                        else
                        {
                            error = false;
                        }
                    } while(error);

                    error = false;
                    gc.add(saisieProprio, saisiePorte, saisieMarque, saisieTechno, saisieMatiere, saisieDispo);
                    break;

                // Supprimer une clé
                case 2 :
                    // si il existe au moins une clé
                    if ( !gc.getFirstClefs().equals( "" ) )
                    {
                        do
                        {
                            System.out.println("Qu'elle est l'id de la clé à supprimer ?");
                            saisieId = sc.next();

                            if (gc.clefExist(saisieId))
                            {
                                error = false;
                                gc.remove(saisieId);
                            } else
                            {
                                error = true;
                            }
                        } while (error);
                    }
                    else
                    {
                        System.out.println( "Aucune clé existe." );
                    }
                    break;

                // modifier une clé
                case 3 :
                    // si il existe au moins une clé
                    if ( gc.getFirstClefs() != null )
                    {
                        do
                        {
                            error = false;

                            System.out.println( "Qu'elle est l'id de la clé à changer ?" );
                            saisieId = sc.next();

                            if ( gc.clefExist( saisieId ) )
                            {
                                gc.uneClef( saisieId );

                                System.out.println( "Quelle est le nom du champs à modifier ?" );
                                System.out.print( "[1] Propriétaire - " );
                                System.out.print( "[2] Numéro de la porte - " );
                                System.out.print( "[3] Marque - " );
                                System.out.print( "[4] Technologie - " );
                                System.out.println( "[5] La disponibilité" );
                                saisie = sc.nextInt();
                                switch ( saisie )
                                {
                                    // proprio
                                    case 1 :
                                        do
                                        {
                                            System.out.println( "Qu'elle est la valeur ? ( min 4 caractères )" );
                                            saisieValue = sc.next();
                                        } while ( saisieValue.length() < 4 );

                                        gc.update(saisieId, "propriétaire", saisieValue);
                                        break;

                                    // porte
                                    case 2 :
                                        System.out.println( "Qu'elle est la valeur ?" );
                                        saisieValue = sc.next();

                                        gc.update(saisieId, "porte", saisieValue);
                                        break;

                                    // marque
                                    case 3 :
                                        do
                                        {
                                            System.out.println( "Qu'elle est la valeur ? ( min 2 caractères )" );
                                            saisieValue = sc.next();
                                        } while( saisieValue.length() < 2 );

                                        gc.update(saisieId, "marque", saisieValue);
                                        break;

                                    // techno
                                    case 4 :
                                        do
                                        {
                                            System.out.println( "Qu'elle est la valeur ? [A/E]" );
                                            saisieChar = sc.next().toLowerCase().charAt(0);
                                        } while ( saisieChar != 'a' && saisieChar != 'e' );

                                        gc.update(saisieId, "technologie", saisieChar);
                                        break;

                                    // disponibilité
                                    case 5 :
                                        gc.update(saisieId, "dispo");
                                        break;

                                    default :
                                        System.out.println( "Erreur de saisie" );

                                }
                            }
                            else
                            {
                                error = true;
                            }
                        } while ( error );
                    }
                    else
                    {
                        System.out.println( "Aucune clé existe." );
                    }
                    break;

                // recherche
                case 4 :
                    System.out.println( "[1] la recherche est un caractère." );
                    System.out.println( "[2] la recherche est une chaine de caratères." );
                    System.out.println( "[3] Afficher toutes les clefs disponible." );
                    System.out.println( "[4] Afficher toutes les clefs indisponible." );
                    saisie = sc.nextInt();

                    switch (saisie)
                    {
                        case 1 :
                            System.out.println( "Entrez la valeur :" );
                            saisieValue = sc.next();
                            saisieChar = saisieValue.charAt(0);
                            gc.search( saisieChar );
                            break;

                        case 2 :
                            System.out.println( "Entrez la valeur :" );
                            saisieValue = sc.next();
                            gc.search( saisieValue );
                            break;

                        case 3 :
                            gc.clefsDispoIndispo( true );
                            break;

                        case 4 :
                            gc.clefsDispoIndispo( false );
                            break;

                        default:
                            System.out.println( "La saisie est invalide." );
                    }
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

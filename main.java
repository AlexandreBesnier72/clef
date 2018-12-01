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
        Iterator newClef;
        Iterator updateClef;
        Iterator searchClef;
        int saisieMenu;
        String id;
        String paramName;
        String value;

        // saisie d'attribut de clef
        String saisieProprio;
        String saisiePorte;
        String saisieMarque;
        char saisieTechno;
        String saisieMatiere;
        boolean saisieDispo = false;


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
                        id = vc.remove();
                        gc.remove(id);
                    }
                    else
                    {
                        System.out.println( "Aucune clé existe." );
                    }
                    break;

                // modifier une clé
                case 3 :
                    // si il existe au moins une clé
                    if ( !gc.getFirstClefs().equals( "" ) )
                    {
                        // TODO: 30/11/2018 Trouver un moyen d'afficher la clé qu'on met à jour
                        // gc.uneClef( saisieId );

                        updateClef = vc.update();
                        gc.update( updateClef );
                    }
                    else
                    {
                        System.out.println( "Aucune clé existe." );
                    }
                    break;

                // recherche
                case 4 :
                    searchClef = vc.search();
                    gc.search( searchClef );
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
                        id = vc.listOneKey();
                        gc.uneClef(id);
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

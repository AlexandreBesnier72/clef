package clef.Controller;

import clef.Dao.Dao_clef;
import clef.View.View_console;

import java.util.Iterator;

public class Main_controller
{
    public static void main( String[] args )
    {
        // view console
        View_console viewConsole = new View_console();

        // Dao clef
        Dao_clef daoClef = new Dao_clef();

        final char AJOUT_CLEF = '1';
        final char SUPPR_CLEF = '2';
        final char MODIF_CLEF = '3';
        final char RECHERCHE_CLEF = '4';
        final char LISTE_CLEF = '5';
        final char UNE_CLEF = '6';
        final char SORTIE = 'Q';

        // saisie
        char saisieMenu;
        String id;
        Iterator newClef;
        Iterator updateClef;
        Iterator searchClef;

        // variable de sortie
        boolean exit = false;

        do
        {
            saisieMenu = viewConsole.mainMenu();

            switch ( saisieMenu )
            {
                // Ajouter un clé
                case AJOUT_CLEF :
                    newClef = viewConsole.add();
                    daoClef.add( newClef );
                    break;

                // Supprimer une clé
                case SUPPR_CLEF :
                    // si il existe au moins une clé
                    if ( daoClef.getFirstClefs() != null )
                    {
                        id = viewConsole.remove();
                        daoClef.remove(id);
                    }
                    else
                    {
                        System.out.println( "Aucune clé existe." );
                    }
                    break;

                // modifier une clé
                case MODIF_CLEF :
                    // si il existe au moins une clé
                    if ( daoClef.getFirstClefs() != null )
                    {
                        updateClef = viewConsole.update( daoClef );

                        // ne lance pas l'update si la saisie échoue
                        if ( updateClef.hasNext() )
                        {
                            daoClef.update( updateClef );
                        }
                    }
                    else
                    {
                        System.out.println( "Aucune clé existe." );
                    }
                    break;

                // recherche
                case RECHERCHE_CLEF :
                    searchClef = viewConsole.search();
                    daoClef.search( searchClef );
                    break;

                // liste complète
                case LISTE_CLEF :
                    // si il existe au moins une clé
                    if ( daoClef.getFirstClefs() != null )
                    {
                        daoClef.liste();
                    }
                    else
                    {
                        System.out.println( "Aucune clé existe." );
                    }
                    break;

                // afficher une clé
                case UNE_CLEF :
                    // si il existe au moins une clé
                    if ( daoClef.getFirstClefs() != null )
                    {
                        id = viewConsole.listOneKey();
                        daoClef.uneClef(id);
                    }
                    else
                    {
                        System.out.println( "Aucune clé existe." );
                    }
                    break;

                // sortie
                case SORTIE :
                    exit = true;
                    break;

                // erreur
                default:
                    System.out.println( "La saisie est invalide." );
            }
        } while ( !exit );
    }
}

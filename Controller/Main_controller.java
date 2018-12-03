package clef.Controller;

import clef.Dao.Dao_clef;
import clef.View.View_console;

import java.util.Iterator;

public class Main_controller
{
    public static void main( String[] args )
    {
        // view clef
        View_console viewConsole = new View_console();

        // controller gestion_clefs
        Dao_clef daoClef = new Dao_clef();

        // saisie
        Iterator newClef;
        Iterator updateClef;
        Iterator searchClef;
        int saisieMenu;
        String id;

        // variable de sortie
        boolean exit = false;

        do
        {
            saisieMenu = viewConsole.mainMenu();

            switch ( saisieMenu )
            {
                // Ajouter un clé
                case 1 :
                    newClef = viewConsole.add();
                    daoClef.add( newClef );
                    break;

                // Supprimer une clé
                case 2 :
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
                case 3 :
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
                case 4 :
                    searchClef = viewConsole.search();
                    daoClef.search( searchClef );
                    break;

                // liste complète
                case 5 :
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
                case 6 :
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

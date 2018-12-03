package clef.View;

public class View_error
{
    /**
     * Vérifie la longueur du nom du pripriétaire
     * @param saisie nom du propriétaire
     * @return true si il y a une erreur
     */
    public boolean errorProprio( String saisie )
    {
        boolean error = false;

        if ( saisie.length() < 4 )
        {
            error = true;
            System.out.println( "Le nom du propiétaire est trop court." );
        }

        return error;
    }

    /**
     * Vérifie la longueur du nom de la marque
     * @param saisie nom de la marque
     * @return true si il y a une erreur
     */
    public boolean errorMarque( String saisie )
    {
        boolean error = false;

        if ( saisie.length() < 2 )
        {
            error = true;
            System.out.println( "Le nom de la marque est trop court." );
        }

        return error;
    }

    /**
     * Vérifie si l'utilisateur à bien rentré 'O' ou 'N'
     * @param saisie 'O'ui ou 'N'on
     * @return true si il y a une erreur
     */
    public boolean errorDispo( char saisie )
    {
        boolean error = false;

        if ( saisie != 'o' && saisie != 'n' )
        {
            error = true;
            System.out.println( "La valeur saisie dans dispo doit sois être 'O'ui ou 'N'on." );
        }

        return error;
    }
}

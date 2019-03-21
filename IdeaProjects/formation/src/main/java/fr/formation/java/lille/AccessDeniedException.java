package fr.formation.java.lille;

/**
 * @author François le Français
 */
public class AccessDeniedException extends Exception{


    @Override
    public String getMessage() {
        return "Login, password, age ou pays incorrect, veuillez reessayer!";
    }


}

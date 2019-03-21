package fr.formation.java.lille;

/**
 * @author Nicolas Giethlen
 */
public class OurExeption extends Exception{

    public OurExeption(){

    }

    @Override
    public String getMessage() {

        return "acces refusé vous n'êtes pas francais";
    }
}
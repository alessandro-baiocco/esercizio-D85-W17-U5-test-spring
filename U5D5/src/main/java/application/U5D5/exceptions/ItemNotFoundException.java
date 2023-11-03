package application.U5D5.exceptions;

public class ItemNotFoundException extends RuntimeException{

    public ItemNotFoundException(int id){
        super("Il record con l'id " + id + " non è stato trovato!");
    }


    public ItemNotFoundException(){
        super("Il record non è stato trovato!");
    }

}

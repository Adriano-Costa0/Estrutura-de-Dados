import java.util.ArrayList;
import java.util.List;

public class LavaJato {
    ArrayList<Object> fila = new ArrayList<>();
    

    void inserir(Object obj) {
        this.fila.add(obj);
    }
    Object remover(){
        return (this.fila.remove(0));
    }

    boolean filaVazia(){
        return this.fila.isEmpty();
    }
    
    
    
}

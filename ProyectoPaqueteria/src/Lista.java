import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Lista {

 //   private Set<Paquete> listadoPaquetes;
   private List<Paquete> listadoPaquetes;

    public Lista(){
        listadoPaquetes=new ArrayList<Paquete>();
        listadoPaquetes.add(new Paquete(10,2.5f,"QUITO","Prensa","Pepe","En ruta"));
        listadoPaquetes.add(new Paquete(2,2.5f,"Guayaquil","Prensa","Ana","En ruta"));
        listadoPaquetes.add(new Paquete(30,2.5f,"QUITO","Amazonas","Pepe","Entregado"));
        listadoPaquetes.add(new Paquete(13,2.5f,"QUITO","Amazonas","Pepe","Entregado"));
    }

    public List<Paquete> getListadoPaquetes() {
        return listadoPaquetes;
    }

    public void agregar(Paquete nuevoPaquete){
        listadoPaquetes.add(nuevoPaquete);
    }

    //buscar por Ciudad y nombre
    public ArrayList<Paquete> buscarCiudadNombre(String ciudad, String nombre){
        ArrayList resultado=new ArrayList();
        for (Paquete px:listadoPaquetes){
            if(px.getCiudad().compareToIgnoreCase(ciudad)==0
            && px.getNombreReceptor().compareToIgnoreCase(nombre)==0){
                resultado.add(px);
            }
        }
        return resultado;

    }

    //buscar un Paquete por tracking, aplicar el número binario
    public Paquete buscarBinario(Integer numeroTrack){
       int inferior, superior, centro;

        inferior=0;
        superior=listadoPaquetes.size()-1;

        while(inferior<=superior){
            centro=(inferior+superior)/2;
            Paquete paquete=(Paquete)listadoPaquetes.toArray()[centro];
            if(numeroTrack==paquete.getNumeroTrack())
                return paquete;
            if(numeroTrack<paquete.getNumeroTrack()){
                superior=centro-1;
            }else{
                inferior=centro+1;
            }
        }
        return null;

    }


    //método de sumar recursivo
    //Total de pesos de una ciudad
    public float pesoRecursivo(String ciudad, int indice){
        if(indice==listadoPaquetes.size())
            return 0;
        Paquete paquete=(Paquete)listadoPaquetes.toArray()[indice];
        if(paquete.getCiudad().compareToIgnoreCase(ciudad)==0)
            return paquete.getPeso()+pesoRecursivo(ciudad,indice+1);
        else
            return pesoRecursivo(ciudad,indice+1);

    }

    public float totalPeso(String ciudad){
        return pesoRecursivo(ciudad, 0);
    }


    public void ordenarBurbuja(){

        Paquete aux=new Paquete();
        for(int i=0;i<listadoPaquetes.size()-1;i++){

            for(int j=i+1; j<listadoPaquetes.size();j++){
                if(listadoPaquetes.get(i).getNumeroTrack()
                    <listadoPaquetes.get(j).getNumeroTrack()){
                    aux=listadoPaquetes.get(i);
                    listadoPaquetes.set(i, listadoPaquetes.get(j));
                    listadoPaquetes.set(j,aux);
                }

            }

        }


    }



}

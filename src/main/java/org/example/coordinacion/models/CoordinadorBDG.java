package org.example.coordinacion.models;

import java.util.ArrayList;

public class CoordinadorBDG {
    private ArrayList<Elemento> elementos;
    private ArrayList <BDG> bdg;

    public CoordinadorBDG() {
        this.elementos = new ArrayList<>();
        this.bdg = new ArrayList<>();
    }

    public void agregarElemento(Elemento elemento) {
        elementos.add(elemento);
    }

    public boolean eliminarElemento(String nombre) {
        for (int i = 0; i < elementos.size(); i++) {
            if (elementos.get(i).getNombre().equals(nombre)) {
                elementos.remove(i);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Elemento> listarElementosPorTipo(String tipo) {
        ArrayList<Elemento> elementosFiltrados = new ArrayList<>();
        for (Elemento elemento : elementos) {
            if (elemento.getClass().getSimpleName().equalsIgnoreCase(tipo)) {
                elementosFiltrados.add(elemento);
            }
        }
        return elementosFiltrados;
    }

//    public void mostrarElementosPorCategoria() {
//        System.out.println("Cajeros:");
//        for (Elemento elemento : listarElementosPorTipo("Cajero")) {
//            System.out.println(elemento.getGrado()+elemento.getNombre());
//        }
//        System.out.println("Cornetas:");
//        for (Elemento elemento : listarElementosPorTipo("Corneta")) {
//            System.out.println(elemento.getGrado()+elemento.getNombre());
//        }
//    }
    public String mostrarElementosPorCategoria() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cajeros:\n");
        for (Elemento elemento : listarElementosPorTipo("Cajero")) {
            sb.append(elemento.getGrado()).append(" ").append(elemento.getNombre()).append("\n");
        }
        sb.append("Cornetas:\n");
        for (Elemento elemento : listarElementosPorTipo("Corneta")) {
            sb.append(elemento.getGrado()).append(" ").append(elemento.getNombre()).append("\n");
        }
        return sb.toString();
}


//    public void agregarBDG(String nombreBanda, String nombreSubzona, String categoria, String nombreComandante, String gradoComandante){
//        BDG nuevaBanda = new BDG(nombreBanda, nombreSubzona, categoria, nombreComandante, gradoComandante);
//        bdg.add(nuevaBanda);
//    }

    public ArrayList<BDG> obtenerBandasDeGuerra() {
        return bdg;
    }

    public String mostrarBandasDeGuerra() {
        StringBuilder resultado = new StringBuilder();
        for (BDG banda : obtenerBandasDeGuerra()) {
            resultado.append("Nombre de la Banda: ").append(banda.getNombreBanda())
                    .append(", Subzona: ").append(banda.getNombreSubzona())
                    .append(", Categoría: ").append(banda.getCategoria())
                    .append(", Comandante: ").append(banda.getNombreComandante())
                    .append(", Grado del Comandante: ").append(banda.getGradoComandante())
                    .append("\n");
        }
        return resultado.toString();
    }

    public void agregarBDG(BDG nuevaBanda) {
        bdg.add(nuevaBanda);
    }

    public boolean eliminarBDG(String nombreBanda) {
        for (int i = 0; i < bdg.size(); i++) {
            if (bdg.get(i).getNombreBanda().equals(nombreBanda)) {
                bdg.remove(i);
                return true;
            }
        }
        return false;
    }
}


package interrupção;

import java.util.ArrayList;

public class Process {
    private int id; //id do processo;
    private int lenght_process; //Duração do processo;
    private int index; //Indíce de tempo de quanto já foi executado;
    private boolean interrupted; //Flag para saber se será interrompido ou não;
    private String status; //Status atual do processo;
    private int arrive; //Tempo de chegada;
    private static ArrayList<Integer> priority = new ArrayList(); //Lista que guarda tempo de interrupção dos processos;
  
    Process(int id, int length, boolean interrupted, int arrive, int priority)
    {
        this.priority.add(priority);
        this.id = id;
        this.lenght_process = length;
        this.index = 0;                
        this.status = "Não inciado"; 
        this.interrupted = interrupted;
        this.arrive = arrive;
    }
    
    public void incrementIndex()
    {
        this.index++;
    }
    
    public int getArrive(){
        return arrive;
    }
    
    public boolean finish(){
        if(getLenght() == getIndex()){
            return true;
        }else
            return false;
    }
    
    public void setStatus(String s){
        this.status = s;
    }
    
    @Override
    public String toString(){
        return getId() + "\t" + getIndex() + "\t" + getLenght() + "\t" + arrive + "\t" + getStatus() + "\t" + getPriority(this.getId()); 
    }

    public String getStatus() {
        return status;
    }

    public int getLenght() {
        return lenght_process;
    }

    public boolean isInterrupted() {
        return interrupted;
    }

    public int getIndex() {
        return index;
    }

    public static int getPriority(int id) {
        return priority.get(id);
    }
    
    public void setPriority(int index, int valor)
    {
        priority.set(index, valor);
    }
    
    public void decrementPriority(int index)
    {
        priority.set(index, (priority.get(index)-1));
    }

    public int getId() {
        return id;
    }
    
    public void setInterrupted(boolean interrupted) {
        this.interrupted = interrupted;
    }
    
}

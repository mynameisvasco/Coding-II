import java.util.Scanner;

public class Agenda
{
    private Tarefa[] tarefas = new Tarefa[1000];
    private int savePos = 0;

    public void novaTarefa(Tarefa tarefa)
    {
        tarefas[savePos] = tarefa;
        savePos++;

        for(int i = 0; i < savePos; i++)
        {
            for(int o = i + 1; o < savePos; o++)
            {
                if(tarefas[o].inicio().compareTo(tarefas[i].inicio()) == -1)
                {
                    Tarefa tmp = tarefas[i];
                    tarefas[i] = tarefas[o];
                    tarefas[o] = tmp;
                }
            }
        }
    }
    
    public void escreve()
    {
        for(int i = 0; i < savePos; i++)
        {
            System.out.println("-------------------");
            System.out.println("Início -> " + tarefas[i].inicio().extenso());
            System.out.println("Fim -> " + tarefas[i].fim().extenso());
            System.out.println("Tarefa -> " + tarefas[i].texto());
            System.out.println("-------------------");
        }
    }

    public Agenda filtra(Data d1, Data d2)
    {
        Agenda novaAgenda = new Agenda();
        Tarefa filtro = new Tarefa(d1,d2, "Filtro");

        for(int i = 0; i < savePos; i++)
        {
            if(tarefas[i].intersecta(filtro))
            {
                novaAgenda.tarefas[novaAgenda.savePos] = new Tarefa(tarefas[i].inicio(), tarefas[i].fim(), tarefas[i].texto());
                novaAgenda.savePos++;
            }
        }

        return novaAgenda;
    }
}
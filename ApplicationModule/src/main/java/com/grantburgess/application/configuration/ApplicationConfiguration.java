package com.grantburgess.application.configuration;

/*import com.grantburgess.database.jpa.JpaDatabase;
import com.grantburgess.database.jpa.repositories.TaskRepository;*/
import com.grantburgess.ports.database.Database;
import com.grantburgess.ports.presenters.Fonctionnalite.FonctionnaliteCreatedOutputBoundary;
import com.grantburgess.ports.presenters.Fonctionnalite.FonctionnaliteOutputBoundary;
import com.grantburgess.ports.presenters.Fonctionnalite.FonctionnalitesOutputBoundary;
import com.grantburgess.ports.presenters.Lot.LotCreatedOutputBoundary;
import com.grantburgess.ports.presenters.Lot.LotOutputBoundary;
import com.grantburgess.ports.presenters.Lot.LotsOutputBoundary;
import com.grantburgess.ports.presenters.Projet.ProjetCreatedOutputBoundary;
import com.grantburgess.ports.presenters.Projet.ProjetOutputBoundary;
import com.grantburgess.ports.presenters.Projet.ProjetsOutputBoundary;
import com.grantburgess.ports.presenters.Task.TaskCreatedOutputBoundary;
import com.grantburgess.ports.presenters.Task.TaskOutputBoundary;
import com.grantburgess.ports.presenters.Task.TaskUpdateOutputBoundary;
import com.grantburgess.ports.presenters.Task.TasksOutputBoundary;
import com.grantburgess.ports.usescases.Clock;
import com.grantburgess.ports.usescases.Fonctionnalite.addFonctionnalite.AddFonctionnaliteInputBoundary;
import com.grantburgess.ports.usescases.Fonctionnalite.cancelFonctionnalite.CancelFonctionnaliteInputBoundary;
import com.grantburgess.ports.usescases.Fonctionnalite.get.Fonctionnalitebyid.GetFonctionnaliteByIdInputBoundary;
import com.grantburgess.ports.usescases.Fonctionnalite.get.Fonctionnalites.GetFonctionnaliteInputBoundary;
import com.grantburgess.ports.usescases.Fonctionnalite.updateFonctionnalite.UpdateFonctionnaliteInputBoundary;
import com.grantburgess.ports.usescases.Lot.addLot.AddLotInputBoundary;
import com.grantburgess.ports.usescases.Lot.cancelLot.CancelLotInputBoundary;
import com.grantburgess.ports.usescases.Lot.get.Lotbyid.GetLotByIdInputBoundary;
import com.grantburgess.ports.usescases.Lot.get.Lots.GetLotInputBoundary;
import com.grantburgess.ports.usescases.Lot.updateLot.UpdateLotInputBoundary;
import com.grantburgess.ports.usescases.Projet.addProjet.AddProjetInputBoundary;
import com.grantburgess.ports.usescases.Projet.cancelProjet.CancelProjetInputBoundary;
import com.grantburgess.ports.usescases.Projet.get.Projetbyid.GetProjectByIdInputBoundary;
import com.grantburgess.ports.usescases.Projet.get.Projets.GetProjetInputBoundary;
import com.grantburgess.ports.usescases.Projet.updateProjet.UpdateProjetInputBoundary;
import com.grantburgess.ports.usescases.Task.addTask.AddTaskInputBoundary;
import com.grantburgess.ports.usescases.Task.cancelTask.CancelTaskInputBoundary;
import com.grantburgess.ports.usescases.Task.delete.DeleteTaskInputBoundary;
import com.grantburgess.ports.usescases.Task.get.Taskbyid.GetTaskByIdInputBoundary;
import com.grantburgess.ports.usescases.Task.get.Tasks.GetTaskInputBoundary;
import com.grantburgess.ports.usescases.Task.updateTask.UpdateTaskInputBoundary;
import com.grantburgess.presenters.Fonctionnalite.FonctionnaliteCreatedPresenter;
import com.grantburgess.presenters.Fonctionnalite.FonctionnalitePresenter;
import com.grantburgess.presenters.Fonctionnalite.FonctionnalitesPresenter;
import com.grantburgess.presenters.Lot.LotCreatedPresenter;
import com.grantburgess.presenters.Lot.LotPresenter;
import com.grantburgess.presenters.Lot.LotsPresenter;
import com.grantburgess.presenters.Projet.ProjetCreatedPresenter;
import com.grantburgess.presenters.Projet.ProjetPresenter;
import com.grantburgess.presenters.Projet.ProjetsPresenter;
import com.grantburgess.presenters.Task.TaskCreatedPresenter;
import com.grantburgess.presenters.Task.TaskPresenter;
import com.grantburgess.presenters.Task.TaskUpdatePresenter;
import com.grantburgess.presenters.Task.TasksPresenter;
import com.grantburgess.usecases.Fonctionnalite.addFonctionnalite.AddFonctionnalite;
import com.grantburgess.usecases.Fonctionnalite.get.fonctionnalitebyid.GetFonctionnaliteById;
import com.grantburgess.usecases.Fonctionnalite.get.fonctionnalites.GetFonctionnalites;
import com.grantburgess.usecases.Lot.addLot.AddLot;
import com.grantburgess.usecases.Lot.get.lotbyid.GetLotById;
import com.grantburgess.usecases.Lot.get.lots.GetLots;
import com.grantburgess.usecases.Projet.addProjet.AddProjet;
import com.grantburgess.usecases.Projet.get.projetbyid.GetProjetById;
import com.grantburgess.usecases.Projet.get.projets.GetProjets;
import com.grantburgess.usecases.Task.addTask.AddTask;
import com.grantburgess.usecases.Task.cancelTask.CancelTask;
import com.grantburgess.usecases.Task.deleteTask.DeleteTask;
import com.grantburgess.usecases.Task.get.taskbyid.GetTaskById;
import com.grantburgess.usecases.Task.get.tasks.GetTasks;

import com.grantburgess.usecases.Task.updateTask.Update;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.LocalDate;

@Configuration
@EntityScan("com.grantburgess.database.jpa.data")
@EnableJpaRepositories("com.grantburgess.database.jpa.repositories")
public class ApplicationConfiguration {
  /*  @Bean
    public Database database(TaskRepository offerRepository) {
        return new JpaDatabase(offerRepository);
    }*/

    @Bean
    public Clock clock() {
        return new Clock() {
            @Override
            public LocalDate now() {
                return LocalDate.now();
            }
        };
    }

    @Bean
    public GetTaskInputBoundary getTaskInputBoundary(TasksOutputBoundary TasksOutputBoundary, Database database, Clock clock) {
        return new GetTasks(TasksOutputBoundary, database.TaskGateway(), clock);
    }
    @Bean
    public GetFonctionnaliteInputBoundary getFonctionnaliteInputBoundary(FonctionnalitesOutputBoundary FonctionnalitesOutputBoundary, Database database, Clock clock)
    { return new GetFonctionnalites(FonctionnalitesOutputBoundary, database.FONCTIONNALITE_GATEWAY(), clock);
        }
    @Bean
    public GetLotInputBoundary getLotInputBoundary(LotsOutputBoundary LotsOutputBoundary, Database database, Clock clock)
    {return new GetLots(LotsOutputBoundary, database.LOT_GATEWAY(), clock);
    }
    @Bean
    public GetProjetInputBoundary getProjetInputBoundary(ProjetsOutputBoundary ProjetsOutputBoundary, Database database, Clock clock)
    {return new GetProjets(ProjetsOutputBoundary, database.PROJET_GATEWAY(), clock);
    }


    @Bean
    public TasksOutputBoundary tasksOutputBoundary() {
        return new TasksPresenter();
    }

    @Bean
    public FonctionnalitesOutputBoundary fonctionnalitesOutputBoundary(){return new FonctionnalitesPresenter();
    }

    @Bean
    public LotsOutputBoundary lotsOutputBoundary() {
        return new LotsPresenter();
    }
    @Bean
    public ProjetsOutputBoundary projetsOutputBoundary() {
        return new ProjetsPresenter();
    }

    @Bean
    public GetTaskByIdInputBoundary getTaskByIdInputBoundary(TaskOutputBoundary taskOutputBoundary, Database database, Clock clock) {
        return new GetTaskById(taskOutputBoundary, database.TaskGateway(), clock);
    }
    @Bean
    public GetFonctionnaliteByIdInputBoundary getFonctionnaliteByIdInputBoundary(FonctionnaliteOutputBoundary fonctionnaliteOutputBoundary, Database database, Clock clock) {
        return new GetFonctionnaliteById(fonctionnaliteOutputBoundary, database.FONCTIONNALITE_GATEWAY(), clock);
    }
    @Bean
    public GetLotByIdInputBoundary getLotByIdInputBoundary(LotOutputBoundary lotOutputBoundary, Database database, Clock clock) {
        return new GetLotById(lotOutputBoundary, database.LOT_GATEWAY(), clock);
    }
    @Bean
    public GetProjectByIdInputBoundary getProjetByIdInputBoundary(ProjetOutputBoundary projetOutputBoundary, Database database, Clock clock) {
        return (GetProjectByIdInputBoundary) new GetProjetById(projetOutputBoundary, database.PROJET_GATEWAY(), clock);
    }

    @Bean
    public TaskOutputBoundary taskOutputBoundary() {
        return new TaskPresenter();
    }

    @Bean
    public FonctionnaliteOutputBoundary fonctionnaliteOutputBoundary() {
        return new FonctionnalitePresenter();
    }
    @Bean
    public LotOutputBoundary lotOutputBoundary() {
        return new LotPresenter();
    }
    @Bean
    public ProjetOutputBoundary projetOutputBoundary() {
        return new ProjetPresenter();
    }

    @Bean
    public AddTaskInputBoundary addTaskInputBoundary(TaskCreatedOutputBoundary taskCreatedOutputBoundary, Database database, Clock clock) {
        return new AddTask(taskCreatedOutputBoundary, database.TaskGateway(), clock);
    }
    @Bean
    public AddFonctionnaliteInputBoundary addFonctionnaliteInputBoundary(FonctionnaliteCreatedOutputBoundary fonctionnaliteCreatedOutputBoundary, Database database, Clock clock) {
        return new AddFonctionnalite(fonctionnaliteCreatedOutputBoundary, database.FONCTIONNALITE_GATEWAY(), clock);
    }
    @Bean
    public AddLotInputBoundary addlotInputBoundary(LotCreatedOutputBoundary lotCreatedOutputBoundary, Database database, Clock clock) {
        return new AddLot(lotCreatedOutputBoundary, database.LOT_GATEWAY(), clock);
    }
    @Bean
    public AddProjetInputBoundary addProjetInputBoundary(ProjetCreatedOutputBoundary projetCreatedOutputBoundary, Database database, Clock clock) {
        return new AddProjet(projetCreatedOutputBoundary, database.PROJET_GATEWAY(), clock);
    }

    @Bean
    public TaskCreatedOutputBoundary taskCreatedOutputBoundary() {
        return new TaskCreatedPresenter();
    }
    @Bean
    public FonctionnaliteCreatedOutputBoundary fonctionnaliteCreatedOutputBoundary() {
        return new FonctionnaliteCreatedPresenter();
    }
    @Bean
    public LotCreatedOutputBoundary lotCreatedOutputBoundary() {
        return new LotCreatedPresenter();
    }
    @Bean
    public ProjetCreatedOutputBoundary projetCreatedOutputBoundary() {
        return new ProjetCreatedPresenter();
    }

    @Bean
    public CancelTaskInputBoundary cancelTaskInputBoundary(Database database, Clock clock) {
        return new CancelTask(database.TaskGateway(), clock);
    }
    @Bean
    public CancelFonctionnaliteInputBoundary cancelFonctionnaliteInputBoundary(Database database, Clock clock) {
        return new CancelFonctionnalite(database.FONCTIONNALITE_GATEWAY(), clock);
    }
    @Bean
    public CancelLotInputBoundary cancelLotInputBoundary(Database database, Clock clock) {
        return new CancelLot(database.LOT_GATEWAY(), clock);
    }
    @Bean
    public CancelProjetInputBoundary cancelProjetInputBoundary(Database database, Clock clock) {
        return new CancelProjet(database.PROJET_GATEWAY(), clock);
    }


    @Bean
    public UpdateTaskInputBoundary updateTaskInputBoundary(TaskOutputBoundary offerOutputBoundary,Database database,Clock clock) {
        return new Update(offerOutputBoundary,database.TaskGateway(),clock);
    }
    @Bean
    public UpdateFonctionnaliteInputBoundary updateFonctionnaliteInputBoundary(FonctionnaliteOutputBoundary offerOutputBoundary, Database database, Clock clock) {
        return  new Update(offerOutputBoundary,database.FONCTIONNALITE_GATEWAY(),clock);
    }
    @Bean
    public UpdateLotInputBoundary updateLotInputBoundary(LotOutputBoundary offerOutputBoundary, Database database, Clock clock) {
        return new Update(offerOutputBoundary,database.LOT_GATEWAY(),clock);
    }
    @Bean
    public UpdateProjetInputBoundary updateProjetInputBoundary(ProjetOutputBoundary offerOutputBoundary, Database database, Clock clock) {
        return new Update(offerOutputBoundary,database.PROJET_GATEWAY(),clock);
    }
    @Bean
    public TaskUpdateOutputBoundary taskUpdateOutputBoundary() {
        return new TaskUpdatePresenter();
    }

    @Bean
    public DeleteTaskInputBoundary deleteTaskInputBoundary(Database database) {
        return new DeleteTask(database.TaskGateway());
    }

}

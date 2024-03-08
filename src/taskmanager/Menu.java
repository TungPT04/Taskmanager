/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taskmanager;

import Manager.Manager;
import Object.Task;
import java.util.ArrayList;
import Manager.Validation;
import java.io.IOException;

/**
 *
 * @author Windows
 */
public class Menu {
    
        
    private String[] ops = {
        "Add Task",
        "Delete Task",
        "Display Task",
        "Exit"
    };
     ArrayList<Task> lt = new ArrayList<>();
      Manager m= new Manager();

    public  void display() throws IOException {
         
        int choice = 0;
        int id = 1;
     
        do {
            System.out.println("========== Task Manager ============");
            for (int i = 0; i < ops.length; i++) {
                System.out.println((i + 1) + ". " + ops[i]);
            }
            choice = Validation.checkInputIntChoose("Choose: ", 1, ops.length);
            switch (choice) {
                case 1:
                    System.out.println("--------------Add Task-----------");
                    addTask(lt,id);
                    id++;
                    break;
                case 2:
                    System.out.println("--------------Delete Task-----------");
                                        m.deleteTask(lt, id);
                    break;
                case 3:
                    System.out.println("--------------Display Task-----------");
                    m.print(lt);
                    break;
                case 4:
                    break;
            }
        } while (choice != ops.length);
    }
    private void addTask(ArrayList<Task> lt, int id) {
        System.out.print("Enter Requirement Name: ");
        String requirementName = Validation.checkInputString();
        System.out.print("Enter Task Type: ");
        String taskTypeId = Validation.checkInputTaskTypeId();
        System.out.print("Enter Date: ");
        String date = Validation.checkInputDate();
        System.out.print("Enter From: ");
        String planFrom = Validation.checkInputPlan();
        System.out.print("Enter To: ");
        String planTo = Validation.checkInputPlan();
        System.out.print("Enter Assignee: ");
        String assign = Validation.checkInputString();
        System.out.print("Enter Reviewer: ");
        String reviewer = Validation.checkInputString();
        lt.add(new Task(id, taskTypeId, requirementName, date, planFrom, planTo, assign, reviewer));
        System.out.println("Add Task Success.");
    }
    
}

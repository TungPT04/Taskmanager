

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Manager;

import static Manager.Validation.checkInputInt;
import Object.Task;
import java.util.ArrayList;

public class Manager {
    public  void deleteTask(ArrayList<Task> lt, int id) {
        if (lt.isEmpty()) {
            System.err.println("List empty");
            return;
        }
        int findId = findTaskExist(lt);
        if (findId != -1) {
            lt.remove(findId);
            for (int i = findId; i < lt.size(); i++) {
                lt.get(i).setId(lt.get(i).getId() - 1);
            }
            System.err.println("Delete success.");
        }
    }

    public int findTaskExist(ArrayList<Task> lt) {
    System.out.print("Enter id: ");
    int id = checkInputInt("Choose: ");
    for (int i = 0; i < lt.size(); i++) {
        if (lt.get(i).getId() == id) {
            return i;
        }
    }
    System.err.println("Not found.");
    return -1;
}

    public  void print(ArrayList<Task> lt) {
        if (lt.isEmpty()) {
            System.err.println("List empty.");
            return;
        }
        System.out.printf("%-5s%-15s%-15s%-15s%-15s%-15s%-15s\n",
                "ID", "Name", "Task Type", "Date", "Time", "Assign", "Reviewer");
        for (int i = 0; i < lt.size(); i++) {
            System.out.printf("%-5d%-15s%-15s%-15s%-15.1f%-15s%-15s\n",
                    lt.get(i).getId(),
                    lt.get(i).getRequirementName(),
                    lt.get(i).getTaskTypeId(),
                    lt.get(i).getDate(),
                    Double.parseDouble(lt.get(i).getPlanTo()) - Double.parseDouble(lt.get(i).getPlanFrom()),
                    lt.get(i).getassign(),
                    lt.get(i).getreviewer()
            );

        }
    }
}


import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ShamimMSAS7
 */
public class Task3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the amount of time quantum");
        int tq = sc.nextInt();
        System.out.println("Enter the number of the Process");
        int n = sc.nextInt();
        Process3[] array;
        array = new Process3[n];
        System.out.println("Enter Process name, Process arrival time, Process burst time sequentially");
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int arrival_time = sc.nextInt();
            int burst_time = sc.nextInt();
            array[i] = new Process3(name, arrival_time, burst_time);

        }

        int current_time = 0;
        int completed_Process = 0;
        int available_quantum = tq;
        ArrayList<Process3> ready_queue = new ArrayList();
        while (completed_Process < n) {
            if (ready_queue.size() + completed_Process < n) {
                for (int i = 0; i < n; i++) {
                    if (array[i].arrival_time == current_time) {
                        ready_queue.add(array[i]);
                    }
                }
            }
            if (ready_queue.size() != 0) {
                Process3 p = ready_queue.get(0);
                if (p.start_time == -1) {
                    p.start_time = current_time;
                }
                p.remaining_burst_time--;
                available_quantum--;
                if (p.remaining_burst_time == 0) {
                    p.end_time = current_time + 1;
                    p.waiting_time = p.end_time - p.arrival_time - p.burst_time;
                    p.turnaround_time = p.end_time - p.arrival_time;
                    completed_Process++;
                    available_quantum = tq;
                    ready_queue.remove(p);
                } else if (available_quantum == 0) {
                    available_quantum = tq;
                    ready_queue.remove(p);
                    ready_queue.add(p);
                }
            }

            current_time++;
        }
        int total_waiting_time = 0;
        int total_turnaround_time = 0;
        for (int i = 0; i < n; i++) {
            total_waiting_time += array[i].waiting_time;
            total_turnaround_time += array[i].turnaround_time;
            System.out.println("Process name = " + array[i].name + ", start time = " + array[i].start_time + ", end time = " + array[i].end_time+ ", waiting time = " + array[i].waiting_time+ ", turnaround time = " + array[i].turnaround_time);
        }

        System.out.println("Average waiting time = " + (1.0 * total_waiting_time / n));
        System.out.println("Average turnaround time = " + (1.0 * total_turnaround_time / n));

    }
}

class Process3 {

    String name;
    int arrival_time;
    int burst_time;
    int start_time = -1;
    int end_time = -1;
    int remaining_burst_time;
    int waiting_time = -1;
    int turnaround_time = -1;

    Process3(String name, int a, int b) {
        this.name = name;
        arrival_time = a;
        burst_time = b;
        remaining_burst_time = b;
    }

}

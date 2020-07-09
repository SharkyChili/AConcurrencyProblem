package com.wayne.task;

import com.wayne.lock.YourLock;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Lock;

/**
 * @author wayne
 * @date 2020.07.08
 */
public class TaskGroup implements Runnable{
    private List<Task> myTaskList = new ArrayList<>();
    private int groupId;
    private YourLock lock = new YourLock();
    private Integer taskIds = 0x00000000;

    public TaskGroup(int index, int size, List<Task> taskList){
        this.groupId = index;
        Random random = new Random();
        while(myTaskList.size()<size){
            Task task = taskList.get(random.nextInt(taskList.size()));
            if(!myTaskList.contains(task)){
                myTaskList.add(task);
                int taskI = task.getI();
                Integer tmp = this.taskIds;
                Integer mask = 0x00000001 << taskI;
                this.taskIds = tmp | mask;
            }
        }


    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    @Override
    public void run() {
        lock.lock(this.taskIds);
        for (Task task : myTaskList) {
            task.met(this);
        }
        lock.unlock(this.taskIds);
    }
}

package com.wayne.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author fw
 * @date 2020.07.09
 */
public class AssertUtil {
    private static Integer taskGroupCapacity;
    private static HashMap<Integer,Integer> taskIdGroupIdMap = new HashMap<>();
    private static HashMap<Integer,HashSet<Integer>> groupTaskAlreadyRun = new HashMap<>();

    public static void setTaskGroupCapacity(Integer taskGroupCapacity){
        AssertUtil.taskGroupCapacity = taskGroupCapacity;
    }

    public static void assertError(Data data){
        if(taskIdGroupIdMap.containsKey(data.getTaskId())){
            Integer groupId = taskIdGroupIdMap.get(data.getTaskId());
            HashSet<Integer> integers = groupTaskAlreadyRun.get(groupId);
            String taskIds = integers.stream().map(String::valueOf).collect(Collectors.joining(","));
            throw new RuntimeException("任务组" + data.getGroupId() +"想要放入任务" + data.getTaskId() +
                    "，此任务已由任务组" + groupId + "放入，任务组已运行的任务如下" + taskIds);
        }else {
            HashSet<Integer> integers = groupTaskAlreadyRun.get(data.getGroupId());
            integers.add(data.getTaskId());
            if(integers.size()==taskGroupCapacity){
                integers.stream().forEach(
                        taskId -> taskIdGroupIdMap.remove(taskId)
                );
            }else {
                //do nothing
            }
        }
    }
}

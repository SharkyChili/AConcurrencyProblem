package com.wayne.test;

/**
 * @author fw
 * @date 2020.07.09
 */
public class Data {
    private Integer groupId;
    private Integer taskId;

    public Data(Integer groupId, Integer taskId) {
        this.groupId = groupId;
        this.taskId = taskId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }
}

package cn.metaq.sample.camunda.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.camunda.bpm.engine.HistoryService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.history.HistoricDetail;
import org.camunda.bpm.engine.history.HistoricTaskInstance;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.task.Task;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

  @Resource
  private RuntimeService runtimeService;
  @Resource
  private TaskService taskService;
  @Resource
  private HistoryService historyService;

  /**
   * 启动流程
   *
   * @return
   */
  @GetMapping("test/start")
  public Result start(String processDefinitionKey, String businessKey) {

    //启动流程
    VariableMap variables = Variables.createVariables();
    variables.put("ticket_number", businessKey);

    //processDefinitionKey="Process_00jqypy"
    runtimeService.startProcessInstanceByKey(processDefinitionKey, businessKey, variables);
    return Result.ok();
  }

  /**
   * 完成待办任务
   *
   * @param taskId
   * @return
   */
  @GetMapping("test/complete")
  public Result complete(String taskId, String username) {

    taskService.claim(taskId, username);

    Map<String, Object> variables = new HashMap<>();
//    variables.put("ticket_comment", "初审完成");
//    variables.put("initial_approved", true);

    variables.put("final_approved",true);
    taskService.complete(taskId, variables);
    return Result.ok();
  }

  /**
   * 待办列表
   *
   * @return
   */
  @GetMapping("test/tasks")
  public Result getToDoList(String assignee) {
    List<Task> tasks = taskService.createTaskQuery().taskAssignee(assignee).list();
    //判断任务是否分配给cs
    //taskService.claim("taskid","cs");
    //taskService.complete("taskId",variables);
    //System.out.println(pi.getBusinessKey());
    //返回任务id
    return Result.ok(tasks.stream().map(t -> t.getId()).collect(Collectors.toList()));
  }

  /**
   * 已完成列表
   *
   * @return
   */
  @GetMapping("test/histories")
  public Result getHis(String assignee) {

    List<HistoricTaskInstance> histories = historyService.createHistoricTaskInstanceQuery().taskAssignee(assignee)
        .finished().list();
    List<HistoricDetail> details = historyService.createHistoricDetailQuery().formFields().list();

    details.forEach(d -> {

      System.out.println("任务id=" + d.getTaskId());
      System.out.println("任务时间=" + d.getTime());

    });
    return Result.ok(histories.stream().map(t -> t.getTaskDefinitionKey()).collect(Collectors.toList()));
  }

  /**
   * 查询业务主键
   * @param taskId
   * @return
   */
  @GetMapping("test/businessKey")
  public Result getBusinessKey(String taskId) {

    Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
    ProcessInstance pi = runtimeService.createProcessInstanceQuery().processInstanceId(task.getProcessInstanceId())
        .singleResult();

    return Result.ok(pi.getBusinessKey());
  }
}

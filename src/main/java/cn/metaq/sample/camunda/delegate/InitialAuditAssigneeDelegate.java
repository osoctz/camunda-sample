package cn.metaq.sample.camunda.delegate;

import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("initialAuditAssignee")
@Slf4j
public class InitialAuditAssigneeDelegate implements JavaDelegate {

//  @Resource
//  private UserExtDao userExtDao;

  @Override
  public void execute(DelegateExecution execution) throws Exception {

//    //初审人
//    List<UserDTO> users = userExtDao.selectUserListByRole("3");

    List<String> value = new ArrayList<>();
    value.add("cs");
    value.add("test123");

    execution.setVariable("assigneeList", value);
  }
}

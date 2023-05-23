package cn.metaq.sample.camunda.delegate;

import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("finalAuditCloseTicketAssignee")
@Slf4j
public class FinalAuditCloseTicketDelegate implements JavaDelegate {

//  @Resource
//  private UserExtDao userExtDao;

  @Override
  public void execute(DelegateExecution execution) throws Exception {

//    //初审人
//    List<UserDTO> users = userExtDao.selectUserListByRole("4");

    List<String> value = new ArrayList<>();
    value.add("zs");
    execution.setVariable("finalAuditCloseTicketAssigneeList", value);
  }
}

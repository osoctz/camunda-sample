package cn.metaq.sample.camunda.delegate;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("calculateTargetOfCloseTicket")
@Slf4j
public class CalculateTargetOfCloseTicketDelegate implements JavaDelegate {

//  @Resource
//  private UserExtDao userExtDao;

  @Override
  public void execute(DelegateExecution execution) throws Exception {
    //声量
    execution.setVariable("voice", 50);

    log.info("声量,{}",50);
  }
}

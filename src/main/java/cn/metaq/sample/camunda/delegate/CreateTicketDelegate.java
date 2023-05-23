package cn.metaq.sample.camunda.delegate;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("createTicket")
@Slf4j
public class CreateTicketDelegate implements JavaDelegate {

  @Override
  public void execute(DelegateExecution delegateExecution) throws Exception {

    //delegateExecution.setVariable("ticket_number","");
    log.info("创建工单,{}",delegateExecution.getVariable("ticket_number"));
  }
}

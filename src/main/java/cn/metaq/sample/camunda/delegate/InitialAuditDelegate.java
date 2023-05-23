package cn.metaq.sample.camunda.delegate;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("initialAudit")
@Slf4j
public class InitialAuditDelegate implements JavaDelegate {

//  @Resource
//  private TicketInfoBiz ticketInfoBiz;

  @Override
  public void execute(DelegateExecution execution) throws Exception {

//    String ticket_number = (String) execution.getVariable("ticket_number");
//
//    TicketInfoQo qo = new TicketInfoQo();
//    qo.setTicketNumber(ticket_number);
//    TicketInfo ticketInfo = ticketInfoBiz.getOne(TicketInfo.class, qo);
//
//    Boolean initial_approved = (Boolean) execution.getVariable("initial_approved");
//    if (initial_approved) {
//      ticketInfo.setStatus(TicketStatusEnum.REVIEWED.getValue());
//    } else {
//      ticketInfo.setStatus(TicketStatusEnum.INITIAL_AUDIT_CLOSED.getValue());
//    }
//
//    ticketInfoBiz.update(ticketInfo);
    log.info("初审:{}", "ticket_number");
  }
}


package cn.metaq.sample.camunda.delegate;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("finalAudit")
@Slf4j
public class FinalAuditDelegate implements JavaDelegate {

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
//    Boolean final_approved = (Boolean) execution.getVariable("final_approved");
//    if (final_approved) {
//      ticketInfo.setStatus(TicketStatusEnum.TO_BE_FOLLOWED_UP.getValue());
//    } else {
//      ticketInfo.setStatus(TicketStatusEnum.FINAL_AUDIT_CLOSED.getValue());
//    }
//
//    ticketInfoBiz.update(ticketInfo);
    log.info("终审,{}", "ticket_number");
  }
}

package cn.metaq.sample.camunda.delegate;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("pendingCloseTicket")
@Slf4j
public class PendingCloseTicketDelegate implements JavaDelegate {

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
//    ticketInfo.setStatus(TicketStatusEnum.PENDING_CLOSED.getValue());
//
//    ticketInfoBiz.update(ticketInfo);

    log.info("不满足自动结案条件，结案中");
  }
}

package cn.metaq.sample.camunda.delegate;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("followTicket")
@Slf4j
public class FollowTicketDelegate implements JavaDelegate {

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
//    ticketInfo.setStatus(TicketStatusEnum.FOLLOWED_UP.getValue());
//
//    ticketInfoBiz.update(ticketInfo);
  }
}

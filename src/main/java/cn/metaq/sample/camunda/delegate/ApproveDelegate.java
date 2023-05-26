package cn.metaq.sample.camunda.delegate;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.delegate.TaskListener;
import org.springframework.stereotype.Component;

/**
 * <p>Date: 2023/5/25 15:55.</p>
 * <p>description.</p>
 *
 * @author zantang
 */
@Component("approve")
@Slf4j
public class ApproveDelegate implements TaskListener {

    @Override
    public void notify(DelegateTask delegateTask) {

        String days = (String)  delegateTask.getVariable("days");
        log.info("请假{}天,已审批", days);
    }
}

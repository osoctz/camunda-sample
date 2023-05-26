package cn.metaq.sample.camunda.delegate;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

/**
 * <p>Date: 2023/5/25 15:55.</p>
 * <p>description.</p>
 *
 * @author zantang
 */
@Component("applyRest")
@Slf4j
public class ApplyRestDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {

        String days = (String) execution.getVariable("days");

        log.info("请假{}天", days);
    }
}

package main;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by kongxiangwen on 5/7/18 w:19.
 */



@SpringBootApplication
public class SentinelApplication {

	public static void main(String[] args) {



		List<FlowRule> rules = new ArrayList<>();
		FlowRule rule = new FlowRule();
		rule.setResource("HelloWorld");
// set limit qps to 20
		rule.setCount(3);
		rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
		rules.add(rule);
		FlowRuleManager.loadRules(rules);
		SpringApplication.run(SentinelApplication.class, args);
	}

}

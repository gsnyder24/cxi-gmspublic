package DateTimeStamp;

import com.avaya.app.entity.Instance;
import com.avaya.app.entity.NodeInstance;
import com.roobroo.bpm.model.BpmNode;
import com.avaya.workflow.logger.*;


@SuppressWarnings("serial")
public class DateTimeStampExecution extends NodeInstance {

	private static Logger logger = LoggerFactory.getLogger(DateTimeStampExecution.class);

	public DateTimeStampExecution(Instance instance, BpmNode node) {
		super(instance, node);
	}

	public Object execute() throws Exception {
		logger.info("DateTimeStampExecution started....");
		GetDateData myDateTimeData;
		myDateTimeData = new GetDateData();
		
		return myDateTimeData.BuildTimeData("");
    }
	
}

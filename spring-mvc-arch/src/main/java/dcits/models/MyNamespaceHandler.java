package dcits.models;

/**
 * Created by kongxiangwen on 7/3/18 w:27.
 */
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;
public class MyNamespaceHandler extends NamespaceHandlerSupport {
	public void init() {

		registerBeanDefinitionParser("people", new PeopleBeanDefinitionParser());
		registerBeanDefinitionParser("animal", new AnimalBeanDefinitionParser());
	}
}
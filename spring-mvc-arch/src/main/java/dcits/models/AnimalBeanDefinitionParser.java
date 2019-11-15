package dcits.models;

/**
 * Created by kongxiangwen on 7/3/18 w:27.
 */
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

public class AnimalBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {
	protected Class getBeanClass(Element element) {
		return Animal.class;
	}
	protected void doParse(Element element, BeanDefinitionBuilder bean) {
		String name = element.getAttribute("animalName");
		String age = element.getAttribute("age");
		String id = element.getAttribute("id");
		if (StringUtils.hasText(id)) {
			bean.addPropertyValue("id", id);
		}
		if (StringUtils.hasText(name)) {
			bean.addPropertyValue("animalName", name);
		}
		if (StringUtils.hasText(age)) {
			bean.addPropertyValue("age", Integer.valueOf(age));
		}
	}
}

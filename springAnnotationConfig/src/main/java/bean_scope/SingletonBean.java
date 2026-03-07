package bean_scope;

import org.springframework.stereotype.Component;

@Component
public class SingletonBean {
	public SingletonBean() {
		System.out.println("singleton Bean called");
	}

}

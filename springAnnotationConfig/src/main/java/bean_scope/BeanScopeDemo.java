package bean_scope;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class BeanScopeDemo {
	public static void main(String args[]) {
		
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext("bean_scope");	
		System.out.println("Singleton scope");
		SingletonBean s1=context.getBean(SingletonBean.class);
		SingletonBean s2=context.getBean(SingletonBean.class);
		if(s1==s2) {
			System.out.println("same object");
		}
		else {
			System.out.println("Deifferent object");
		}
		
		System.out.println("Prototype scope");
		PrototypeBean p1=context.getBean(PrototypeBean.class);
		PrototypeBean p2=context.getBean(PrototypeBean.class);
		if(p1==p2) {
			System.out.println("same object");
		}else {
			System.out.println("Deifferent object");
		}
		
		
	}
}

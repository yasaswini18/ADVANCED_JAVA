package primary_qualifier;

import org.springframework.stereotype.Component;

@Component

public class EmailNotification implements Notification{
	@Override
	public void notify(String message) {
		System.out.println("notified through email");				
	}

}

package primary_qualifier;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class SmsNotification implements Notification{
	@Override
	public void notify(String message) {
		System.out.println("notified through sms");				
	}

}

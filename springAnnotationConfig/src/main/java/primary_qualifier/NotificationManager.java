package primary_qualifier;

import org.springframework.stereotype.Component;

@Component
public class NotificationManager {
	public Notification notification;
	public NotificationManager(Notification notification) {
		this.notification=notification;
		
	}
	public void send(String message) {
		
		notification.notify(message);
	}

}
package primary_qualifier;

public class PushNotification implements Notification{
	@Override
	public void notify(String message) {
		System.out.println("notified through push");				
	}

}

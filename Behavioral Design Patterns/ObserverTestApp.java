/*
*PROBLEM
while the wheelchair is operating, some activities, alerts and notification has to be issued
in order to keep the care takers and the hospitals updated.
to do so, the app has to either constantly check whether they are ready or not or the app has
to send the updates whether they are required or not. but in both cases, a lot of resources 
are being wasted. it is better if the app is notified when these are required or ready. 
so that, app could issue the relevent alerts and notifications when they are required or ready.
the solution is a publisher subscriber model which is described by the observer design pattern.

*SOLUTION
a publisher class (EventDispatcher in this case) is created and it will keep the Subscribers
(Listners) lists for each event. this could as well be implemented with a hash map. when there
is a change of state that triggers the event the publisher will notify all teh Listners via 
"notify" method that is declared in the Listener interface which is implemented by all the 
concreate Listeners. Adding a new Listner will not cause of changing the code of the app or 
the publisher since all the listeners are connected via a common interface.
*/

import java.util.*;

enum Event{EMERGENCY, ROUTINE, LOCATION_CHANGED, BATTERY_LOW}

class EventDispatcher{     // this is the publisher
   private Map<Event,List<Listener>> listeners = new HashMap<>();

   public EventDispatcher(){
      listeners.put(Event.EMERGENCY, new ArrayList<>());
      listeners.put(Event.ROUTINE, new ArrayList<>());
      listeners.put(Event.LOCATION_CHANGED, new ArrayList<>());
      listeners.put(Event.BATTERY_LOW, new ArrayList<>());
   }

   public void subscribe(Listener listener,  Event event){
      listeners.get(event).add(listener);
   }

   public void unsubscribe(Listener listener, Event event){
      listeners.get(event).remove(listener);
   }

   public void notify(Event event, String data){
      List<Listener> event_listeners = listeners.get(event);
      for(Listener listener: event_listeners){
         listener.update(data);
      }
   }
}

class WheelChair{
   public EventDispatcher eventDispatcher;

   public WheelChair(EventDispatcher eventDispatcher){
      this.eventDispatcher = eventDispatcher;
   }
}

interface Listener{
   public void update(String data);
}

class LedController implements Listener{
   private boolean ledState;

   public void update(String data){
      // the data will not be used in this function
      ledState = true;
      System.out.println("Warning LED turned on");
   }
}

class NotificationSender implements Listener{
   String notification;

   public void update(String data){
      // invoke the functions to send the notification
      // data that has passed will be used in the process.
      System.out.println("Notification sent");
   }
}

class DataBaseWriter implements Listener{
   boolean state;

   public void update(String data){
      //call the necessary functions to write to a database
      // data that has passed will be used in the process.
      System.out.println("Writing to database");
   }
}

public class ObserverTestApp{
   public static void main(String[] args) {

      EventDispatcher eventDispatcher = new EventDispatcher();
      WheelChair wheelChair = new WheelChair(eventDispatcher);

      LedController ledController = new LedController();
      NotificationSender notificationSender = new NotificationSender();
      DataBaseWriter dataBaseWriter = new DataBaseWriter();

      eventDispatcher.subscribe(ledController, Event.EMERGENCY);
      eventDispatcher.subscribe(ledController, Event.BATTERY_LOW);
      eventDispatcher.subscribe(notificationSender, Event.EMERGENCY);
      eventDispatcher.subscribe(notificationSender, Event.BATTERY_LOW);
      eventDispatcher.subscribe(notificationSender, Event.ROUTINE);
      eventDispatcher.subscribe(dataBaseWriter, Event.EMERGENCY);
      eventDispatcher.subscribe(dataBaseWriter, Event.ROUTINE);
      eventDispatcher.subscribe(dataBaseWriter, Event.BATTERY_LOW);
      eventDispatcher.subscribe(dataBaseWriter, Event.LOCATION_CHANGED);

      eventDispatcher.notify(Event.BATTERY_LOW, "data");
   }
}
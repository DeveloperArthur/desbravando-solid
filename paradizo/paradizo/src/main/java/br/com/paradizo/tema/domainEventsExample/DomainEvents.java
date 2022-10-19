package br.com.paradizo.tema.domainEventsExample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class DomainEvents {
    public static void main(String[] args) {
        PedidoFeito pedidoFeito = new PedidoFeito();
        EventDispatcher eventDispatcher = new EventDispatcher();
        EventHandler handlerkafka = new SendMessageToKafkaEventHandler();
        EventHandler handlerrabbitmq = new SendMessageToRabbitMQEventHandler();

        eventDispatcher.register(pedidoFeito.getNameClass(), handlerkafka);
        eventDispatcher.register(pedidoFeito.getNameClass(), handlerrabbitmq);
        eventDispatcher.register(pedidoFeito.getNameClass(), handlerkafka);

        eventDispatcher.notify(pedidoFeito);
    }

    public static class Event {
        public String getNameClass(){
            return getClass().getName();
        }
    }

    //representa o evento
    public static class PedidoFeito extends Event {

    }

    public interface EventHandler {
        void send(Event event) throws InterruptedException;
    }

    public static class SendMessageToKafkaEventHandler implements EventHandler {
        public void send(Event event) throws InterruptedException {
            TimeUnit.SECONDS.sleep((int) (Math.random() * 3) + 1);
            System.out.println("evento: "+ event.getNameClass()+" via kafka");
        }
    }

    public static class SendMessageToRabbitMQEventHandler implements EventHandler {
        public void send(Event event) throws InterruptedException {
            TimeUnit.SECONDS.sleep((int) (Math.random() * 3) + 1);
            System.out.println("evento: "+ event.getNameClass()+" via rabbitmq");
        }
    }

    public static class EventDispatcher {
        private Map<String, List<EventHandler>> events = new HashMap<>();

        public void register(String event, EventHandler eventHandler){
            if (this.events.get(event) == null || this.events.get(event).size() == 0){
                this.events.put(event, new ArrayList<>());
            }
            this.events.get(event).add(eventHandler);
        }

        public void notify(Event event){
            this.events.get(event.getNameClass()).forEach(h -> {
                try {
                    h.send(event);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }
}




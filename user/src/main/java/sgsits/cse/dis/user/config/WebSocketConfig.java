package sgsits.cse.dis.user.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * The type Web socket config.
 */
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    /**
     * The constant topicName.
     */
    @Value("${dis.notification.topic}")
    public static String topicName;
    /**
     * The constant applicationPrefix.
     */
    @Value("${dis.notification.appPrefix}")
    public static String applicationPrefix;
    /**
     * The constant notificationEndpoint.
     */
    @Value("${dis.notification.notificationEndpoint}")
    public static String notificationEndpoint;

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker(topicName);
        registry.setApplicationDestinationPrefixes(applicationPrefix);
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint(notificationEndpoint);
        registry.addEndpoint(notificationEndpoint).withSockJS();
    }
}

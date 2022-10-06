package com.ita_acad.solace.configuration;


import com.solacesystems.jms.SolConnectionFactory;
import com.solacesystems.jms.SolJmsUtility;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.Session;

@Configuration
public class SolaceConfiguration {

    @Bean
    public SolConnectionFactory solConnectionFactory(){
        try{
            String connectionValue = null;

            SolConnectionFactory connectionFactory = SolJmsUtility.createConnectionFactory();
            String solaceHost = "localhost:55554";

            connectionFactory.setHost(solaceHost);

            connectionFactory.setVPN("default");
            connectionFactory.setUsername("admin");
            connectionFactory.setPassword("IJnQc4mASn");

            connectionValue = connectionFactory.toString();

            return connectionFactory;
        }catch(Exception e){
            return null;
        }
    }

    @Bean
    public JmsTemplate jmsTemplate(){
        CachingConnectionFactory ccf = new CachingConnectionFactory(solConnectionFactory());
        JmsTemplate jmsTemplate = new JmsTemplate((ccf));
        return jmsTemplate;
    }

    @Bean
    public DefaultJmsListenerContainerFactory defaultJmsListenerContainerFactory() throws Exception{
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(solConnectionFactory());
        factory.setConcurrency("1");
        factory.setSessionAcknowledgeMode(Session.AUTO_ACKNOWLEDGE);

        return factory;
    }
}

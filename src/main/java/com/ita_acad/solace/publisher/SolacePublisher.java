package com.ita_acad.solace.publisher;


import com.solacesystems.jms.message.SolTextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;

@Component
public class SolacePublisher {
    @Autowired
    public JmsTemplate jmsTemplate;


    public void publishToGivenQueueName(String queueName, String message) throws JMSException {
        SolTextMessage solTextMessage = new SolTextMessage();

        solTextMessage.setText(message);
        jmsTemplate.convertAndSend(queueName, solTextMessage);

    }

    public void publishToGivenTopicName(String topicName, String message) throws JMSException {
        SolTextMessage solTextMessage = new SolTextMessage();

        solTextMessage.setText(message);
        jmsTemplate.setPubSubDomain(true);
        jmsTemplate.convertAndSend(topicName, solTextMessage);

    }


}

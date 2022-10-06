package com.ita_acad.solace.listener;


import com.solacesystems.jms.message.SolTextMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;

@Component
public class QueueListener {

    private static final Logger logger = LoggerFactory.getLogger(QueueListener.class);

    @JmsListener(destination = "OOCL/TEAM_C/QUEUE_1/TOPIC_1_SUB", containerFactory = "defaultJmsListenerContainerFactory")
    public void onMessageReceivedForTopic1(SolTextMessage solTextMessage) throws JMSException {
        logger.info("Message processed: "+ solTextMessage.getText());
    }

}

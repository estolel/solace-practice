package com.ita_acad.solace.controller;

import com.ita_acad.solace.publisher.SolacePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.jms.JMSException;

@Controller
@RequestMapping("/queuePub")
public class QueuePublisherController {

    @Autowired
    private SolacePublisher solacePublisher;

//    @PostMapping("/sendMessage")
//    @ResponseBody
//    @ResponseStatus(HttpStatus.ACCEPTED)
//    public String sendMessageToQueue(@RequestBody String messageText) throws JMSException {
//        solacePublisher.publishToGivenQueueName("OOCL/QUEUE_1", messageText);
//        return "Success";
//    }
//
//
//    @PostMapping("/sendMessageTeamB")
//    @ResponseBody
//    @ResponseStatus(HttpStatus.ACCEPTED)
//    public String sendTeamBMessageToQueue(@RequestBody String messageText) throws JMSException {
//        solacePublisher.publishToGivenQueueName("OOCL/TEAM_B/QUEUE_1", messageText);
//        return "Success For Team B PogChamp";
//    }

    @PostMapping("/topic/sendMessage")
    @ResponseBody
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String sendMessageToTopic(@RequestBody String messageText) throws JMSException {
        solacePublisher.publishToGivenTopicName("OOCL/TOPIC_1", messageText);
        return "Success For Team B PogChamp";
    }
}

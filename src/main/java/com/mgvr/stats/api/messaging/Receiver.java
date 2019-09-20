package com.mgvr.stats.api.messaging;

import com.mgvr.stats.api.constants.RabbitmqQueueNames;
import com.mgvr.stats.api.model.kudo.model.Kudo;
import com.mgvr.stats.api.model.user.model.User;
import com.mgvr.stats.api.service.StatsService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Receiver {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private StatsService statsService;

    @RabbitListener(queues = RabbitmqQueueNames.KUDO_RPC_STATS_API_UPDATE_KUDO_QUEUE_NAME)
    public void receiveStatsRequestByUsersApi(String message){
        System.out.println("Recibiendo mensaje: "+ message);
        statsService.updateKudosStats(message);
    }

    @RabbitListener(queues = RabbitmqQueueNames.KUDO_RPC_STATS_API_UPDATE_KUDOS_QUEUE_NAME)
    public void receiveStatsRequestByKudosApi(List<Kudo> message){
        System.out.println("Recibiendo mensaje: "+ message.size());
        for (Kudo item:message) {
            statsService.updateKudosStats(item.getDestino());
        }

    }
}

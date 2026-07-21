package com.pradeep.orderservice.kafka.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class KafkaDebugRunner implements CommandLineRunner {
	private final KafkaListenerEndpointRegistry registry;
	
	@Override
	public void run(String... args) throws Exception {
	System.out.println("========== Kafka Listeners ==========");

    registry.getListenerContainers().forEach(container -> {
        System.out.println("Listener ID : " + container.getListenerId());
        System.out.println("Running     : " + container.isRunning());
        System.out.println("Group Id    : " + container.getGroupId());
        System.out.println("--------------------------------------");
    });
		
	}

}

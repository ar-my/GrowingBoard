//package com.jenson.board;
//
//import com.jenson.board.kafka.consumer.Receiver;
//import com.jenson.board.kafka.producer.Sender;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.kafka.test.context.EmbeddedKafka;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.concurrent.TimeUnit;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@DirtiesContext
//@EmbeddedKafka(
//        partitions = 1,
//        topics = {KafkaTests.SAMPLE_TOPIC}
//
//)
//public class KafkaTests {
//
//    static final String SAMPLE_TOPIC = "sample_topic";
//
//    @Autowired
//    private Receiver receiver;
//
//    @Autowired
//    private Sender sender;
//
//    @Test
//    public void testReceiver() throws InterruptedException {
//        sender.send("Hello ARMY!");
//
//        receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
//        assertThat(receiver.getLatch().getCount()).isEqualTo(0);
//
//    }
//}

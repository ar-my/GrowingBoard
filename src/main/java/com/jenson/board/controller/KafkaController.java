package com.jenson.board.controller;

        import com.jenson.board.kafka.producer.Sender;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RestController;

        import java.util.Optional;

@RestController
@RequestMapping("kafka")
public class KafkaController {

    private Sender sender;

    public KafkaController(Sender sender) {
        this.sender = sender;
    }

    @GetMapping("/{message}")
    public ResponseEntity send(@PathVariable("message") Optional<String> message) {
        message.ifPresent(sender::send);
        return ResponseEntity.ok().build();
    }
}

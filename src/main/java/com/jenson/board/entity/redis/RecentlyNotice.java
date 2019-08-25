package com.jenson.board.entity.redis;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@RedisHash("recently_board")
public class RecentlyNotice implements Serializable {
    @Id
    private String id;
    private long count;

    public RecentlyNotice(long count) {
        this.id = "notice";
        this.count = count;
    }
}
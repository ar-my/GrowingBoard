package com.jenson.board.entity.jpa;

import lombok.*;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Notice extends AuditorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String title;
    @Column
    private String content;
    @Column
    private String userId;

    public Notice(String title, String content, String userId) {
        this.title = title;
        this.content = content;
        this.userId = userId;
    }


}

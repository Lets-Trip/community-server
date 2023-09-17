package trip.community.model;

import jakarta.persistence.*;

@Entity
@Table(name = "reply")
public class Reply extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long replyId;

    private Long userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_id")
    private Comment comment;

    private String content;

    private String type;

    private Long views;

    private Long likeCnt;

}

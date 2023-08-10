
package trip.community.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTime {

    @NotNull
    private ZonedDateTime createdAt;

    @NotNull
    private ZonedDateTime updatedAt;

    @PrePersist
    public void prePersist(){
        this.createdAt = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        this.updatedAt = ZonedDateTime.now(ZoneId.of("Asis/Seoul"));
    }
    @PreUpdate
    public void preUpdate(){
        this.updatedAt = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
    }

}

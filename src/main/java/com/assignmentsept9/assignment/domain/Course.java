package com.assignmentsept9.assignment.domain;

import com.assignmentsept9.assignment.common.Constant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@TypeDef(name = Constant.JSONB, typeClass = JsonBinaryType.class)
public class Course implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
    private Long id;

    String title;
    String description;
    String video_url;

    @Type(type = Constant.JSONB)
    @Column(columnDefinition = Constant.JSONB, name = "topics")
    List<String> topics;

    long duration;
    String category;
}

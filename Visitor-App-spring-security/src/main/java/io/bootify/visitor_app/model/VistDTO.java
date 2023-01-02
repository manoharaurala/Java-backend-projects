package io.bootify.visitor_app.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class VistDTO implements Serializable {

    private Long id;

    private VisitStatus status;

    private LocalDateTime inTime;

    private LocalDateTime outTime;

    @Size(max = 255)
    private String purpose;

    @Size(max = 255)
    private String urlofimage;

    private Integer noOfPeople;

    @NotNull
    private Long flatId;

    @NotNull
    private Long vistor;

}

package com.herokuapp.clickbuschallenge.model.dto.v1;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class PlaceDTO implements Serializable {

    private Long id;

    @NotNull(message = "{not.null}")
    private String name;

    @NotNull(message = "{not.null}")
    private String slug;

    @NotNull(message = "{not.null}")
    private String city;

    @NotNull(message = "{not.null}")
    private String state;

    @ApiModelProperty(example = "2012-12-12T03:00:00.000Z")
    private LocalDateTime createdAt;

    @ApiModelProperty(example = "2012-12-12T03:00:00.000Z")
    private LocalDateTime updatedAt;
}
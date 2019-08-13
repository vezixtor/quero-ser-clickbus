package com.herokuapp.clickbuschallenge.template.dto;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import com.herokuapp.clickbuschallenge.template.CommonTemplateLoader;
import com.herokuapp.clickbuschallenge.model.dto.v1.PlaceDTO;
import static org.apache.commons.lang.math.NumberUtils.*;
import java.time.LocalDateTime;
import java.time.Month;

public class PlaceDTOTemplateLoader implements CommonTemplateLoader {

    @Override
    public void load() {
        Fixture.of(PlaceDTO.class).addTemplate(RULE_VALID, new Rule(){{
            add("id", random(Long.class, range(LONG_ONE, 99999L)));
            add("name", random(RANDOM_STRINGS));
            add("slug", random(RANDOM_STRINGS));
            add("city", random(RANDOM_STRINGS));
            add("state", random(RANDOM_STRINGS));
            add("createdAt", random(LocalDateTime.of(2014, Month.JANUARY, 8, 7, 50, 1), LocalDateTime.of(2018, Month.APRIL, 16, 18, 0, 59)));
            add("updatedAt", random(LocalDateTime.of(2014, Month.JANUARY, 8, 7, 50, 1), LocalDateTime.of(2018, Month.APRIL, 16, 18, 0, 59)));
        }}).addTemplate(RULE_INVALID, new Rule(){{
        }});
    }
}

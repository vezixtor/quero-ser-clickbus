package com.herokuapp.clickbuschallenge.template.entity;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import com.herokuapp.clickbuschallenge.template.CommonTemplateLoader;
import com.herokuapp.clickbuschallenge.model.entity.Place;
import static org.apache.commons.lang.math.NumberUtils.*;
import java.time.LocalDateTime;
import java.time.Month;

public class PlaceTemplateLoader implements CommonTemplateLoader {

    @Override
    public void load() {
        Fixture.of(Place.class).addTemplate(RULE_VALID, new Rule(){{
            add("id", uniqueRandom(LONG_ONE, 99999L));
            add("name", random(RANDOM_STRINGS));
            add("slug", random(RANDOM_STRINGS));
            add("city", random(RANDOM_STRINGS));
            add("state", random(RANDOM_STRINGS));
            add("createdAt", random(LocalDateTime.of(2014, Month.JANUARY, 8, 7, 50, 1), LocalDateTime.of(2018, Month.APRIL, 16, 18, 0, 59)));
            add("updatedAt", random(LocalDateTime.of(2014, Month.JANUARY, 8, 7, 50, 1), LocalDateTime.of(2018, Month.APRIL, 16, 18, 0, 59)));
        }}).addTemplate(RULE_VALID_WITHOUT_ID).inherits(RULE_VALID, new Rule() {{
            add("id", null);
        }}).addTemplate(RULE_VALID_WITHOUT_FK).inherits(RULE_VALID_WITHOUT_ID, new Rule() {{
        }}).addTemplate(RULE_INVALID, new Rule(){{
        }});
    }
}

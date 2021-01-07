package org.assertj;

import java.time.LocalDate;
import java.util.List;

public record Ship(String name, String registration, LocalDate commissioned, List<Crew> crew) {
}

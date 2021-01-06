package org.assertj;

import java.time.LocalDateTime;
import java.util.List;

public record Ship(String name, String registration, LocalDateTime commissioned, List<Crew> crew) {
}

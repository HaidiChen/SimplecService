package personal.haidchen.simplecs;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;


@RedisHash("Blabla")
public record BlablaRec(@Id String id, List<String> lines) {}

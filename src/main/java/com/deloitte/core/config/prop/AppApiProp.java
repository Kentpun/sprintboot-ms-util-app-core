package com.deloitte.core.config.prop;

import java.util.Map;
import org.springframework.boot.context.properties.ConfigurationProperties;
import lombok.Data;


@ConfigurationProperties(prefix = "app")
@Data
public class AppApiProp {
  private Map<String, ApiProp> ext;

  @Data
  public static class ApiProp {
    private String uri;
  }
}

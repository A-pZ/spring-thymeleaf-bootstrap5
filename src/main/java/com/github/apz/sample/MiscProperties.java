package com.github.apz.sample;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 汎用的なプロパティ。今回は検証用にデータ取得にウェイトをつけるのをプロパティで設定。
 */
@Component
@ConfigurationProperties(prefix = "misc")
@Data
public class MiscProperties {
    private int waitMilliSeconds;
}

package everyday1;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

/**
 * 项目字段
 *
 * @author 汪翔 2024-01-24
 * @since 2.6
 */
public class URLDecoderUtils {
    public static String decodeIfNeeded(String url) {
        if (url == null) return null;
        // 检查URL是否包含编码字符
        if (url.contains("%")) {
            try {
                // 尝试解码
                String decodedUrl = URLDecoder.decode(url, StandardCharsets.UTF_8.name());
                // 额外检查: 解码后的URL与原始URL不同
                if (!decodedUrl.equals(url)) {
                    return decodedUrl;
                }
            } catch (IllegalArgumentException e) {
                // 如果解码过程中出现错误，可能意味着它实际上并不是编码过的URL
                return url;
            } catch (UnsupportedEncodingException e) {
                return url;
            }
        }
        // 如果URL看起来不是编码过的，或者解码失败，则返回原始URL
        return url;
    }
}
package base.callback;

/**
 * 回调接口
 */
public interface FetcherCallback {
    void onData(Data data) throws Exception;

    void onError(Throwable throwable);
}

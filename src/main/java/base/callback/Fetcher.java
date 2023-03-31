package base.callback;

/**
 * 具体的业务逻辑
 */
public interface Fetcher {
    void fetchData(FetcherCallback fetcherCallback);
}

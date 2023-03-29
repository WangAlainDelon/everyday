package base.callback;

public class MyFetcher implements Fetcher {

    private Data data;

    public MyFetcher(Data data) {
        this.data = data;
    }

    @Override
    public void fetchData(FetcherCallback fetcherCallback) {
        try {
            fetcherCallback.onData(data);
        } catch (Exception e) {
            fetcherCallback.onError(e);
        }
    }
}

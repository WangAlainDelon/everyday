package base.callback;

public class Work {

    public void doWork() {
        MyFetcher myFetcher = new MyFetcher(new Data());
        myFetcher.fetchData(new FetcherCallback() {
            @Override
            public void onData(Data data) throws Exception {
                System.out.println("业务正常的回调");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("业务不正常的回调");
            }
        });
    }
}

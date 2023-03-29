package base.callback;

public class Work {

    public void doWork() {
        MyFetcher myFetcher = new MyFetcher(new Data());
        myFetcher.fetchData(new FetcherCallback() {
            @Override
            public void onData(Data data) throws Exception {
                test(data);
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("业务不正常的回调" + throwable.getMessage());
            }
        });
    }

    private void test(Data data) {
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
